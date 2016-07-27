package com.yutai.exuetang.view.application;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MyApplication extends Application{
    public static MyApplication mInstance;
    public static Typeface sTypeface;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mInstance = this;
        sTypeface=Typeface.createFromAsset(getAssets(),"fonts/myFont.ttf");
    }
}
