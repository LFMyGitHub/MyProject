package com.example.newslibrary;

import android.content.Context;
import android.util.Log;

import com.example.commonlibrary.http.MyObserver;
import com.example.commonlibrary.http.RetrofitUtils;
import com.example.commonlibrary.http.RxHelper;
import com.example.commonlibrary.utils.GsonUtils;
import com.example.newslibrary.api.NewsLibApiService;
import com.example.newslibrary.entity.NewsEntity;

import java.util.HashMap;
import java.util.Map;

public class NewsPresenter implements NewsContract.Presenter {
    private NewsContract.View mView;
    private Context mContext;

    public NewsPresenter(NewsContract.View view, Context context) {
        this.mView = view;
        this.mContext = context;
    }


    @Override
    public void getWorldNwes(int page, int rows, boolean isLoading) {
        Map map = new HashMap();
        map.put("page", page);
        map.put("rows", rows);
        RetrofitUtils.newInstance().getRetrofit(NewsLibApiService.class)
                .getWorldNwes(map)
                .compose(RxHelper.observableIO2Main(mContext))
                .subscribe(new MyObserver(mContext, isLoading) {
                    @Override
                    public void onSuccess(String json) {
                        mView.getWorldNwesSuccess(json);
                    }

                    @Override
                    public void onFailure(Throwable e, String errorMsg) {

                    }
                });
    }
}
