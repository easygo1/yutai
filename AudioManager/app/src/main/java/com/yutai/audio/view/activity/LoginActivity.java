package com.yutai.audio.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yutai.audio.R;
import com.yutai.audio.model.beans.user.User;
import com.yutai.audio.presenters.dao.LoginPresenter;
import com.yutai.audio.presenters.impl.LoginPresenterImpl;
import com.yutai.audio.utils.ToastUtils;
import com.yutai.audio.view.iview.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView,View.OnClickListener{
    private EditText loginUserphone;
    private EditText loginUserpassword;
    private TextView loginUserregister;
    private TextView loginForgetpassword;
    private Button loginBtn;
    private ProgressBar mProgressBar;
    private LoginPresenter mLoginPresenter = new LoginPresenterImpl(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        addListeners();
    }

    private void addListeners() {
        loginBtn.setOnClickListener(this);
        loginUserregister.setOnClickListener(this);
        loginForgetpassword.setOnClickListener(this);
    }

    private void initViews() {
        loginUserphone = (EditText) findViewById(R.id.login_userphone);
        loginUserpassword = (EditText) findViewById(R.id.login_userpassword);
        loginUserregister = (TextView) findViewById(R.id.login_userregister);
        loginForgetpassword = (TextView) findViewById(R.id.login_forgetpassword);
        loginBtn = (Button) findViewById(R.id.login_btn);
        mProgressBar = (ProgressBar) findViewById(R.id.id_pb_loading);

    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.login_btn:
                //点击了登录按钮
                mLoginPresenter.login();
                break;
            case R.id.login_userregister:
                //点击了注册
                break;
            case R.id.login_forgetpassword:
                //点击了忘记密码
                break;
        }
    }
    @Override
    public String getUserphone() {
        return loginUserphone.getText().toString();
    }

    @Override
    public String getPassword() {
        return loginUserpassword.getText().toString();
    }

    @Override
    public void showLoading() {
        //mProgressBar.setVisibility(View.VISIBLE);
        ToastUtils.showToast(this,"正在登陆....");
        Log.e("cuikai","111");
    }

    @Override
    public void hideLoading() {
       // mProgressBar.setVisibility(View.GONE);
       // ToastUtils.showToast(this,"隐藏正在登陆....");
        Log.e("cuikai","222");
    }

    @Override
    public void toMainActivity(User user) {
        ToastUtils.showToast(this,"跳转到主页面"+user.getUser_phone()+"密码："+user.getUser_password());
        Log.e("cuikai","333");
    }

    @Override
    public void showFailedError() {
        ToastUtils.showToast(this,"登陆失败");
        Log.e("cuikai","444");
    }


}
