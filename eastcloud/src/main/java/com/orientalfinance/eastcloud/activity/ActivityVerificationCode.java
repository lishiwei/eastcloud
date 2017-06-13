package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.mvp.View.VerificationCodeView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityVerificationCodePresenter;


public class ActivityVerificationCode extends BaseMVPActivity<VerificationCodeView, ActivityVerificationCodePresenter> implements VerificationCodeView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forget_pass_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getPresenter().start();

    }

    @NonNull
    @Override
    public ActivityVerificationCodePresenter createPresenter() {
        return new ActivityVerificationCodePresenter();
    }

    @Override
    public void showGetCode() {
        mEastCloudDialog.show();
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(this, getResources().getString(R.string.req_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideGetCode() {
        mEastCloudDialog.hide();
    }

    @Override
    public void getCodeSucceed() {
        if (getIntent().getStringExtra(Constant.VALUE).equals(Constant.MODIFYPWD)) {
            Intent intent = new Intent(this, ActivityModifyPassWord.class);
            startActivity(intent);
        } else if (getIntent().getStringExtra(Constant.VALUE).equals(Constant.REGIST)) {
            Intent intent = new Intent(this, ActivitySettingPassword.class);
            startActivity(intent);
        }
    }
}
