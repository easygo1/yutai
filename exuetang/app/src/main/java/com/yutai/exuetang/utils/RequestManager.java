package com.yutai.exuetang.utils;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.RequestQueue;

public class RequestManager {

    private static RequestQueue mRequestQueue;

    /**
     * 数据请求的Queue
     *
     * @return
     */
  public   static RequestQueue getInstance() {
        if (mRequestQueue == null) {
            synchronized (RequestManager.class) {
                mRequestQueue = NoHttp.newRequestQueue(5);
            }
        }

        return mRequestQueue;
    }
}
