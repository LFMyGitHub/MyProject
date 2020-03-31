package com.example.mainlibrary;

import android.content.Context;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private Context mContext;

    public MainPresenter(MainContract.View view, Context context) {
        this.mView = view;
        this.mContext = context;
    }
}
