package com.example.shoplibrary;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseNativeActivity;

import androidx.fragment.app.Fragment;

@Route(path = "/shoplibrary/mainactivity")
public class ShopActivity extends BaseNativeActivity {

    private ShopFragment mShopFragment;

    @Override
    protected int getContentViewId() {
        return com.example.commonlibrary.R.layout.fragment_content;
    }

    @Override
    protected Fragment getFragment() {
        mShopFragment = new ShopFragment();
        return mShopFragment;
    }

    @Override
    protected int getFragmentContentId() {
        return com.example.commonlibrary.R.id.contentFrame;
    }
}
