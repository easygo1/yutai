package com.yutai.exuetang.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZFG on 2016/8/8.
 */
public class FileUtils {
    /**
     *
     * @param name 文件名称
     * @param fileAbsolutePath 当前目录
     * @param fileType 文件类型
     * @return
     */
    public static boolean isExitsFile(String name, String fileAbsolutePath, String fileType) {
        List<String> ListFile = new ArrayList<>();
        File file = new File(fileAbsolutePath);
        File[] subFile = file.listFiles();
        if(subFile==null){return false;}else{
        for (int iFileLength = 0; iFileLength < subFile.length; iFileLength++) {
            // 判断是否为文件夹
            if (!subFile[iFileLength].isDirectory()) {
                String filename = subFile[iFileLength].getName();
                // 判断是否为MP4结尾
                if (filename.trim().toLowerCase().endsWith(fileType)) {
                    ListFile.add(filename);
//                    Log.e("ListFile", ListFile.get(iFileLength).toString());
                }
            }
        }}
        if (ListFile.contains(name)) {
            return true;
        } else {
            return false;
        }
    }
}
