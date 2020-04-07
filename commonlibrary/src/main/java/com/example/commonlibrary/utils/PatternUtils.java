package com.example.commonlibrary.utils;

import java.util.regex.Pattern;

public class PatternUtils {
    //判断是否是图片
    public final static Pattern IMG_URL = Pattern.compile(".*?(gif|jpeg|png|jpg|bmp)");
}
