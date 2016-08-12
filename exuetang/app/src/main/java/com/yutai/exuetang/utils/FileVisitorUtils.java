package com.yutai.exuetang.utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/22.
 */
public class FileVisitorUtils {

    public static List<String> filenameList = new ArrayList<String>();
    public static FileVisitorUtils finder = new FileVisitorUtils();
    public static String LocalFilePath = Environment
            .getExternalStorageDirectory().toString()
            + "/exuetangmusic/";//本地文件夹地址

    public static boolean findFile(final String file_path, final String filetype) {
        finder.findFiles(filetype, LocalFilePath, filenameList);
        if (filenameList.size() == 0) {
            Log.e("歌曲文件", "该目录是空的");
            return false;
        } else {
            Log.e("歌曲文件", filenameList.toString());
            if (filenameList.contains(file_path)) {
                Log.e("歌曲文件", "找到该歌曲");
                filenameList.clear();
                return true;
            } else {
                Log.e("歌曲文件", "没找到该歌曲");
                filenameList.clear();
                return false;
            }
        }
    }

    /**
     * 寻找指定目录下，具有指定后缀名的所有文件。
     *
     * @param filenameSuffix      : 文件后缀名
     * @param currentDirUsed      : 当前使用的文件目录
     * @param currentFilenameList ：当前文件名称的列表
     */
    public void findFiles(String filenameSuffix, String currentDirUsed,
                          List<String> currentFilenameList) {
        File dir = new File(currentDirUsed);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                /**
                 * 如果目录则递归继续遍历
                 */
                findFiles(filenameSuffix, file.getAbsolutePath(), currentFilenameList);
            } else {
                /**
                 * 如果不是目录。
                 * 那么判断文件后缀名是否符合。
                 */
                if (file.getAbsolutePath().endsWith(filenameSuffix)) {
                    currentFilenameList.add(file.getAbsolutePath());
                }
            }
        }
    }
}
