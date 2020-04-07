package com.example.commonlibrary.utils;

import android.content.Context;

public class ResUtils {
    public static int getResource(Context context, String imageName) {
        Context ctx = context;
        int resId = ctx.getResources().getIdentifier(imageName, "mipmap", ctx.getPackageName());
        //如果没有在"mipmap"下找到imageName,将会返回0
        return resId;
    }

    /**
     * 判断一个url是否为图片url
     *
     * @param url
     * @return
     */
    public static boolean isImgUrl(String url) {
        if (url == null || url.trim().length() == 0)
            return false;
        return PatternUtils.IMG_URL.matcher(url).matches();
    }
}
