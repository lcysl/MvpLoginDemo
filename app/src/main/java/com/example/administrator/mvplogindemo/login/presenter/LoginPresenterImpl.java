package com.example.administrator.mvplogindemo.login.presenter;


import com.example.administrator.mvplogindemo.base.BasePresenter;
import com.example.administrator.mvplogindemo.login.contract.LoginContract;
import com.example.administrator.mvplogindemo.login.model.LoginModelImpl;

/**
 * Created by Administrator on 2018\3\22 0022.
 */

public class LoginPresenterImpl extends BasePresenter<LoginContract.ILoginView> implements LoginContract.ILoginPresenter, LoginContract.LoginCallback {

//    private LoginContract.ILoginView loginView;
    private LoginContract.ILoginModel loginModel;

    public LoginPresenterImpl() {
//        this.loginView = loginView;
        loginModel = new LoginModelImpl(this);
    }

    /**
     * 调用M层的login方法实现具体的请求
     * @param userName
     * @param password
     */
    @Override
    public void login(String userName, String password) {
        loginModel.login(userName, password);
    }

    @Override
    public void onLoginResult(boolean result) {
        if(mVeiw != null) {
            mVeiw.onLoginResult(result);
        }
    }
}
