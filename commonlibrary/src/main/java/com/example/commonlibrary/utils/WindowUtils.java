package com.example.commonlibrary.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class WindowUtils {
    //获取屏幕的宽度
    public static int getWindowWidth(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);
        return size.x;
    }

    //获取屏幕的高度
    public static int getWindowHeight(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);
        return size.y;
    }

    public static ViewGroup.LayoutParams getWindowHeight(Context context, View view, int width, float scale){
        ViewGroup.LayoutParams viewLayoutParams = view.getLayoutParams();
        int screenWidth = getWindowWidth(context) - dp2px(width);
        int viewHeight = Math.round(screenWidth / scale);
        viewLayoutParams.width = screenWidth;
        viewLayoutParams.height = viewHeight;
        return viewLayoutParams;
    }

    public static LinearLayout.LayoutParams getLinearLayoutLayoutParams(Context context, LinearLayout.LayoutParams viewLayoutParams, int width, double scale){
        int screenWidth = getWindowWidth(context) - dp2px(width);
        int viewHeight = (int) Math.round(screenWidth / scale);
        viewLayoutParams.width = screenWidth;
        viewLayoutParams.height = viewHeight;
        return viewLayoutParams;
    }

    /**
     * dp转px
     * @param dpValue
     * @return
     */
    public static int dp2px(float dpValue) {
        return (int) (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }
}
