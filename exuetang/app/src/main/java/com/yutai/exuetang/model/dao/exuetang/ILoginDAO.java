package com.yutai.exuetang.model.dao.exuetang;


import android.app.Activity;

public interface ILoginDAO {
    public void login(String userphone, String password, Activity mActivity, OnLoginListener loginListener);
}
