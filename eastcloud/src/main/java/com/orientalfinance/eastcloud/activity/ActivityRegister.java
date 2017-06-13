package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.RegistView;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityRegistPresenter;

public class ActivityRegister extends MvpActivity<RegistView, ActivityRegistPresenter> implements RegistView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              getPresenter().codeSend();

            }
        });
    }

    @NonNull
    @Override
    public ActivityRegistPresenter createPresenter() {
        return new ActivityRegistPresenter();
    }

    @Override
    public void showRegist() {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void registSucceed(User movie) {

    }
}
