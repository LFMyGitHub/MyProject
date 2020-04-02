package com.example.newslibrary;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.utils.GsonUtils;
import com.example.commonlibrary.widget.view.CustomRefreshFooter;
import com.example.commonlibrary.widget.view.CustomRefreshHeader;
import com.example.newslibrary.adapter.NewsAdapter;
import com.example.newslibrary.entity.NewsEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

public class NewsFragment extends BaseFragment implements NewsContract.View {
    private NewsContract.Presenter mPresenter;

    @BindView(com.example.newslibrary.R2.id.news_lib_main_refreshLayout)
    RefreshLayout mRefreshLayout;
    @BindView(com.example.newslibrary.R2.id.news_lib_main_recyclerView)
    RecyclerView mRecycleListView;
    @BindView(com.example.newslibrary.R2.id.newslib_floatbutton)
    FloatingActionButton floatingActionButton;

    @Override
    protected int getLayoutId() {
        return R.layout.newslib_activity_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPresenter = new NewsPresenter(this, getActivity());
        mRefreshLayout.setRefreshHeader(new CustomRefreshHeader(getActivity(),null));
        mRefreshLayout.setRefreshFooter(new CustomRefreshFooter(getActivity(),null));
        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page += 1;
                getWorldNews(page,20, false);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                getWorldNews(page,20, false);
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleListView.setLayoutManager(manager);
        //间隔设置0,以前为20,现在新闻列表要分页加载，不能放在头部中，新闻列表数据必须放在mRefrushRecycleView
        //mRecycleListView.addItemDecoration(new SpaceItemDecoration(0));

        mRecycleListView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //获得recyclerView的线性布局管理器
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //获取到第一个item的显示的下标  不等于0表示第一个item处于不可见状态 说明列表没有滑动到顶部 显示回到顶部按钮
                int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // 判断是否滚动超过一屏
                    if (firstVisibleItemPosition == 0) {
                        floatingActionButton.hide();
                    } else {
                        //显示回到顶部按钮
                        floatingActionButton.show();
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mRecycleListView.scrollToPosition(0);
                                floatingActionButton.hide();
                            }
                        });
                    }
                }
            }
        });

        getWorldNews(page,20, true);
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {

    }

    private void getWorldNews(int page, int rows, boolean isLoading){
        if (mPresenter != null) {
            mPresenter.getWorldNwes(page, rows, isLoading);
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
            }else {
                mNewsAdapter.addData(mResultBeans);
            }
            if(page == 1){
                mRefreshLayout.finishRefresh();
            }else {
                mRefreshLayout.finishLoadMore();
            }
        }
    }
}
