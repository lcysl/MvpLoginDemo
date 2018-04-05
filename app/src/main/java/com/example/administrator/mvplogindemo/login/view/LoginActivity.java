package com.example.administrator.mvplogindemo.login.view;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mvplogindemo.base.BaseActivity;
import com.example.administrator.mvplogindemo.login.contract.LoginContract;
import com.example.administrator.mvplogindemo.R;

import com.example.administrator.mvplogindemo.login.presenter.LoginPresenterImpl;

public class LoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginContract.ILoginView, View.OnClickListener{

    private EditText etUserName;
    private EditText etPassword;
    private Button btLogin;

    @Override
    protected void initPresenter() {
        mPresenter = new LoginPresenterImpl();
        mPresenter.attachView(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initData();
        initView();
        setListener();
    }

    private void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    private void initView() {
        etUserName = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);
    }

    private void setListener() {
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //点击按钮执行post请求
        //此时调用P层的login方法,把从输入框获得的请求参数传进去
        mPresenter.login(etUserName.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void onLoginResult(boolean result) {
        if (result) {
            Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


}
