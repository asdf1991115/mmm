package com.example.zhenyuliu.mvp.login.view;

import com.example.zhenyuliu.mvp.login.bean.UserBean;

/**
 * Created by Zhenyu.Liu on 2016/10/10.
 */


/*      该操作需要什么？（getUserName, getPassword）
        该操作的结果，对应的反馈？(toMainActivity, showFailedError)
        该操作过程中对应的友好的交互？(showLoading, hideLoading)*/
public interface ILoginView {


    //获取用户名密码
    String getUserName();
    String getPassword();

    //清除用户名密码
    void clearUserName();
    void clearPassword();

    //用户等待加载中
    void showLodding();
    void hideLodding();

    //成功跳转和失败提示
    void toMainActivity(UserBean user);
    void toFaileError();

}
