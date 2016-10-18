package com.example.zhenyuliu.mvp.login.model;

import com.example.zhenyuliu.mvp.login.bean.UserBean;

/**
 * Created by Zhenyu.Liu on 2016/10/10.
 */
public interface OnLoginListener {

    void loginSuccess(UserBean user);

    void loginFailed();

}
