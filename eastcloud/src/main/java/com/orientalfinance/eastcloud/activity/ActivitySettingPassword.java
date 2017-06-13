package com.orientalfinance.eastcloud.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.mvp.View.SettingPassWordView;
import com.orientalfinance.eastcloud.mvp.presenter.SettingPassWordPresenter;

public class ActivitySettingPassword extends MvpActivity<SettingPassWordView,SettingPassWordPresenter> implements SettingPassWordView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivitySettingPassword.this, "创建成功", Toast.LENGTH_SHORT).show();
                getPresenter().register();

            }
        });
    }

    @NonNull
    @Override
    public SettingPassWordPresenter createPresenter() {
        return new SettingPassWordPresenter();
    }




    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void showgSettingPassWord() {

    }

    @Override
    public void SettingPassWordSucceed() {

    }
}
