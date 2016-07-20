package com.yutai.audio.model.dao;

import com.yutai.audio.model.beans.user.User;

/**
 * Created by Administrator on 2016/7/18.
 */
public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
