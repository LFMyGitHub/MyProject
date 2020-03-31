package com.example.commonlibrary.base;

/**
 * MVP中view基类接口
 */
public interface BaseView<T> {

    void setPresenter(T presenter);

}
