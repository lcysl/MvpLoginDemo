package com.example.administrator.mvplogindemo.login.model;


import com.example.administrator.mvplogindemo.login.contract.LoginContract;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018\3\22 0022.
 */

public class LoginModelImpl implements LoginContract.ILoginModel {

    private LoginContract.LoginCallback mLoginCallback;

    public LoginModelImpl(LoginContract.LoginCallback loginCallback) {
        this.mLoginCallback = loginCallback;
    }

    @Override
    public void login(String userName, String password) {
//        OkHttpClient okHttpClient = new OkHttpClient();
//        FormBody formBody = new FormBody.Builder()
//                .add("phone", userName)
//                .add("passport_code", password)
//                .build();
//        Request request = new Request.Builder()
//                .post(formBody)
//                .url("https://api.uniqueway.com/api/app3/v1/users/sign_in.json")
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                mLoginCallback.onLoginResult(false);
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                mLoginCallback.onLoginResult(true);
//            }
//        });

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);
        OkHttpClient mOkHttpClient = builder.build();
        Request.Builder requestBuilder = new Request.Builder().url("http://gank.io/api/data/Android/10/1");
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        //3、创建call
        Call mCall = mOkHttpClient.newCall(request);
        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mLoginCallback.onLoginResult(false);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mLoginCallback.onLoginResult(true);
            }
        });
    }


}
