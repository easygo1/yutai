package com.yutai.exuetang.utils.nohttp;


import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.download.DownloadListener;
import com.yolanda.nohttp.download.DownloadQueue;
import com.yolanda.nohttp.download.DownloadRequest;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;

import java.util.List;

public class NohttpHelper {

    private static final String TAG = "NohttpHelper";
    private static NohttpHelper callServer;
    private RequestQueue requestQueue;

    private NohttpHelper() {
        requestQueue = NoHttp.newRequestQueue();
    }

    public synchronized static NohttpHelper getRequestInstance() {
        if (callServer == null)
            callServer = new NohttpHelper();
        return callServer;
    }

    /**
     * 添加一个请求到请求队列.
     *
     * @param context   context用来实例化dialog.
     * @param what      用来标志请求, 当多个请求使用同一个{@link HttpListener}时, 在回调方法中会返回这个what.
     * @param url   请求地址.
     * @param callback  结果回调对象.
     * @param canCancel 是否允许用户取消请求.
     * @param isLoading 是否显示dialog.
     */
    public void get(BaseActivity context, int what, String url, HttpListener<String> callback, boolean canCancel, boolean isLoading){
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);
        if (request != null) {
            request.add("userName", "yolanda");// String类型
            requestQueue.add(what, request, new HttpResponseListener<String>(context, request, callback, canCancel, isLoading));
        }

    }
    public void post(BaseActivity context, int what, String url, HttpListener<String> callback, boolean canCancel, boolean isLoading){
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.POST);
        if (request != null) {
            request.add("userName", "yolanda");// String类型
            request.add("userPass", "yolanda.pass");
            request.add("userAge", 20);// int类型
            request.add("userSex", '1');// char类型，还支持其它类型
            requestQueue.add(what, request, new HttpResponseListener<String>(context, request, callback, canCancel, isLoading));
        }
    }
    public static void upload(){}

    private static DownloadRequest mDownloadRequest;

    //此为单文件下载方法 与多文件下载主要区别在多条目点击暂停上。
    public static void download(String url,String fileFolder,String fileName,boolean isRange,boolean isDeleteOld,DownloadListener downloadListener){
        // 开始下载了，但是任务没有完成，代表正在下载，那么暂停下载。
        if (mDownloadRequest != null && mDownloadRequest.isStarted() && !mDownloadRequest.isFinished()) {
            // 暂停下载。
            mDownloadRequest.cancel();
        } else if (mDownloadRequest == null || mDownloadRequest.isFinished()) {// 没有开始或者下载完成了，就重新下载。

            /**
             * 这里不传文件名称、不断点续传，则会从响应头中读取文件名自动命名，如果响应头中没有则会从url中截取。
             */
            // url 下载地址。
            // fileFolder 文件保存的文件夹。
            // isDeleteOld 发现文件已经存在是否要删除重新下载。
//            mDownloadRequest = NoHttp.createDownloadRequest(Constants.URL_DOWNLOADS[0], AppConfig.getInstance().APP_PATH_ROOT, true);

            /**
             * 如果使用断点续传的话，一定要指定文件名喔。
             */
            // url 下载地址。Constants.URL_DOWNLOADS[0]
            // fileFolder 保存的文件夹。AppConfig.getInstance().APP_PATH_ROOT
            // fileName 文件名。"nohttp.apk"
            // isRange 是否断点续传下载。
            // isDeleteOld 如果发现存在同名文件，是否删除后重新下载，如果不删除，则直接下载成功。
            mDownloadRequest = NoHttp.createDownloadRequest(url, fileFolder,fileName , isRange, isDeleteOld);

            // what 区分下载。
            // downloadRequest 下载请求对象。
            // downloadListener 下载监听。
            NohttpHelper.getDownloadInstance().add(0, mDownloadRequest, downloadListener);

            // 添加到队列，在没响应的时候让按钮不可用。
//            mBtnStart.setEnabled(false);
        }
    }

    public static void downloadList(String [] arrayUrl, String fileFolder, String [] arrayFileName, boolean isRange, boolean isDeleteOld, List<DownloadRequest> requestList, DownloadListener downloadListener){

        for (int i=0;i<arrayUrl.length;i++){
            DownloadRequest downloadRequest = NoHttp.createDownloadRequest(arrayUrl[i], fileFolder,arrayFileName[i] , isRange, isDeleteOld);
            requestList.add(downloadRequest);
            NohttpHelper.getDownloadInstance().add(i, downloadRequest, downloadListener);
        }
    }
    private static DownloadQueue downloadQueue;

    public static DownloadQueue getDownloadInstance() {
        if (downloadQueue == null)
            downloadQueue = NoHttp.newDownloadQueue(2);//同时下载数默认是3个
        return downloadQueue;
    }
    /**
     * 取消这个sign标记的所有请求.
     */
    public void cancelBySign(Object sign) {
        requestQueue.cancelBySign(sign);
    }

    /**
     * 取消队列中所有请求.
     */
    public void cancelAll() {
        requestQueue.cancelAll();
    }

    /**
     * 退出app时停止所有请求.
     */
    public void stopAll() {
        requestQueue.stop();
    }

}
