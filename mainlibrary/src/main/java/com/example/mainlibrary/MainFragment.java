package com.example.mainlibrary;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.commonlibrary.R2;
import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.utils.AppBarLayoutUtils;
import com.example.commonlibrary.utils.GsonUtils;
import com.example.commonlibrary.utils.ToastUtils;
import com.example.mainlibrary.adapter.HomeToolbarCloseAdapter;
import com.example.mainlibrary.adapter.HomeToolbarGridViewAdapter;
import com.example.mainlibrary.adapter.HomeToolbarOpenAdapter;
import com.example.mainlibrary.entity.HomeToolBarGridViewEntity;
import com.example.mainlibrary.entity.HomeToolbarEntity;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

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
    RecyclerView mCloseRecyclerView;
    @BindView(R2.id.commlib_toolbar_open_rv)
    RecyclerView mOpenRecyclerView;
    private HomeToolbarEntity mHomeToolbarEntity;

    @BindView(R2.id.main_lib_recyclerView_grid_view)
    RecyclerView mGridViewRecyclerView;
    private List<HomeToolBarGridViewEntity> mHomeToolBarGridViewEntities;

    @Override
    protected int getLayoutId() {
        return R.layout.commlib_coordinator_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPresenter = new MainPresenter(this, getActivity());

        mAppBar.addOnOffsetChangedListener(this);

        LinearLayoutManager closeManager = new LinearLayoutManager(getContext());
        closeManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mCloseRecyclerView.setLayoutManager(closeManager);

        GridLayoutManager openManager = new GridLayoutManager(getContext(), 4);
        mOpenRecyclerView.setLayoutManager(openManager);

        GridLayoutManager gridViewManager = new GridLayoutManager(getContext(), 5);
        mGridViewRecyclerView.setLayoutManager(gridViewManager);

        //模拟请求toolbar数据
        if (mPresenter != null) {
            mPresenter.getToolBarData();
            mPresenter.getMainGridViewData();
        }
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @OnClick({})
    public void onClick(View view) {
        int id = view.getId();
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
                mCloseRecyclerView.setAdapter(mHomeToolbarCloseAdapter);
                mOpenRecyclerView.setAdapter(mHomeToolbarOpenAdapter);
            } else {
                mHomeToolbarCloseAdapter.addData(mResultBeans);
                mHomeToolbarOpenAdapter.addData(mResultBeans);
            }
            mHomeToolbarCloseAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                    ToastUtils.showShort(getActivity(), mResultBeans.get(position).getTitle());
                }
            });
            mHomeToolbarOpenAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                    ToastUtils.showShort(getActivity(), mResultBeans.get(position).getTitle());
                }
            });
        }
    }

    private ArrayList<HomeToolBarGridViewEntity> mHomeToolBarGridViewEntityArrayList = new ArrayList<HomeToolBarGridViewEntity>();
    private HomeToolbarGridViewAdapter mHomeToolbarGridViewAdapter;
    @Override
    public void getMainGridViewDataSuccess(String json){
        mHomeToolBarGridViewEntities = GsonUtils.jsonToList(json, HomeToolBarGridViewEntity.class);
        if (mHomeToolBarGridViewEntities != null && mHomeToolBarGridViewEntities.size() > 0) {
            mHomeToolBarGridViewEntityArrayList.clear();
            mHomeToolBarGridViewEntityArrayList.addAll(mHomeToolBarGridViewEntities);
            if (mHomeToolbarGridViewAdapter == null) {
                mHomeToolbarGridViewAdapter = new HomeToolbarGridViewAdapter(getActivity(), R.layout.commlib_toolbar_grid_view_item, mHomeToolBarGridViewEntityArrayList);
                mGridViewRecyclerView.setAdapter(mHomeToolbarGridViewAdapter);
            } else {
                mHomeToolbarGridViewAdapter.addData(mHomeToolBarGridViewEntityArrayList);
            }
            mHomeToolbarGridViewAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                    if(position >= 14){
                        ToastUtils.showShort(getActivity(), "更多");
                    }else {
                        ToastUtils.showShort(getActivity(), mHomeToolBarGridViewEntityArrayList.get(position).getTitle());
                    }
                }
            });
        }
    }
}
