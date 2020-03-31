package com.example.chatlibrary;

import android.content.Context;

public class ChatPresenter implements ChatContract.Presenter {
    private ChatContract.View mView;
    private Context mContext;

    public ChatPresenter(ChatContract.View view, Context context) {
        this.mView = view;
        this.mContext = context;
    }
}
