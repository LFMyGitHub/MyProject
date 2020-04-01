package com.example.mainlibrary;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.commonlibrary.base.BaseFragment;
import com.example.commonlibrary.http.MyObserver;
import com.example.commonlibrary.http.RetrofitUtils;
import com.example.commonlibrary.http.RxHelper;
import com.example.mainlibrary.api.MainLibApiService;

import butterknife.OnClick;

public class MainFragment extends BaseFragment implements MainContract.View {
    private MainContract.Presenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.mainlib_activity_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPresenter = new MainPresenter(this, getActivity());
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @OnClick({com.example.mainlibrary.R2.id.test_mianlib_router})
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.test_mianlib_router){
            RetrofitUtils.newInstance().getRetrofit(MainLibApiService.class)
                    .getNwestJoke()
                    .compose(RxHelper.observableIO2Main(getActivity()))
                    .subscribe(new MyObserver(getActivity()) {
                        @Override
                        public void onSuccess(String json) {
                            Log.i("Test", json);
                        }

                        @Override
                        public void onFailure(Throwable e, String errorMsg) {

                        }
                    });
        }
    }
}
