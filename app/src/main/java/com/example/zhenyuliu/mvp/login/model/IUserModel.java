package com.example.zhenyuliu.mvp.login.model;

/**
 * Created by Zhenyu.Liu on 2016/10/10.
 */
public interface IUserModel {


    public void login(String userName , String password , OnLoginListener loginListener);


}
  