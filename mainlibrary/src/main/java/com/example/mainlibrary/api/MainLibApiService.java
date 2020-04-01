package com.example.mainlibrary.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MainLibApiService {
    //查询最新笑话
    @Headers({"api:news"})
    @GET(MainLibApi.NEWST_JOKE_URL)
    Observable<ResponseBody> getNwestJoke();
}
