package com.yutai.exuetang.view.activity.exuetang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.yutai.exuetang.R;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.application.MyApplication;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyIntoPhoneActivity extends AppCompatActivity {

    @Bind(R.id.my_info_back_image)
    ImageView mMyInfoBackImage;
    @Bind(R.id.info_phone_t1)
    TextView mInfoPhoneT1;
    @Bind(R.id.info_phone_t2)
    TextView mInfoPhoneT2;
    @Bind(R.id.info_phone_old)
    TextView mInfoPhoneOld;
    @Bind(R.id.info_phone_old_editview)
    EditText mInfoPhoneOldEditview;
    @Bind(R.id.info_phone_new)
    TextView mInfoPhoneNew;
    @Bind(R.id.info_phone_new_editview)
    EditText mInfoPhoneNewEditview;
    @Bind(R.id.info_phone_code)
    TextView mInfoPhoneCode;
    @Bind(R.id.info_phone_code_editview)
    EditText mInfoPhoneCodeEditview;
    @Bind(R.id.info_phone_code_tv)
    TextView mInfoPhoneCodeTv;
    @Bind(R.id.info_phone_sendok_btn)
    Button mInfoPhoneSendokBtn;
    @Bind(R.id.info_phone_checkbox)
    CheckBox mInfoPhoneCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_into_phone);
        ButterKnife.bind(this);
        initWordsStyle();
    }

    private void initWordsStyle() {
        mInfoPhoneT1.setTypeface(MyApplication.sTypeface);
        mInfoPhoneT2.setTypeface(MyApplication.sTypeface);
        mInfoPhoneOld.setTypeface(MyApplication.sTypeface);
        mInfoPhoneOldEditview.setTypeface(MyApplication.sTypeface);
        mInfoPhoneNew.setTypeface(MyApplication.sTypeface);
        mInfoPhoneNewEditview.setTypeface(MyApplication.sTypeface);
        mInfoPhoneCode.setTypeface(MyApplication.sTypeface);
        mInfoPhoneCodeEditview.setTypeface(MyApplication.sTypeface);
        mInfoPhoneCodeTv.setTypeface(MyApplication.sTypeface);
        mInfoPhoneSendokBtn.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.my_info_back_image, R.id.info_phone_code_tv, R.id.info_phone_sendok_btn, R.id.info_phone_checkbox})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_info_back_image:
                finish();
                break;
            case R.id.info_phone_code_tv:
                ToastUtils.showToast(this,"发送验证码");
                break;
            case R.id.info_phone_sendok_btn:
                ToastUtils.showToast(this,"完成");
                break;
            case R.id.info_phone_checkbox:
                ToastUtils.showToast(this,"同意");
                break;
        }
    }
}
