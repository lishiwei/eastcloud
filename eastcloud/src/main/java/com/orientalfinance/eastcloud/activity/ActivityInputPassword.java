package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivitySettingPasswordBinding;
import com.orientalfinance.eastcloud.MainActivity;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.core.AcacheUtil;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.SettingPassWordView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.SettingPassWordPresenter;

public class ActivityInputPassword extends BaseMVPActivity<SettingPassWordView, SettingPassWordPresenter> implements SettingPassWordView {
    private static final java.lang.String TAG = ActivityInputPassword.class.getSimpleName();
    ActivitySettingPasswordBinding mActivitySettingPasswordBinding;
    String mPhone = "";
    String mValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySettingPasswordBinding= DataBindingUtil.setContentView(this,R.layout.activity_setting_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        mPhone = getIntent().getStringExtra(Constant.PHONE);
        mValue = getIntent().getStringExtra(Constant.VALUE);
        if (mValue.equals(Constant.MODIFYPWD)) {
            mActivitySettingPasswordBinding.tvToolbar.setText("修改密码");
            mActivitySettingPasswordBinding.button.setText("修改");
        } else if (mValue.equals(Constant.FORGET)) {
            mActivitySettingPasswordBinding.tvToolbar.setText("忘记密码");
            mActivitySettingPasswordBinding.button.setText("修改");

        } else if (mValue.equals(Constant.REGIST)) {
            mActivitySettingPasswordBinding.tvToolbar.setText("注册");
            mActivitySettingPasswordBinding.button.setText("注册");
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User.RegistRequestParam registRequestParam = new User.RegistRequestParam(mPhone, mActivitySettingPasswordBinding.cetPwd.getText().toString());
                RequestParam<User.RegistRequestParam> requestParam = new RequestParam<User.RegistRequestParam>(registRequestParam);
                if (!mActivitySettingPasswordBinding.cetPwd.getText().toString().equals(mActivitySettingPasswordBinding.cetPwdConfirm.getText().toString())) {
                    Toast.makeText(ActivityInputPassword.this, "您的两次密码输入不相同!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mValue.equals(Constant.MODIFYPWD)) {
                    getPresenter().modifyPsd(new RequestParam<User.RegistRequestParam>(registRequestParam));

                } else if (mValue.equals(Constant.FORGET)) {
                    getPresenter().forgetPsd(new RequestParam<User.RegistRequestParam>(registRequestParam));

                } else if (mValue.equals(Constant.REGIST)) {

                    getPresenter().register(new RequestParam<User.RegistRequestParam>(registRequestParam));
                }
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
        mEastCloudProgressDialog.show();
    }

    @Override
    public void hideRegist() {
        mEastCloudProgressDialog.hide();
    }

    @Override
    public void modifySucceed() {
        Toast.makeText(this, "修改密码成功!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registSucceed(User user) {
        AcacheUtil.getInstance().putUser(user);

        startActivity(new Intent(this, MainActivity.class));
    }
}
