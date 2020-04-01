package com.example.newslibrary.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface NewsLibApiService {
    //查询最新笑话
    @Headers({"api:news"})
    @GET(NewsLibApi.WORLD_NEWS_URL)
    Observable<ResponseBody> getWorldNwes(@QueryMap Map<String, String> map);
}
