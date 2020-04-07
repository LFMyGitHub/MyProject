package com.example.mainlibrary;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.commonlibrary.R2;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.http.MyObserver;
import com.example.commonlibrary.http.RetrofitUtils;
import com.example.commonlibrary.http.RxHelper;
import com.example.commonlibrary.utils.AppBarLayoutUtils;
import com.example.commonlibrary.utils.GsonUtils;
import com.example.mainlibrary.adapter.HomeToolbarCloseAdapter;
import com.example.mainlibrary.adapter.HomeToolbarOpenAdapter;
import com.example.mainlibrary.api.MainLibApiService;
import com.example.mainlibrary.entity.HomeToolbarEntity;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MainFragment extends BaseFragment implements MainContract.View, AppBarLayout.OnOffsetChangedListener {
    private MainContract.Presenter mPresenter;

    @BindView(R2.id.commlib_app_bar_layout)
    AppBarLayout mAppBar;
    /**
     * 大布局背景，遮罩层
     */
    @BindView(R2.id.commlib_bg_content)
    View mBgContent;
    /**
     * 展开状态下toolbar显示的内容
     */
    @BindView(R2.id.commlib_include_toolbar_open)
    View mToolbarOpen;
    /**
     * 展开状态下toolbar的遮罩层
     */
    @BindView(R2.id.commlib_bg_toolbar_open)
    View mBgToolbarOpen;
    /**
     * 收缩状态下toolbar显示的内容
     */
    @BindView(R2.id.commlib_include_toolbar_close)
    View mToolbarClose;
    /**
     * 收缩状态下toolbar的遮罩层
     */
    @BindView(R2.id.commlib_bg_toolbar_close)
    View mBgToolbarClose;

    @BindView(R2.id.commlib_toolbar_close_rv)
    RecyclerView mRecyclerView;
    @BindView(R2.id.commlib_toolbar_open_rv)
    RecyclerView mOpenRecyclerView;
    private HomeToolbarEntity mHomeToolbarEntity;

    @Override
    protected int getLayoutId() {
        return R.layout.commlib_coordinator_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPresenter = new MainPresenter(this, getActivity());

        mAppBar.addOnOffsetChangedListener(this);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);

        GridLayoutManager manager1 = new GridLayoutManager(getContext(), 4);
        mOpenRecyclerView.setLayoutManager(manager1);

        //模拟请求toolbar数据
        if (mPresenter != null) {
            mPresenter.getToolBarData();
        }
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    //@OnClick({com.example.mainlibrary.R2.id.test_mianlib_router})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.test_mianlib_router) {
            RetrofitUtils.newInstance().getRetrofit(MainLibApiService.class)
                    .getNwestJoke()
                    .compose(RxHelper.observableIO2Main(getActivity()))
                    .subscribe(new MyObserver(getActivity()) {
                        @Override
                        public void onSuccess(String json) {
                            Log.i("Test", json);
                        }

                        @Override
                        public void onFailure(Throwable e, String errorMsg) {

                        }
                    });
        }
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        AppBarLayoutUtils.onOffsetChanged(appBarLayout, verticalOffset, mToolbarOpen,
                mToolbarClose, mBgToolbarOpen, mBgToolbarClose, mBgContent);
    }

    private ArrayList<HomeToolbarEntity.ResultBean> mResultBeans = new ArrayList<HomeToolbarEntity.ResultBean>();
    private HomeToolbarCloseAdapter mHomeToolbarCloseAdapter;
    private HomeToolbarOpenAdapter mHomeToolbarOpenAdapter;

    @Override
    public void getToolBarDataSuccess(String json) {
        mHomeToolbarEntity = GsonUtils.gsonToBean(json, HomeToolbarEntity.class);
        if (mHomeToolbarEntity != null && mHomeToolbarEntity.getResult().size() > 0) {
            mResultBeans.clear();
            mResultBeans.addAll(mHomeToolbarEntity.getResult());
            if (mHomeToolbarCloseAdapter == null) {
                mHomeToolbarCloseAdapter = new HomeToolbarCloseAdapter(getActivity(), R.layout.commlib_toolbar_item, mResultBeans);
                mHomeToolbarOpenAdapter = new HomeToolbarOpenAdapter(getActivity(), R.layout.commlib_toolbar_content_item, mResultBeans);
                mRecyclerView.setAdapter(mHomeToolbarCloseAdapter);
                mOpenRecyclerView.setAdapter(mHomeToolbarOpenAdapter);
            } else {
                mHomeToolbarCloseAdapter.addData(mResultBeans);
                mHomeToolbarOpenAdapter.addData(mResultBeans);
            }
        }
    }
}
