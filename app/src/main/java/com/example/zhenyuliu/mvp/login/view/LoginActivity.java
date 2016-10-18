package com.example.zhenyuliu.mvp.login.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.zhenyuliu.mvp.R;
import com.example.zhenyuliu.mvp.login.bean.UserBean;
import com.example.zhenyuliu.mvp.login.presenter.LoginPresenter;
import com.example.zhenyuliu.mvp.login.view.ILoginView;

/**
 * Created by Zhenyu.Liu on 2016/10/10.
 */
public class LoginActivity extends Activity implements ILoginView{

    private EditText e_username , e_password;
    private Button b_ok , b_clear;
    private ProgressBar p_lodding;
    private LoginPresenter loginPresenter = new LoginPresenter(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        initViews();
    }

    private void initViews() {

        e_username = (EditText) findViewById(R.id.e_username);
        e_password = (EditText) findViewById(R.id.e_password);

        b_ok = (Button) findViewById(R.id.b_ok);
        b_clear = (Button) findViewById(R.id.b_clear);

        p_lodding = (ProgressBar) findViewById(R.id.p_lodding);

        b_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login();
            }
        });

        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.clear();
            }
        });

    }

    @Override
    public String getUserName() {
        return e_username.getText().toString();
    }

    @Override
    public String getPassword() {
        return e_password.getText().toString();
    }

    @Override
    public void clearUserName() {
        e_username.setText("");
    }

    @Override
    public void clearPassword() {
        e_password.setText("");
    }

    @Override
    public void showLodding() {
        p_lodding.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLodding() {
        p_lodding.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(UserBean user) {
        Toast.makeText(this, user.getUserName() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toFaileError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }


}
