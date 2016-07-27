package com.yutai.exuetang.presenter.impl.exuetang;

import android.os.Handler;

import com.yutai.exuetang.model.beans.exuetang.User;
import com.yutai.exuetang.model.dao.exuetang.ILoginDAO;
import com.yutai.exuetang.model.dao.exuetang.OnLoginListener;
import com.yutai.exuetang.model.impl.exuetang.LoginDAOImpl;
import com.yutai.exuetang.presenter.dao.exuetang.LoginPresenter;
import com.yutai.exuetang.view.iview.exuetang.ILoginView;


public class LoginPresenterImpl implements LoginPresenter {
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
