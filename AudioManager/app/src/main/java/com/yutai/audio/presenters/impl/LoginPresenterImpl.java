package com.yutai.audio.presenters.impl;

import com.yutai.audio.presenters.dao.LoginPresenter;
import com.yutai.audio.view.iview.ILoginView;

/**
 * Created by 崔凯 on 2016/7/16.
 */
public class LoginPresenterImpl implements LoginPresenter{
    private ILoginView mILoginView;
    @Override
    public void login() {
        mILoginView.showLoading();
    }
}
