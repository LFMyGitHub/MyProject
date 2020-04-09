package com.example.mainlibrary;

import com.example.commonlibrary.base.BasePresenter;
import com.example.commonlibrary.base.BaseView;

public interface MainContract {
    interface View extends BaseView<Presenter>{
        void getToolBarDataSuccess(String json);

        void getMainGridViewDataSuccess(String json);

        void getMainDataSuccess(String json);
    }

    interface Presenter extends BasePresenter{
        void getToolBarData();

        void getMainGridViewData();

        void getMainData();
    }
}
