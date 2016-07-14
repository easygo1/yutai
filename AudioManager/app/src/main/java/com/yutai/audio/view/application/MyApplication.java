package com.yutai.audio.view.application;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

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
        initUIL();
    }

    private void initUIL() {
        File cacheDir = StorageUtils.getOwnCacheDirectory(this,"Banner/cache/image");//缓存文件夹路径
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCache(new LruMemoryCache(2*1024*1024))
                .memoryCacheSize(2*1024*1024)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .diskCacheSize(50*1024*1024)
                .imageDownloader(new BaseImageDownloader(this,20*60*60,30*60*60))
                .diskCacheFileCount(100)
                .denyCacheImageMultipleSizesInMemory()
                .build();
        ImageLoader.getInstance().init(config);
    }
}
