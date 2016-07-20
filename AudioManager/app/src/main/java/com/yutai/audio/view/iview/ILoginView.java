package com.yutai.audio.view.iview;

import com.yutai.audio.model.beans.user.User;

/**
 * Created by 崔凯 on 2016/7/16.
 */
public interface ILoginView {
    String getUserphone();
    String getPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
