package com.example.newslibrary;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseNativeActivity;

import androidx.fragment.app.Fragment;

@Route(path = "/newslibrary/mainactivity")
public class NewsActivity extends BaseNativeActivity {
    private NewsFragment mNewsFragment;

    @Override
    protected int getContentViewId() {
        return com.example.commonlibrary.R.layout.fragment_content;
    }

    @Override
    protected Fragment getFragment() {
        mNewsFragment = new NewsFragment();
        return mNewsFragment;
    }

    @Override
    protected int getFragmentContentId() {
        return com.example.commonlibrary.R.id.contentFrame;
    }
}
