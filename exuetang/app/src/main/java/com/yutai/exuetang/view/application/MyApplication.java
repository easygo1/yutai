package com.yutai.exuetang.view.application;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by ZFG on 2016/7/14.
 */
public class MyApplication extends Application {
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
        initUIL();
    }

    private void initUIL() {
        /*File cacheDir = StorageUtils.getOwnCacheDirectory(this,"Banner/cache/image");//缓存文件夹路径
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCache(new LruMemoryCache(2*1024*1024))
                .memoryCacheSize(2*1024*1024)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .diskCacheSize(50*1024*1024)
                .imageDownloader(new BaseImageDownloader(this,20*60*60,30*60*60))
                .diskCacheFileCount(100)
                .denyCacheImageMultipleSizesInMemory()
                .build();
        ImageLoader.getInstance().init(config);*/
    }
}
