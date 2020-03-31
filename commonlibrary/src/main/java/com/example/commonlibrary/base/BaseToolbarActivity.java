package com.example.commonlibrary.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.commonlibrary.R;

import androidx.annotation.DrawableRes;

/**
 * 带有Toolbar的Activity基类
 */
public abstract class BaseToolbarActivity extends BaseNativeActivity implements View.OnClickListener {
    private ImageView mIv1, mIv2, mIv3, mIv4;
    private TextView mTv1, mTv2, mTv3, mTv4;

    @Override
    protected void init() {
        super.init();
        initToolBar();
    }

    private void initToolBar() {
        mIv1 = findViewById(R.id.top_view_back);
        mIv2 = findViewById(R.id.img_close);
        mIv3 = findViewById(R.id.img_arrow);
        mIv4 = findViewById(R.id.img_right);
        mTv1 = findViewById(R.id.top_view_tvback);
        mTv2 = findViewById(R.id.top_view_back_text);
        mTv3 = findViewById(R.id.top_view_title);
        mTv4 = findViewById(R.id.top_view_right);

        setListener();
        showIv(1, true);
        showIv(2, false);
        showIv(3, false);
        showIv(4, false);
    }

    /**
     * 设置文字
     *
     * @param type
     * @param text
     */
    public void setText(int type, CharSequence text) {
        switch (type) {
            case 1:
                mTv1.setText(text);
                break;
            case 2:
                mTv2.setText(text);
                break;
            case 3:
                mTv3.setText(text);
                break;
            case 4:
                mTv4.setText(text);
                break;
        }
    }

    /**
     * 设置文字颜色
     *
     * @param textColor
     */
    public void setTextColor(int type, int textColor) {
        switch (type) {
            case 1:
                mTv1.setTextColor(textColor);
                break;
            case 2:
                mTv2.setTextColor(textColor);
                break;
            case 3:
                mTv3.setTextColor(textColor);
                break;
            case 4:
                mTv4.setTextColor(textColor);
                break;
        }
    }

    /**
     * 设置标题栏监听
     */
    private void setListener() {
        mIv1.setOnClickListener(this);
        mIv2.setOnClickListener(this);
        mIv3.setOnClickListener(this);
        mIv4.setOnClickListener(this);
        mTv1.setOnClickListener(this);
        mTv2.setOnClickListener(this);
        mTv3.setOnClickListener(this);
        mTv4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.top_view_back){
            onFristIvClick(view);
        }else if(id == R.id.img_close){
            onSecondIvClick(view);
        }else if(id == R.id.img_arrow){
            onThirdIvClick(view);
        }else if(id == R.id.img_right){
            onFourthIvClick(view);
        }else if(id == R.id.top_view_tvback){
            onFristTvClick(view);
        }else if(id == R.id.top_view_back_text){
            onSecondTvClick(view);
        }else if(id == R.id.top_view_title){
            onThirdTvClick(view);
        }else if(id == R.id.top_view_right){
            onFourthTvClick(view);
        }
    }

    /**
     * 第一张图片点击
     *
     * @param view
     */
    protected void onFristIvClick(View view) {
        onBackPressed();
    }

    /**
     * 第二张图片点击
     *
     * @param view
     */
    protected void onSecondIvClick(View view) {
    }

    /**
     * 第三张图片点击
     *
     * @param view
     */
    protected void onThirdIvClick(View view) {
    }

    /**
     * 第四张图片点击
     *
     * @param view
     */
    protected void onFourthIvClick(View view) {
    }

    /**
     * 第一个文字点击
     *
     * @param view
     */
    protected void onFristTvClick(View view) {
    }

    /**
     * 第二个文字点击
     *
     * @param view
     */
    protected void onSecondTvClick(View view) {
    }

    /**
     * 第三个文字点击
     *
     * @param view
     */
    protected void onThirdTvClick(View view) {
    }

    /**
     * 第四个文字片点击
     *
     * @param view
     */
    protected void onFourthTvClick(View view) {
    }

    /**
     * 设置图片
     *
     * @param type
     * @param resId
     */
    public void setIv(int type, @DrawableRes int resId) {
        switch (type) {
            case 1:
                mIv1.setImageResource(resId);
                break;
            case 2:
                mIv2.setImageResource(resId);
                break;
            case 3:
                mIv3.setImageResource(resId);
                break;
            case 4:
                mIv4.setImageResource(resId);
                break;
        }
    }

    /**
     * 设置左侧图片显示或隐藏
     *
     * @param show
     */
    public void showIv(int type, boolean show) {
        if (show) {
            switch (type) {
                case 1:
                    mIv1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    mIv2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    mIv3.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    mIv4.setVisibility(View.VISIBLE);
                    break;
            }
        } else {
            switch (type) {
                case 1:
                    mIv1.setVisibility(View.GONE);
                    break;
                case 2:
                    mIv2.setVisibility(View.GONE);
                    break;
                case 3:
                    mIv3.setVisibility(View.GONE);
                    break;
                case 4:
                    mIv4.setVisibility(View.GONE);
                    break;
            }
        }
    }

    /**
     * 设置文字显示或隐藏
     *
     * @param show
     */
    public void showTv(int type, boolean show) {
        if (show) {
            switch (type) {
                case 1:
                    mTv1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    mTv2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    mTv3.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    mTv4.setVisibility(View.VISIBLE);
                    break;
            }
        } else {
            switch (type) {
                case 1:
                    mTv1.setVisibility(View.GONE);
                    break;
                case 2:
                    mTv2.setVisibility(View.GONE);
                    break;
                case 3:
                    mTv3.setVisibility(View.GONE);
                    break;
                case 4:
                    mTv4.setVisibility(View.GONE);
                    break;
            }
        }
    }
}
