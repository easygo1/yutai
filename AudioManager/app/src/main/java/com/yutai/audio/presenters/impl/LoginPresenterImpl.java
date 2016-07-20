package com.yutai.audio.presenters.impl;

import android.os.Handler;

import com.yutai.audio.model.beans.user.User;
import com.yutai.audio.model.dao.ILoginDAO;
import com.yutai.audio.model.dao.OnLoginListener;
import com.yutai.audio.model.impl.LoginDAOImpl;
import com.yutai.audio.presenters.dao.LoginPresenter;
import com.yutai.audio.view.activity.LoginActivity;
import com.yutai.audio.view.iview.ILoginView;

/**
 * Created by 崔凯 on 2016/7/16.
 */
public class LoginPresenterImpl implements LoginPresenter{
    private ILoginDAO mILoginDAO;
    private ILoginView mILoginView;
    //当创建一个新的Handle实例时，他会绑定到当前线程和消息的队列中，开始分发数据
    private Handler mHandler = new Handler();

    public LoginPresenterImpl(ILoginView ILoginView) {
        this.mILoginView = ILoginView;
        this.mILoginDAO = new LoginDAOImpl();
    }

    @Override
    public void login() {
        mILoginView.showLoading();
        mILoginDAO.login(mILoginView.getUserphone(), mILoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程中执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mILoginView.toMainActivity(user);
                        mILoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                //需要在UI线程中执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mILoginView.showFailedError();
                        mILoginView.hideLoading();
                    }
                });
            }
        });
    }
}
