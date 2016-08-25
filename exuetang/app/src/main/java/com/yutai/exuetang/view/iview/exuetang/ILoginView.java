package com.yutai.exuetang.view.iview.exuetang;


import android.app.Activity;

import com.yutai.exuetang.model.beans.exuetang.User;

public interface ILoginView {
    String getUserphone();
    String getPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
    Activity getActivity();
}
