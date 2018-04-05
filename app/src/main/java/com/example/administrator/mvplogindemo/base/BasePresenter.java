package com.example.administrator.mvplogindemo.base;


/**
 * Created by Administrator on 2018\3\25 0025.
 */

public class BasePresenter<T extends BaseView> implements IPresenter<T> {

    protected T mVeiw;

    @Override
    public void attachView(T view) {
        this.mVeiw = view;
    }

    @Override
    public void detachView() {
        this.mVeiw = null;
    }
}
