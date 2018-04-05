package com.example.administrator.mvplogindemo.login.contract;

import com.example.administrator.mvplogindemo.base.BaseView;
import com.example.administrator.mvplogindemo.base.IPresenter;

/**
 * Created by Administrator on 2018\3\22 0022.
 */

public class LoginContract {

    // M->P huidiao
    public interface LoginCallback {
        void onLoginResult(boolean result);
    }

    public interface ILoginModel {
        void login(String userName, String password);
    }

    public interface ILoginPresenter {
        void login(String userName, String password);

    }

    // P->Activity huidiao
    public interface ILoginView extends BaseView{
        void onLoginResult(boolean result);
    }

}
