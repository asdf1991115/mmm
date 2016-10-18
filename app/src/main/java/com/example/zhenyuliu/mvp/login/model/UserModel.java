package com.example.zhenyuliu.mvp.login.model;

import com.example.zhenyuliu.mvp.login.bean.UserBean;

/**
 * Created by Zhenyu.Liu on 2016/10/10.
 */
public class UserModel implements IUserModel {

    @Override
    public void login(final String userName, final String password, final OnLoginListener loginListener) {


        new Thread(){
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("12345".equals(userName) && "12345".equals(password))
                {
                    UserBean user = new UserBean();
                    user.setUserName(userName);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
