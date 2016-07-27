package com.yutai.exuetang.view.activity.exuetang;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yutai.exuetang.R;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.iview.exuetang.IRegisterView;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


/*
    1.初始化SMSSDK
    2.创建手机号注册界面
    3.获取注册界面信息
    4.提交验证信息
    5.验证成功显示成功
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,IRegisterView {
    public static final int ChangeButtonWHAT = 1;
    public static final int ResetButtonWHAT = 2;
    public static final int VerificationError = 3;
    public static final int VerificationSuccess = 4;
    private EditText registerPhone;
    private Button verification;
    private EditText registerErificationCode;
    private EditText registerPassword;
    String APPKEY = "151ca272875cf";
    String APPSECRET = "ffd50f8baf28f382b2dc6e7d7c866399";
    //相隔几秒获取验证码
    int shortTime = 0;
    //手机号和验证码字符串，密码字符串
    String mPhoneString,mErificationString,mRegisterPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initSDK();
        initViews();
        addListeners();
    }
    private void initSDK() {
        /**
         *1，初始化SMSSDK
         * public static void initSDK(Context context,java.lang.String appkey,java.lang.String appSecrect,boolean warnOnReadContact)
         * @param context:上下文
         * @param appkey：我们在mob.com创建应用时候生成APP Key
         * @param appSecret：我们在mob.com创建应用时候生成APP Secret
         * @param warnOnReadContact: 是否警告在读取联系人
         */
        SMSSDK.initSDK(this, APPKEY, APPSECRET, true);
        EventHandler eh = new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                if(result == SMSSDK.RESULT_COMPLETE){
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE){
                        //提交验证码成功
                        mHandler.sendEmptyMessage(VerificationSuccess);
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                    }else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                    }
                }else {
                    //验证失败
                    mHandler.sendEmptyMessage(VerificationError);
                    ((Throwable)data).printStackTrace();
                }
            }
        };
    }
    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what){
                case ChangeButtonWHAT:
                    verification.setClickable(false);
                    verification.setText(shortTime+"s后重新获取");
                    break;
                case ResetButtonWHAT:
                    verification.setClickable(true);
                    verification.setText("重新获取");
//                    mTextErificationCode.setText("");
                    break;
                case VerificationError:
                   // show("验证失败，请重新获取验证码！");
                    ToastUtils.showToast(RegisterActivity.this,"验证失败");
                    ToastUtils.showToast(RegisterActivity.this,"验证失败，请重新获取验证码！");
                    break;
                case VerificationSuccess:
                   // show("验证成功！");
                    ToastUtils.showToast(RegisterActivity.this,"验证成功!");
                    break;
            }
        }
    };
    //用于更改获取验证码显示
    public void delay(){
        //每隔60s发送一次
        shortTime = 60;
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    while (true){
                        if(shortTime > 0){
                            mHandler.sendEmptyMessage(ChangeButtonWHAT);
                            sleep(1000);
                            shortTime--;
                        }else {
                            mHandler.sendEmptyMessage(ResetButtonWHAT);
                            return;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    private void initViews() {
        registerPhone = (EditText) findViewById(R.id.register_phone);
        //verification = (Button) findViewById(R.id.verification);
        //registerErificationCode = (EditText) findViewById(R.id.register_erification_code);
       // registerPassword = (EditText) findViewById(R.id.register_password);

    }
    private void addListeners() {
        verification.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            /*case R.id.verification:
                //点击了获取验证码按钮
                mPhoneString = registerPhone.getText().toString();
                SMSSDK.getVerificationCode("86", mPhoneString,null);//获取验证码
                //获取验证码后，设置不让获取
                ToastUtils.showToast(RegisterActivity.this,"注册号码为"+ mPhoneString);
                delay();
                break;*/
        }
    }

    @Override
    public void toNextActivity() {
        Intent intent = new Intent();
        //跳转到下一个界面
        intent.setClass(this, RegisterActivity2.class);
        startActivity(intent);
    }

    @Override
    public String getUserPhone() {
        return mPhoneString;
    }
}
