package com.yutai.exuetang.model.impl.exuetang;


import com.yutai.exuetang.model.beans.exuetang.User;
import com.yutai.exuetang.model.dao.exuetang.ILoginDAO;
import com.yutai.exuetang.model.dao.exuetang.OnLoginListener;

/**
 * Created by Administrator on 2016/7/26.
 */
public class LoginDAOImpl implements ILoginDAO {
    @Override
    public void login(final String userphone, final String password, final OnLoginListener onLoginListener) {
        //模拟子线程耗时操作
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登陆成功
                if ("ck".equals(userphone) && "123".equals(password)){
                    User user = new User();
                   // user.setUser_phone(userphone);
                    user.setUser_password(password);
                    onLoginListener.loginSuccess(user);
                }else {
                    onLoginListener.loginFailed();
                }
            }
        }.start();
    }
}
