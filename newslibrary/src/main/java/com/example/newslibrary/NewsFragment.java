package com.example.newslibrary;

import android.os.Bundle;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;

public class NewsFragment extends BaseFragment implements NewsContract.View {
    private NewsContract.Presenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.newslib_activity_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPresenter = new NewsPresenter(this, getActivity());
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {

    }
}
