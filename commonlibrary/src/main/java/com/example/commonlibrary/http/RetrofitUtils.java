package com.example.commonlibrary.http;

import com.example.commonlibrary.config.AppConstant;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit进行单例封装
 */
public class RetrofitUtils {
    private static final String TAG = "RetrofitUtils";
    private static RetrofitUtils mRetrofitUtils;
    private Retrofit mRetrofit;

    private RetrofitUtils() {
        mRetrofit = initRetrofit(initOkHttp());
    }

    public static RetrofitUtils newInstance() {
        if (mRetrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (mRetrofitUtils == null) {
                    mRetrofitUtils = new RetrofitUtils();
                }
            }
        }
        return mRetrofitUtils;
    }


    public <T> T getRetrofit(Class<T> cls) {
        return mRetrofit.create(cls);
    }

    /**
     * 初始化Retrofit
     */
    @NonNull
    private Retrofit initRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(AppConstant.BASE_API)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 初始化OkHttp
     */
    @NonNull
    private OkHttpClient initOkHttp() {
        return new OkHttpClient().newBuilder()
                .readTimeout(AppConstant.HttpModule.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(AppConstant.HttpModule.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(AppConstant.HttpModule.DEFAULT_TIME, TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(InterceptorUtil.HeaderInterceptor())//添加请求拦截器
                .addInterceptor(InterceptorUtil.RequestInterceptor())//添加请求拦截器
                .addInterceptor(InterceptorUtil.LogInterceptor())//添加打印拦截器
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                .build();
    }
}
