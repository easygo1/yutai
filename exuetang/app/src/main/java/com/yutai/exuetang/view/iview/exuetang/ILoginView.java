package com.yutai.exuetang.view.iview.exuetang;


import com.yutai.exuetang.model.beans.exuetang.User;

public interface ILoginView {
    String getUserphone();
    String getPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
