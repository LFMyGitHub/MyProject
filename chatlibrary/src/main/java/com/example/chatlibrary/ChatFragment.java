package com.example.chatlibrary;

import android.os.Bundle;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;

public class ChatFragment extends BaseFragment implements ChatContract.View {
    private ChatContract.Presenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.chatlib_activity_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPresenter = new ChatPresenter(this, getActivity());
    }

    @Override
    public void setPresenter(ChatContract.Presenter presenter) {

    }
}
