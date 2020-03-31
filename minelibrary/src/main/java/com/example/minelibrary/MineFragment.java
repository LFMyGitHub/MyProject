package com.example.minelibrary;

import android.os.Bundle;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;

public class MineFragment extends BaseFragment implements MineContract.View {
    private MineContract.Presenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.minelib_activity_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPresenter = new MinePresenter(this, getActivity());
    }

    @Override
    public void setPresenter(MineContract.Presenter presenter) {

    }
}
