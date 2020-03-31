package com.example.shoplibrary;

import android.content.Context;

public class ShopPresenter implements ShopContract.Presenter {
    private ShopContract.View mView;
    private Context mContext;

    public ShopPresenter(ShopContract.View view, Context context) {
        this.mView = view;
        this.mContext = context;
    }
}
