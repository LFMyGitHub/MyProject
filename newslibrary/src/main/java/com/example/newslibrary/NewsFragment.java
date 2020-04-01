package com.example.newslibrary;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.commonlibrary.base.BaseFragment;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import butterknife.BindView;

public class NewsFragment extends BaseFragment implements NewsContract.View {
    private NewsContract.Presenter mPresenter;

    @BindView(com.example.newslibrary.R2.id.news_lib_main_refreshLayout)
    RefreshLayout mRefreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.newslib_activity_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPresenter = new NewsPresenter(this, getActivity());

        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mRefreshLayout.finishLoadMore(2000);//传入false表示加载失败
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mRefreshLayout.finishRefresh(2000);//传入false表示刷新失败
            }
        });
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {

    }
}
