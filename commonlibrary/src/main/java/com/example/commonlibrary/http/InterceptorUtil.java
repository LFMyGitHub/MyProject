package com.example.commonlibrary.http;

import android.util.Log;

import com.example.commonlibrary.config.AppConstant;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 拦截器
 */
public class InterceptorUtil {
    private static String TAG = "InterceptorUtil";

    /**
     * 日志拦截器
     * @return
     */
    public static Interceptor LogInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.e(TAG, "request:" + request.toString());
                long t1 = System.nanoTime();
                okhttp3.Response response = chain.proceed(chain.request());
                long t2 = System.nanoTime();
                Log.e(TAG, String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                        response.request().url(), (t2 - t1) / 1e6d, response.headers()));
                okhttp3.MediaType mediaType = response.body().contentType();
                String content = response.body().string();
                Log.e(TAG, "response body:" + content);
                return response.newBuilder()
                        .body(okhttp3.ResponseBody.create(mediaType, content))
                        .build();
            }
        };
    }

    /**
     * 请求拦截器根据API配置header类型动态设置baseurl
     *
     * @return
     */
    public static Interceptor HeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //获取请求request
                Request mRequest = chain.request();
                //获取请求request的创建者builder实例
                Request.Builder builder = mRequest.newBuilder();
                //从request中获取headers
                List<String> headerValues = mRequest.headers("api");
                String host = "";
                if (headerValues != null && headerValues.size() > 0) {
                    //如果有这个header，先将配置的header删除
                    builder.removeHeader("api");
                    //匹配获得新的BaseUrl
                    String headerValue = headerValues.get(0);
                    switch (headerValue) {
                        case "news":
                            host = AppConstant.BASE_API;
                            break;
                    }
                    String scheme;
                    int len = host.length();
                    if (host.startsWith("https://")) {
                        int pos = host.indexOf("https://") + "https://".length();
                        host = host.substring(pos, len);
                    } else {
                        int pos = host.indexOf("http://") + "http://".length();
                        host = host.substring(pos, len);
                    }
                    scheme = "https";
                    //从request中获取原有的HttpUrl实例oldHttpUrl
                    HttpUrl oldHttpUrl = mRequest.url();
                    //重建新的HttpUrl，修改需要修改的url部分
                    HttpUrl newFullUrl = oldHttpUrl
                            .newBuilder()
                            .addQueryParameter("key", AppConstant.APP_JOKE_KEY)//笑话api接口都需要添加appkey
                            .scheme(scheme)
                            .host(host)
                            .build();
                    //然后返回一个response至此结束修改
                    return chain.proceed(builder.url(newFullUrl).build());
                } else {
                    return chain.proceed(mRequest);
                }
            }
        };
    }

    /**
     * 请求拦截器
     * 添加公共请求头
     *
     * @return
     */
    public static Interceptor RequestInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //获取请求request
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                builder.header("content-type", "application/json;charset=utf-8");
                return chain.proceed(builder.build());
            }
        };
    }

    /**
     * 响应拦截器
     *
     * @return
     */
    public static Interceptor ResponseInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //获取请求request
                Request request = chain.request();
                return chain.proceed(request);
            }
        };
    }
}
