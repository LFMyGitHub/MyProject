package com.example.shoplibrary;

import android.os.Bundle;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;

public class ShopFragment extends BaseFragment implements ShopContract.View {
    private ShopContract.Presenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.shoplib_activity_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPresenter = new ShopPresenter(this, getActivity());
    }

    @Override
    public void setPresenter(ShopContract.Presenter presenter) {

    }
}
