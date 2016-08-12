/*
 * Copyright 2015 Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yutai.exuetang.utils.nohttp;

import android.content.DialogInterface;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

public class HttpResponseListener<T> implements OnResponseListener<T> {

    private BaseActivity mActivity;
    /**
     * Dialog.
     */
    private WaitDialog mWaitDialog;
    /**
     * Request.
     */
    private Request<?> mRequest;
    /**
     * 结果回调.
     */
    private HttpListener<T> callback;

    /**
     * @param activity     context用来实例化dialog.
     * @param request      请求对象.
     * @param httpCallback 回调对象.
     * @param canCancel    是否允许用户取消请求.
     * @param isLoading    是否显示dialog.
     */
    public HttpResponseListener(BaseActivity activity, Request<?> request, HttpListener<T> httpCallback, boolean canCancel, boolean isLoading) {
        this.mActivity = activity;
        this.mRequest = request;
        if (activity != null && isLoading) {
            mWaitDialog = new WaitDialog(activity);
            mWaitDialog.setCancelable(canCancel);
            mWaitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    mRequest.cancel();
                }
            });
        }
        this.callback = httpCallback;
    }

    /**
     * 开始请求, 这里显示一个dialog.
     */
    @Override
    public void onStart(int what) {
        if (mWaitDialog != null && !mActivity.isFinishing() && !mWaitDialog.isShowing())
            mWaitDialog.show();
    }

    /**
     * 结束请求, 这里关闭dialog.
     */
    @Override
    public void onFinish(int what) {
        if (mWaitDialog != null && mWaitDialog.isShowing())
            mWaitDialog.dismiss();
    }

    /**
     * 成功回调.
     */
    @Override
    public void onSucceed(int what, Response<T> response) {
        int responseCode = response.getHeaders().getResponseCode();
        if (responseCode > 400 && mActivity != null) {
            if (responseCode == 405) {// 405表示服务器不支持这种请求方法，比如GET、POST、TRACE中的TRACE就很少有服务器支持。
                mActivity.showMessageDialog("request 成功", "服务器拒绝");
            } else {// 但是其它400+的响应码服务器一般会有流输出。
                mActivity.showWebDialog(response);
            }
        }
        if (callback != null) {
            callback.onSucceed(what, response);
        }
    }

    /**
     * 失败回调.
     */
    @Override
    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
//        if (exception instanceof NetworkError) {// 网络不好
//            Snackbar.show(mActivity, "请检查网络。");
//        } else if (exception instanceof TimeoutError) {// 请求超时
//            Snackbar.show(mActivity, "请求超时，网络不好或者服务器不稳定。");
//        } else if (exception instanceof UnKnownHostError) {// 找不到服务器
//            Snackbar.show(mActivity, "未发现指定服务器。");
//        } else if (exception instanceof URLError) {// URL是错的
//            Snackbar.show(mActivity, "URL错误。");
//        } else if (exception instanceof NotFoundCacheError) {
//            // 这个异常只会在仅仅查找缓存时没有找到缓存时返回
//            Snackbar.show(mActivity, "没有发现缓存。");
//        } else if (exception instanceof ProtocolException) {
//            Snackbar.show(mActivity, "系统不支持的请求方式。");
//        } else {
//            Snackbar.show(mActivity, "未知错误。");
//        }
        Logger.e("错误：" + exception.getMessage());
        if (callback != null)
            callback.onFailed(what, url, tag, exception, responseCode, networkMillis);
    }

}
