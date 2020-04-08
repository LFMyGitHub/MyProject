package com.example.mainlibrary;

import android.content.Context;

import com.example.commonlibrary.utils.SimulateNetAPI;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private Context mContext;

    public MainPresenter(MainContract.View view, Context context) {
        this.mView = view;
        this.mContext = context;
    }

    @Override
    public void getToolBarData() {
        //模拟数据请求
        String json = SimulateNetAPI.getOriginalFundData("json/toolbardata.json", mContext);
        mView.getToolBarDataSuccess(json);
    }

    @Override
    public void getMainGridViewData() {
        //模拟数据请求
        String json = SimulateNetAPI.getOriginalFundData("json/toolbargridviewdata.json", mContext);
        mView.getMainGridViewDataSuccess(json);
    }
}
