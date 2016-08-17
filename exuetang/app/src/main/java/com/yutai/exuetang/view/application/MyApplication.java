package com.yutai.exuetang.view.application;

import android.app.Application;
import android.graphics.Typeface;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.download.DownloadQueue;
import com.yolanda.nohttp.rest.RequestQueue;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MyApplication extends Application{
    public static MyApplication mInstance;
    public static Typeface sTypeface;
    public static String url = "http://192.168.0.104:8080/exuetangWeb";
    public static DownloadQueue downloadQueue;//下载队列
    public static RequestQueue queue = null;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化nohttp
        NoHttp.init(this);
        Logger.setDebug(true);// 开始NoHttp调试模式, 这样就能看到请求过程和日志
        init();
        downloadQueue=NoHttp.newDownloadQueue();
    }

    private void init() {
        mInstance = this;
        sTypeface=Typeface.createFromAsset(getAssets(),"fonts/myFont.ttf");
    }
}
