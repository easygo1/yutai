package com.yutai.exuetang.model.impl.audio;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.error.NetworkError;
import com.yolanda.nohttp.error.NotFoundCacheError;
import com.yolanda.nohttp.error.ServerError;
import com.yolanda.nohttp.error.TimeoutError;
import com.yolanda.nohttp.error.URLError;
import com.yolanda.nohttp.error.UnKnownHostError;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.model.dao.audio.IAudioTwoStyleDetailDAO;
import com.yutai.exuetang.model.dao.audio.TwoListener;
import com.yutai.exuetang.model.dao.audio.TypePathListener;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.utils.nohttp.WaitDialog;
import com.yutai.exuetang.view.application.MyApplication;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZFG on 2016/7/16.
 */
public class AudioTwoStyleDetailDAOImpl implements IAudioTwoStyleDetailDAO {
    public static final int UPDATE_AUDITION_NUM = 2;
    public static final int GET_MUSICTYPE2_PATH = 3;
    //自定义一个dialog
    private WaitDialog mDialog;
    private Activity mActivity;
    public static final int GET_MUSIC_LIST_WHAT = 1;

    private List<Music> mMusicList = new ArrayList<>();
    private String type2_path="";
    public String mPath = MyApplication.url + "/audioservlet";
    //网络请求队列
    private RequestQueue requestQueue;
    Request<String> request;
    public OnResponseListener<String> onResponseListener = new OnResponseListener<String>() {
        @Override
        public void onStart(int what) {
            // 请求开始，这里可以显示一个dialog
            mDialog.show();
        }
        @Override
        public void onSucceed(int what, Response<String> response) {

            switch (what) {
                case GET_MUSIC_LIST_WHAT:
                    String result = response.get();// 响应结果
                    //获取音乐
//                    Log.e("music:::::", result);
                    //把JSON格式的字符串改为Student对象
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Music>>() {
                    }.getType();
                    mMusicList=gson.fromJson(result, type);
//                    Log.e("网络请求mMusicList",mMusicList.toString());
//                    setMusicList(mMusicList);
                    if(mMusicList!=null){
                        if(mMusicList.size()==0){
                            ToastUtils.showToast(mActivity,"没有数据了");
                        }
                    }
                    break;
                case UPDATE_AUDITION_NUM:
                    String result1 = response.get();// 响应结果
                    Log.e("更新在线量结果",result1);
                    if(result1.equals("true")){
//                    数据库更新成功
                    }
                    break;
                case GET_MUSICTYPE2_PATH:
                    String result2 = response.get();// 响应结果
                    if(!result2.equals("error")){
                        type2_path=result2;
                    }
                    Log.e("二级图片地址",type2_path);
                    break;
            }
        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
           /* if (exception instanceof ClientError) {// 客户端错误
                ToastUtils.showToast(mActivity, "客户端错误");
            } else */if (exception instanceof ServerError) {// 服务器错误
                ToastUtils.showToast(mActivity, "服务器错误");
            } else if (exception instanceof NetworkError) {// 网络不好
                ToastUtils.showToast(mActivity, "网络不好");
            } else if (exception instanceof TimeoutError) {// 请求超时
                ToastUtils.showToast(mActivity, "请求超时");
            } else if (exception instanceof UnKnownHostError) {// 找不到服务器
                ToastUtils.showToast(mActivity, "找不到服务器");
            } else if (exception instanceof URLError) {// URL是错的
                ToastUtils.showToast(mActivity, "URL是错的");
            } else if (exception instanceof NotFoundCacheError) {
                ToastUtils.showToast(mActivity, "没有发现缓存");
                // 这个异常只会在仅仅查找缓存时没有找到缓存时返回
            } else {
                ToastUtils.showToast(mActivity, "未知错误");
            }
        }

        @Override
        public void onFinish(int what) {
            mDialog.dismiss();
        }
    };

    @Override
    public void getData(final String type1, final String type2, final int tabstyle, final int cur, final TwoListener twoListener, Activity mactivity) {
        mActivity=mactivity;
        mDialog = new WaitDialog(mActivity);//提示框
        // 创建请求队列, 默认并发3个请求,传入你想要的数字可以改变默认并发数, 例如NoHttp.newRequestQueue(1);
        requestQueue = NoHttp.newRequestQueue();
        // 创建请求对象
        request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "selecttwoStyleMusic");
        request.add("type1", type1);
        request.add("type2", type2);
        request.add("cur", cur);
        request.add("tabstyle", tabstyle);
        requestQueue.add(GET_MUSIC_LIST_WHAT, request, onResponseListener);
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    while (true) {
                        if (mMusicList.size()!=0) {
                            Log.e("cuikaiup", mMusicList.toString());
                            twoListener.test(mMusicList);
                            return;
                        } else {
                            sleep(1000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    @Override
    public void updateaudition(int music_id,Activity mactivity) {
        mActivity=mactivity;
        mDialog = new WaitDialog(mActivity);//提示框
        // 创建请求队列, 默认并发3个请求,传入你想要的数字可以改变默认并发数, 例如NoHttp.newRequestQueue(1);
        requestQueue = NoHttp.newRequestQueue();
        // 创建请求对象
        request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "updateAuditionNum");
        request.add("music_id", music_id);
        requestQueue.add(UPDATE_AUDITION_NUM, request, onResponseListener);
    }

    @Override
    public void getTypephoto(final String type2, Activity activity, final TypePathListener typePathListener) {
        mActivity=activity;
        mDialog = new WaitDialog(mActivity);//提示框
        // 创建请求队列, 默认并发3个请求,传入你想要的数字可以改变默认并发数, 例如NoHttp.newRequestQueue(1);
        requestQueue = NoHttp.newRequestQueue();
        // 创建请求对象
        request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "gettypephoto");
        request.add("music_type2", type2);
        requestQueue.add(GET_MUSICTYPE2_PATH, request, onResponseListener);
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    while (true) {
                        if (type2_path!="") {
                            Log.e("type_path", type2_path);
                            typePathListener.test(type2_path);
                            return;
                        } else {
                            sleep(1000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}

