package com.yutai.audio.view.application;

import android.app.Application;

import java.io.File;

/**
 * Created by ZFG on 2016/7/14.
 */
public class MyApplication extends Application {
    public static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mInstance = this;

    }


}
