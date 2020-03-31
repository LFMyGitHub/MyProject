package com.example.newslibrary;

import android.content.Context;

public class NewsPresenter implements NewsContract.Presenter {
    private NewsContract.View mView;
    private Context mContext;

    public NewsPresenter(NewsContract.View view, Context context) {
        this.mView = view;
        this.mContext = context;
    }
}
