package com.yutai.exuetang.model.dao.exuetang;


import com.yutai.exuetang.model.beans.exuetang.User;

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
