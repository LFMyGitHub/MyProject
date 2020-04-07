package com.example.commonlibrary.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * json数据读取，用来本地模拟数据
 */
public class SimulateNetAPI {
    /**
     * 获取去最原始的数据信息
     * @return json data
     */
    public static String getOriginalFundData(String filename, Context context) {
        InputStream input = null;
        try {
            //taipingyang.json文件名称
            input = context.getAssets().open(filename);
            String json = convertStreamToString(input);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * input 流转换为字符串
     *
     * @param is
     * @return
     */
    private static String convertStreamToString(InputStream is) {
        String s = null;
        try {
            //格式转换
            Scanner scanner = new Scanner(is, "UTF-8").useDelimiter("\\A");
            if (scanner.hasNext()) {
                s = scanner.next();
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}