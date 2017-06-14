package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivitySettingPasswordBinding;
import com.orientalfinance.eastcloud.MainActivity;
import com.orientalfinance.eastcloud.module.core.AcacheUtil;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.SettingPassWordView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.SettingPassWordPresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;

public class ActivitySettingPassword extends BaseMVPActivity<SettingPassWordView, SettingPassWordPresenter> implements SettingPassWordView {
    private static final java.lang.String TAG = ActivitySettingPassword.class.getSimpleName();
    ActivitySettingPasswordBinding mActivitySettingPasswordBinding;

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
//                getPresenter().register(AcacheUtil.getInstance().getUser().getPhone(), mActivitySettingPasswordBinding.cetPwd.getText().toString());
                getPresenter().register("18601704731", "123456");
//
            }
        });
    }

    @NonNull
    @Override
    public SettingPassWordPresenter createPresenter() {
        return new SettingPassWordPresenter();
    }


    @Override
    public void showError(String throwable) {
        Toast.makeText(this, throwable, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRegist() {
        mEastCloudDialog.show();
    }

    @Override
    public void hideRegist() {
        mEastCloudDialog.hide();
    }

    @Override
    public void registSucceed(User user) {
        AcacheUtil.getInstance().putUser(user);
        LogUtils.d(TAG, "registSucceed: "+user.toString());
        startActivity(new Intent(this, MainActivity.class));
    }
}
