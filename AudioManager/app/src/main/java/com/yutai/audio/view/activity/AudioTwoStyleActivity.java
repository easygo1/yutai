package com.yutai.audio.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yutai.audio.R;
import com.yutai.audio.view.application.MyApplication;

//音频二级分类页面
public class AudioTwoStyleActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mTitleBack;
    private TextView mAudioTonghugushi;
    private LinearLayout mTonghuagushiLinerlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_two_style);
        initViews();
        initListener();
    }

    private void initViews() {
        mTitleBack = (ImageView) findViewById(R.id.title_back);
        mAudioTonghugushi = (TextView) findViewById(R.id.audio_tonghugushi);
        mAudioTonghugushi.setTypeface(MyApplication.sTypeface);
        mTonghuagushiLinerlayout = (LinearLayout) findViewById(R.id.tonghuagushi_linerlayout);
    }

    private void initListener() {
        mTitleBack.setOnClickListener(this);
        mTonghuagushiLinerlayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tonghuagushi_linerlayout:
                //跳转页面，需要传值
                intent.setClass(AudioTwoStyleActivity.this, AudioTwoStyleDetailActivity.class);
                startActivity(intent);
                break;
        }
    }
}
