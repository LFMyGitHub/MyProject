package com.example.mainlibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.concurrent.ExecutionException;

public class TableLayoutUtils {
    /**
     * 从 drawable 获取图片 id 给 Imageview 添加 selector
     *
     * @param context   调用方法的 Activity
     * @param idNormal  默认图片的 id
     * @param idPress   点击图片的 id
     * @param radioButton 点击的 view
     */
    public static void addSelectorFromDrawable(Context context, int idNormal, int idPress, RadioButton radioButton) {
        StateListDrawable drawable = new StateListDrawable();
        Drawable normal = context.getResources().getDrawable(idNormal);
        Drawable press = context.getResources().getDrawable(idPress);
        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        drawable.addState(new int[]{android.R.attr.state_selected}, press);
        drawable.addState(new int[]{android.R.attr.state_checked}, press);
        drawable.addState(new int[]{android.R.attr.state_focused}, press);
        drawable.addState(new int[]{-android.R.attr.state_pressed}, normal);
        drawable.setBounds(0, 0, 60, 60);
        radioButton.setCompoundDrawables(null, drawable, null, null);
    }

    /**
     * 给 TextView 设置 selector
     *
     * @param clazz       调用方法的类
     * @param normalColor 获取默认的颜色
     * @param pressColor  获取点击的颜色
     * @param radioButton    点击的 view
     */
    public static void addTVSeletor(final Class clazz, final String normalColor, final String pressColor, final RadioButton radioButton) {
        int[] colors = new int[]{Color.parseColor(pressColor), Color.parseColor(pressColor),
                Color.parseColor(normalColor), Color.parseColor(pressColor)};
        int[][] states = new int[4][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{android.R.attr.state_selected};
        states[2] = new int[]{-android.R.attr.state_checked};
        states[3] = new int[]{android.R.attr.state_checked};
        ColorStateList colorStateList = new ColorStateList(states, colors);
        radioButton.setTextColor(colorStateList);
    }

    /**
     * 从网络获取图片 给 ImageView 设置 selector
     *
     * @param activity  调用方法的对象
     * @param normalUrl 获取默认图片的链接
     * @param pressUrl  获取点击图片的链接
     * @param radioButton 点击的 view
     */
    public static void addSeletorFromNet(final Activity activity, final String normalUrl, final String pressUrl, final RadioButton radioButton) {
        new AsyncTask<Void, Void, Drawable>() {
            @Override
            protected Drawable doInBackground(Void... params) {
                StateListDrawable drawable = new StateListDrawable();
                Drawable normal = loadImageFromNet(activity, normalUrl);
                Drawable press = loadImageFromNet(activity, pressUrl);
                drawable.addState(new int[]{android.R.attr.state_selected}, press);
                drawable.addState(new int[]{android.R.attr.state_checked}, press);
                drawable.addState(new int[]{android.R.attr.state_focused}, press);
                drawable.addState(new int[]{android.R.attr.state_pressed}, press);
                drawable.addState(new int[]{-android.R.attr.state_pressed}, normal);
                return drawable;
            }

            @Override
            protected void onPostExecute(Drawable drawable) {
                super.onPostExecute(drawable);
                drawable.setBounds(0, 0, 60, 60);
                radioButton.setCompoundDrawables(null, drawable, null, null);
            }
        }.execute();
    }

    /**
     * 从网络获取图片
     *
     * @param netUrl 获取图片的链接
     */
    public static Drawable loadImageFromNet(Context context, String netUrl) {
        Drawable drawable = null;
        try {
            drawable = Glide.with(context)
                    .load(netUrl).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)).submit(150, 150).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e) {
        }
        return drawable;
    }
}
