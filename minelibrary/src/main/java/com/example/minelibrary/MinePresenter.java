package com.example.minelibrary;

import android.content.Context;

public class MinePresenter implements MineContract.Presenter {
    private MineContract.View mView;
    private Context mContext;

    public MinePresenter(MineContract.View view, Context context) {
        this.mView = view;
        this.mContext = context;
    }
}
