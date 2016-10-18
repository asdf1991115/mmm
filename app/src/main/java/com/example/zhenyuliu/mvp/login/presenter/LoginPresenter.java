package com.example.zhenyuliu.mvp.login.presenter;

import android.os.Handler;

import com.example.zhenyuliu.mvp.login.bean.UserBean;
import com.example.zhenyuliu.mvp.login.model.IUserModel;
import com.example.zhenyuliu.mvp.login.model.OnLoginListener;
import com.example.zhenyuliu.mvp.login.model.UserModel;
import com.example.zhenyuliu.mvp.login.view.ILoginView;

/**
 * Created by Zhenyu.Liu on 2016/10/10.
 */
public class LoginPresenter {

    private IUserModel usermodel;
    private ILoginView loginview;
    private Handler hander = new Handler();


    public  LoginPresenter(ILoginView loginview)
    {
        this.loginview = loginview;
        this.usermodel = new UserModel();
    }

    public void login(){

        loginview.showLodding();
        usermodel.login(loginview.getUserName(), loginview.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final UserBean user) {

                hander.post(new Runnable() {
                    @Override
                    public void run() {
                        loginview.toMainActivity(user);
                        loginview.hideLodding();
                    }
                });

            }

            @Override
            public void loginFailed() {

                hander.post(new Runnable() {
                    @Override
                    public void run() {
                        loginview.toFaileError();
                        loginview.hideLodding();
                    }
                });

            }
        });

    }


    public void clear(){
        loginview.clearUserName();
        loginview.clearPassword();
    }
}
