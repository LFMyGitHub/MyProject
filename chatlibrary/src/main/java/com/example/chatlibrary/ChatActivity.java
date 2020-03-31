package com.example.chatlibrary;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseNativeActivity;

@Route(path = "/chatlibrary/mainactivity")
public class ChatActivity extends BaseNativeActivity {
    private ChatFragment mChatFragment;

    @Override
    protected int getContentViewId() {
        return com.example.commonlibrary.R.layout.fragment_content;
    }

    @Override
    protected Fragment getFragment() {
        mChatFragment = new ChatFragment();
        return mChatFragment;
    }

    @Override
    protected int getFragmentContentId() {
        return com.example.commonlibrary.R.id.contentFrame;
    }
}
