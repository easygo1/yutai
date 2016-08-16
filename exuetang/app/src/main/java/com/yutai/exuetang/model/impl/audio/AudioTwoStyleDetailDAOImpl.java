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
import com.yolanda.nohttp.rest.CacheMode;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.model.dao.audio.IAudioTwoStyleDetailDAO;
import com.yutai.exuetang.model.dao.audio.TwoListener;
import com.yutai.exuetang.model.dao.audio.TypePathListener;
import com.yutai.exuetang.utils.RequestManager;
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
    public static final int GET_MUSIC_LIST_WHAT = 1;
    public static final int UPDATE_AUDITION_NUM = 2;
    public static final int GET_MUSICTYPE2_PATH = 3;
    public String mPath = MyApplication.url + "/audioservlet";
//    Request<String> request;
    //自定义一个dialog
    private WaitDialog mDialog;
    private Activity mActivity;
    private List<Music> mMusicList = new ArrayList<>();
//    private String type2_path = "";
    //网络请求队列
    // 创建请求队列, 默认并发3个请求,传入你想要的数字可以改变默认并发数, 例如NoHttp.newRequestQueue(1);
//    private RequestQueue requestQueue= NoHttp.newRequestQueue();
    private boolean isSucess = false;

    @Override
    public void getData(final String type1, final String type2, final int tabstyle, final int cur, final TwoListener twoListener, Activity mactivity) {
        mActivity = mactivity;
        mDialog = new WaitDialog(mActivity);//提示框
        // 创建请求对象
        Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "selecttwoStyleMusic");
        request.add("type1", type1);
        request.add("type2", type2);
        request.add("cur", cur);
        request.add("tabstyle", tabstyle);
        RequestManager.getInstance().add(GET_MUSIC_LIST_WHAT, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {
// 请求开始，这里可以显示一个dialog
                mDialog.show();
            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                //获取音乐
                String result2 = response.get();// 响应结果
                Log.e("music::", result2);//list
                if (result2.equals("400")) {
                    ToastUtils.showToast(mActivity, "获取数据异常");
                } else if (result2.equals("201")) {
                    ToastUtils.showToast(mActivity, "没有数据了");
                    isSucess = true;
                } else{
                    Log.e("result2", result2);
                    //此时的判断是 有时会出现图片请求的结果 不明白为啥 这样写也不能解决
                    isSucess = true;
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Music>>() {
                    }.getType();
                    mMusicList = gson.fromJson(result2, type);
                   /* myObservable1 =
                            Observable.just(mMusicList);
                    myObservable1.subscribe(onNextAction1);*/
                }
                if (isSucess) {
                    twoListener.test(mMusicList);
                }
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
               /*  if (exception instanceof ClientError) {// 客户端错误
                ToastUtils.showToast(mActivity, "客户端错误");
            } else */
                    if (exception instanceof ServerError) {// 服务器错误
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
        });
    }

    @Override
    public void updateaudition(int music_id, Activity mactivity) {
        mActivity = mactivity;
        mDialog = new WaitDialog(mActivity);//提示框
        // 创建请求对象
        Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "updateAuditionNum");
        request.add("music_id", music_id);
        RequestManager.getInstance().add(UPDATE_AUDITION_NUM, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {
            // 请求开始，这里可以显示一个dialog
                //mDialog.show();
            }

            @Override
            public void onSucceed(int what, Response<String> response) {

            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

            }

            @Override
            public void onFinish(int what) {
//                mDialog.dismiss();
            }
        });
    }

    @Override
    public void getTypephoto(final String type2, Activity activity, final TypePathListener typePathListener) {
        mActivity = activity;
        mDialog = new WaitDialog(mActivity);//提示框
        // 创建请求对象
        Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "gettypephoto");
        request.add("music_type2", type2);
        request.setCacheMode(CacheMode.NONE_CACHE_REQUEST_NETWORK);
        RequestManager.getInstance().add(GET_MUSICTYPE2_PATH, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {
           // 请求开始，这里可以显示一个dialog
                mDialog.show();
            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                Log.e("GET_MUSICTYPE2_PATH",""+what);
                typePathListener.test(response.get());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

            }

            @Override
            public void onFinish(int what) {
                mDialog.dismiss();
            }
        });
        /*onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("asasa",s);
                typePathListener.test(s);
            }
        };*/
    }
}

