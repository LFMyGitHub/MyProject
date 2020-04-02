package com.example.newslibrary;

import com.example.commonlibrary.base.BasePresenter;
import com.example.commonlibrary.base.BaseView;

public interface NewsContract {
    interface View extends BaseView<Presenter> {
        void getWorldNwesSuccess(String json);
    }

    interface Presenter extends BasePresenter {
        void getWorldNwes(int page, int rows, boolean isLoading);
    }
}
