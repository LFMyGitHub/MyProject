package com.example.mainlibrary;

import android.os.Bundle;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;

public class MainFragment extends BaseFragment implements MainContract.View {
    private MainContract.Presenter mPresenter;

    @Override
    protected int getLayoutId() {
        return com.example.minelibrary.R.layout.minelib_activity_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPresenter = new MainPresenter(this, getActivity());
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
