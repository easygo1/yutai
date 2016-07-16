package com.yutai.audio.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.yutai.audio.R;

public class TestActivity extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mImageView= (ImageView) findViewById(R.id.text_image);
        /*Glide.with(this)
                .load("http://www.yooyoo360.com/photo/2009-1-1/20090112132758194.jpg")
                .into(mImageView);*/
        }
}
