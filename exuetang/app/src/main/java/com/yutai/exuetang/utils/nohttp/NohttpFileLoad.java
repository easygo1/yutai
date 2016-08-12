package com.yutai.exuetang.utils.nohttp;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.download.DownloadListener;
import com.yolanda.nohttp.download.DownloadRequest;

import java.util.List;

/**
 * Created by ZFG on 2016/8/4.
 */
public class NohttpFileLoad {
    public static void downloadList(String [] arrayUrl, String fileFolder, String [] arrayFileName, boolean isRange, boolean isDeleteOld, List<DownloadRequest> requestList, DownloadListener downloadListener){

        for (int i=0;i<arrayUrl.length;i++){
            DownloadRequest downloadRequest = NoHttp.createDownloadRequest(arrayUrl[i], fileFolder,arrayFileName[i] , isRange, isDeleteOld);
            requestList.add(downloadRequest);
            NohttpHelper.getDownloadInstance().add(i, downloadRequest, downloadListener);
        }
    }
}
