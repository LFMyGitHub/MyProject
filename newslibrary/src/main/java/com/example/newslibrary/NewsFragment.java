package com.example.newslibrary;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.utils.GsonUtils;
import com.example.newslibrary.adapter.NewsAdapter;
import com.example.newslibrary.entity.NewsEntity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

public class NewsFragment extends BaseFragment implements NewsContract.View {
    private NewsContract.Presenter mPresenter;

    @BindView(com.example.newslibrary.R2.id.news_lib_main_refreshLayout)
    RefreshLayout mRefreshLayout;
    @BindView(com.example.newslibrary.R2.id.news_lib_main_recyclerView)
    SwipeMenuRecyclerView mRecycleListView;

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
                page += 1;
                getWorldNews(page,20);
                mRefreshLayout.finishLoadMore(2000);//传入false表示加载失败
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                getWorldNews(page,20);
                mRefreshLayout.finishRefresh(2000);//传入false表示刷新失败
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleListView.setLayoutManager(manager);
        //间隔设置0,以前为20,现在新闻列表要分页加载，不能放在头部中，新闻列表数据必须放在mRefrushRecycleView
        //mRecycleListView.addItemDecoration(new SpaceItemDecoration(0));

        getWorldNews(page,20);
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {

    }

    private void getWorldNews(int page, int rows){
        if (mPresenter != null) {
            mPresenter.getWorldNwes(page, rows);
        }
    }

    //新闻消息
    private int page = 1;
    private ArrayList<NewsEntity.ResultBean> mResultBeans = new ArrayList<NewsEntity.ResultBean>();
    private NewsAdapter mNewsAdapter;
    @Override
    public void getWorldNwesSuccess(String json) {
        NewsEntity newsEntity = GsonUtils.gsonToBean(json, NewsEntity.class);
        if(newsEntity.getResult() != null && newsEntity.getResult().size() > 0){
            if(page == 1){
                mResultBeans.clear();
            }
            mResultBeans.addAll(newsEntity.getResult());
            if(mNewsAdapter == null){
                mNewsAdapter = new NewsAdapter(R.layout.newslib_news_item, mResultBeans);
                mRecycleListView.setAdapter(mNewsAdapter);
            }
            mNewsAdapter.setNewData(mResultBeans);
        }
    }
}
