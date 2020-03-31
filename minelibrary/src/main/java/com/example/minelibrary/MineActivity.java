package com.example.minelibrary;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseNativeActivity;

import androidx.fragment.app.Fragment;

@Route(path = "/minelibrary/mainactivity")
public class MineActivity extends BaseNativeActivity {
    private MineFragment mMineFragment;

    @Override
    protected int getContentViewId() {
        return com.example.commonlibrary.R.layout.fragment_content;
    }

    @Override
    protected Fragment getFragment() {
        mMineFragment = new MineFragment();
        return mMineFragment;
    }

    @Override
    protected int getFragmentContentId() {
        return com.example.commonlibrary.R.id.contentFrame;
    }
}
