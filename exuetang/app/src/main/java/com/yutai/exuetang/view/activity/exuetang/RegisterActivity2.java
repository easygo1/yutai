package com.yutai.exuetang.view.activity.exuetang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.error.NetworkError;
import com.yolanda.nohttp.error.NotFoundCacheError;
import com.yolanda.nohttp.error.ServerError;
import com.yolanda.nohttp.error.TimeoutError;
import com.yolanda.nohttp.error.URLError;
import com.yolanda.nohttp.error.UnKnownHostError;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.MainActivity;
import com.yutai.exuetang.R;
import com.yutai.exuetang.model.beans.exuetang.User;
import com.yutai.exuetang.utils.RequestManager;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.application.MyApplication;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/7/27.
 */
public class RegisterActivity2 extends AppCompatActivity implements View.OnClickListener {
    private EditText registerPassword;
    private Button registerSuccess;
    String mPhoneString,mRegisterPassword;
    public String mPath = MyApplication.url + "/exuetangservlet";
    public static final int Register = 1;
    User user;
    //偏好设置
    public static final String USER = "user";
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        Intent intent = getIntent();
        mPhoneString = intent.getStringExtra("user_newphone");
        initViews();
        addListeners();
    }

    private void addListeners() {
        registerSuccess.setOnClickListener(this);
    }

    private void initViews() {
        registerPassword = (EditText) findViewById(R.id.register_password);
        registerSuccess = (Button) findViewById(R.id.register_success);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.register_success:
                mRegisterPassword = registerPassword.getText().toString();

                Log.e("123",mRegisterPassword.length()+"shouji"+mPhoneString+"mim"+mRegisterPassword);
                if (mRegisterPassword.length() >= 6 && mRegisterPassword.length() <= 16){
                    //向数据库中传输用户名和密码，
                    startRegisterRequest();
                }else {
                    ToastUtils.showToast(this,"请输入6-16位的密码");
                }

                break;
        }
    }
    /**
     * 请求服务器，并向服务器传输用户名和密码
     */
    private void startRegisterRequest() {
        // 创建请求对象
        Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        //传输从android端获取到的数据
        request.add("methods","register");
        request.add("user_newphone", mPhoneString);
        request.add("user_password", mRegisterPassword);

        //将请求添加到队列中
        RequestManager.getInstance().add(Register, request, onResponseListener);
    }
    private OnResponseListener<String> onResponseListener=new OnResponseListener<String>() {
        @Override
        public void onStart(int what) {

        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            if(what == Register) {//如果请求为注册，则执行注册请求
                //Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                // 请求成功，直接更新UI
                String result = response.get();
                if(result.equals("201")){
                    Toast.makeText(RegisterActivity2.this, "该手机号已注册", Toast.LENGTH_SHORT).show();
                }else if (result.equals("400")){
                    ToastUtils.showToast(RegisterActivity2.this,"服务器异常");
                }else {
                    //把JSON格式的字符串改为对象
                    Gson gson = new Gson();
                    Type mytype = new TypeToken<User>() {
                    }.getType();
                    user=gson.fromJson(result,mytype);
                    Toast.makeText(RegisterActivity2.this, "登录成功", Toast.LENGTH_SHORT).show();
                    //登录成功后进行页面的跳转
                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity2.this, MainActivity.class);
                    startActivity(intent);

                    //第一个参数：偏好设置文件的名称；第二个参数：文件访问模式
                    mSharedPreferences = getSharedPreferences(USER,MODE_PRIVATE);
                    //向偏好设置文件中保存数据
                    mEditor = mSharedPreferences.edit();
                    mEditor.putInt("user_id",user.getUser_id());
                    //提交保存结果
                    mEditor.commit();
                }

            }
        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
            /*if (exception instanceof ClientError) {// 客户端错误
                Toast.makeText(RegisterActivity2.this, "客户端发生错误", Toast.LENGTH_SHORT).show();
            } else*/ if (exception instanceof ServerError) {// 服务器错误
                Toast.makeText(RegisterActivity2.this, "服务器发生错误", Toast.LENGTH_SHORT).show();
            } else if (exception instanceof NetworkError) {// 网络不好
                Toast.makeText(RegisterActivity2.this, "请检查网络", Toast.LENGTH_SHORT).show();

            } else if (exception instanceof TimeoutError) {// 请求超时
                Toast.makeText(RegisterActivity2.this, "请求超时，网络不好或者服务器不稳定", Toast.LENGTH_SHORT).show();
            } else if (exception instanceof UnKnownHostError) {// 找不到服务器
                Toast.makeText(RegisterActivity2.this, "未发现指定服务器", Toast.LENGTH_SHORT).show();
            } else if (exception instanceof URLError) {// URL是错的
                Toast.makeText(RegisterActivity2.this, "URL错误", Toast.LENGTH_SHORT).show();
            } else if (exception instanceof NotFoundCacheError) {
                Toast.makeText(RegisterActivity2.this, "没有发现缓存", Toast.LENGTH_SHORT).show();
                // 这个异常只会在仅仅查找缓存时没有找到缓存时返回
            } else {
                Toast.makeText(RegisterActivity2.this, "未知错误", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFinish(int what) {

        }
    };
}
