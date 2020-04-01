package com.example.commonlibrary.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.commonlibrary.config.AppConstant;
import com.example.commonlibrary.utils.ActivityUtils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 原生Activity基类
 */
public abstract class BaseNativeActivity extends BaseActivity {

    public SharedPreferences mShared;
    public SharedPreferences.Editor mEditor;
    private Unbinder mUnbinder;

    /**
     * 布局文件Id
     *
     * @return
     */
    protected abstract int getContentViewId();

    /**
     * 获取fragment
     *
     * @return
     */
    protected abstract Fragment getFragment();

    /**
     * 布局中Fragment的ID
     *
     * @return
     */
    protected abstract int getFragmentContentId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatusBar();
        setContentView(getContentViewId());
        mUnbinder = ButterKnife.bind(this);
        mShared = getSharedPreferences(AppConstant.UserInfoModule.USER_INFO, 0);
        mEditor = mShared.edit();
        // 处理传过来的intent
        handleIntent(getIntent());
        // 将fragment添加到activity
        addFragmentToActivity();
        // 后续初始化操作
        init();
    }

    private void addFragmentToActivity() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(getFragmentContentId());
        if (fragment == null) {
            fragment = getFragment();
            if (fragment != null) {
                ActivityUtils.addFragmenttoActivity(
                        getSupportFragmentManager(),
                        fragment,
                        getFragmentContentId()
                );
            }


        }
    }

    public void replaceFragmentToActivity() {
        Fragment fragment = getFragment();
        if (fragment != null) {
            ActivityUtils.replaceFragment(
                    getSupportFragmentManager(),
                    fragment,
                    getFragmentContentId()
            );
        }
    }

    /**
     * 获取Intent
     *
     * @param intent
     */
    protected void handleIntent(Intent intent) {
    }

    /**
     * 加载完fragment之后进行一些初始化操作
     */
    protected void init() {
    }


    /**
     * 初始化系统状态栏
     * 在4.4以上版本是否设置透明状态栏
     */
    private void initStatusBar() {
        if (!setTranslucentStatusBar()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    /**
     * 设置透明状态栏
     *
     * @return true 设置, false 不设置, 默认为false
     */
    protected boolean setTranslucentStatusBar() {
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
