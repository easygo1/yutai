package com.yutai.exuetang.utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/17.
 */
public class FileFindAllMusic {
    //返回本地yutai文件夹下面的所有音乐的名字
    public static List<String> mList;
    public static String LocalFilePath = Environment
            .getExternalStorageDirectory().toString()
            + "/yutai/music/";//本地文件夹地址
    public static List<String> getAllMusicName(){
        File file = new File(LocalFilePath);
        return findMP3(file);
    }
    private static List<String> findMP3(File path){
        mList = new ArrayList<>();
        String musicName = null;
        //从本地搜索MP3
        File files[]=path.listFiles();
        if(files != null){
            for(File f:files){
                if(f.isDirectory()){
                    findMP3(f);
                }else{
                    if(f.getPath().endsWith(".mp3")||f.getPath().endsWith(".wma")){
                        if (f.getPath().endsWith(".mp3")){
                            musicName = f.getName().replace(".mp3","");
                            mList.add(musicName);
                        }else if (f.getPath().endsWith(".wma")){
                            musicName = f.getName().replace(".wma","");
                            mList.add(musicName);
                        }
                        }
                    }
                }

            }
        return mList;
        }
}
