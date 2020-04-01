package com.example.commonlibrary.http;

import android.text.TextUtils;
import android.util.Log;

import com.example.commonlibrary.utils.GsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;


/**
 * 对基础数据进行统一处理
 */
public abstract class BaseObserver<T> implements Observer<ResponseBody> {
    private static final String TAG = "BaseObserver";

    @Override
    public void onSubscribe(Disposable d) {
        Log.e(TAG, "onSubscribe");
    }

    @Override
    public void onNext(ResponseBody responseBody) {
        try {
            String json = new String(responseBody.bytes());
            int code = jsonToCode(json);
            if (code == 0 || code == 200) {
                onSuccess(json);
            } else {
                onFailure(null, json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable e) {
        onFailure(e, RxExceptionUtil.exceptionHandler(e));
    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete");
    }

    public abstract void onSuccess(String json);

    public abstract void onFailure(Throwable e, String errorMsg);

    private int jsonToCode(String result) {
        int code = -1;
        JSONObject jsonObject = null;
        if (!TextUtils.isEmpty(result)) {
            try {
                jsonObject = new JSONObject(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (jsonObject != null) {
            BaseResponse baseResponse = GsonUtils.gsonToBean(result, BaseResponse.class);
            code = baseResponse.getError_code();
        }
        return code;
    }
}
