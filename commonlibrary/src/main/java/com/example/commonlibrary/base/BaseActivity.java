package com.example.commonlibrary.base;

import android.content.Intent;
import android.os.Bundle;

import com.example.commonlibrary.utils.ActivityManagerTool;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import androidx.annotation.Nullable;

public class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //入栈
        ActivityManagerTool.getActivityManager().add(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        //设置启动动画
    }

    @Override
    public void finish() {
        super.finish();
        //出栈
        ActivityManagerTool.getActivityManager().popActivity(this);
        //设置关闭动画
    }
}
