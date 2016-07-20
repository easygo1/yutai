package com.yutai.audio.model.dao;

/**
 * Created by 崔凯 on 2016/7/16.
 */
public interface ILoginDAO {
    public void login(String userphone, String password, OnLoginListener loginListener);
}
