package com.example.commonlibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle3.components.support.RxFragment;

import androidx.annotation.Nullable;

public abstract class BaseFragment extends RxFragment {
    protected BaseNativeActivity mActivity;

    protected abstract int getLayoutId();

    protected abstract void initView(View view, Bundle savedInstanceState);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseNativeActivity) {
            this.mActivity = (BaseNativeActivity) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
