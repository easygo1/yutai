package com.yutai.exuetang.model.impl.exuetang;


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
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.model.beans.exuetang.User;
import com.yutai.exuetang.model.dao.exuetang.ILoginDAO;
import com.yutai.exuetang.model.dao.exuetang.OnLoginListener;
import com.yutai.exuetang.utils.RequestManager;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.utils.nohttp.WaitDialog;
import com.yutai.exuetang.view.application.MyApplication;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class LoginDAOImpl implements ILoginDAO {
    public static final int LOGIN_WHAT = 1;
    //自定义一个dialog
    private WaitDialog mDialog;
    public String mPath = MyApplication.url + "/exuetangservlet";
    //定义一个User对象
    User mUser;
    @Override
    public void login(final String userphone, final String password, final Activity mActivity, final OnLoginListener onLoginListener) {
        //模拟子线程耗时操作
        /*new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登陆成功
                if ("ck".equals(userphone) && "123".equals(password)){
                    User user = new User();
                    user.setUser_phone(userphone);
                    user.setUser_password(password);
                    onLoginListener.loginSuccess(user);
                }else {
                    onLoginListener.loginFailed();
                }
            }
        }.start();*/
        mDialog = new WaitDialog(mActivity);//提示框
        // 创建请求对象
        Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "login");
        request.add("user_newphone", userphone);
        request.add("user_password", password);
        Log.e("xinxi",userphone+"----"+password);
        RequestManager.getInstance().add(LOGIN_WHAT, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {
            // 请求开始，这里可以显示一个dialog
                mDialog.show();
            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                //获取User对象
                String result = response.get();// 响应结果
                Log.e("user::", result);//list
                if (result.equals("400")) {
                    ToastUtils.showToast(mActivity, "服务器异常，请稍后再登陆");
                } else if (result.equals("201")) {
                    ToastUtils.showToast(mActivity, "账号或密码错误，请重新填写");
                } else{
                    Log.e("result", result);
                    Gson gson = new Gson();
                    Type type = new TypeToken<User>() {
                    }.getType();
                    mUser = gson.fromJson(result, type);
                    onLoginListener.loginSuccess(mUser);
                   /* myObservable1 =
                            Observable.just(mMusicList);
                    myObservable1.subscribe(onNextAction1);*/
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
}
