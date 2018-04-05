package com.example.administrator.mvplogindemo.base;


/**
 * Created by Administrator on 2018\3\25 0025.
 */

public interface IPresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
