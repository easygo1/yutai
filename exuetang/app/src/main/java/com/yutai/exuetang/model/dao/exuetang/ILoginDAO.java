package com.yutai.exuetang.model.dao.exuetang;


public interface ILoginDAO {
    public void login(String userphone, String password, OnLoginListener loginListener);
}
