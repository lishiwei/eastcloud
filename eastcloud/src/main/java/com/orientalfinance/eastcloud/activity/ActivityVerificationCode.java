package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityForgetPassWordBinding;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.VerificationCodeView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityVerificationCodePresenter;
import com.orientalfinance.eastcloud.view.MSGCountTimeView;


public class ActivityVerificationCode extends BaseMVPActivity<VerificationCodeView, ActivityVerificationCodePresenter> implements VerificationCodeView {
    ActivityForgetPassWordBinding mActivityForgetPassWordBinding;
    String mMessageId;
    String TAG = ActivityVerificationCode.class.getSimpleName();
    String mPhone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityForgetPassWordBinding = DataBindingUtil.setContentView(this, R.layout.activity_forget_pass_word);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mActivityForgetPassWordBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPhone = mPhone.equals("") ? mActivityForgetPassWordBinding.etPhoneNumber.getText().toString() : mPhone;
                User.VerificateCodeRequestParam verificateCodeRequestParam = new User.VerificateCodeRequestParam(mPhone, mActivityForgetPassWordBinding.etCode.getText().toString(), mMessageId);
                getPresenter().verificateCode(new RequestParam<User.VerificateCodeRequestParam>(verificateCodeRequestParam));

            }
        });

        mActivityForgetPassWordBinding.tvGetCode.setTotaltime(10000);
        mActivityForgetPassWordBinding.tvGetCode.isAllowRun(true);
        mActivityForgetPassWordBinding.tvGetCode.onDownTime(new MSGCountTimeView.onDownTime() {

            @Override
            public void onClick() {
                mPhone = mActivityForgetPassWordBinding.etPhoneNumber.getText().toString();

                mActivityForgetPassWordBinding.tvGetCode.setBackgroundDrawable(getResources().getDrawable(R.drawable.grey_rectangle));
                User.SendCodeRequestParam sendCodeRequestParam = new User.SendCodeRequestParam(mPhone);

                getPresenter().sendVerificationCode(new RequestParam<User.SendCodeRequestParam>(sendCodeRequestParam));
            }

            @Override
            public void onCount() {
            }

            @Override
            public void onFinish() {
                mActivityForgetPassWordBinding.tvGetCode.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_movieproperty));
            }
        });

    }

    @Override
    public void verificateSucceed() {

        if (getIntent().getStringExtra(Constant.VALUE).equals(Constant.FORGET)) {

            Intent intent = new Intent(ActivityVerificationCode.this, ActivityInputPassword.class);
            intent.putExtra(Constant.PHONE, mPhone);
            intent.putExtra(Constant.VALUE, Constant.FORGET);
            startActivity(intent);
        } else if (getIntent().getStringExtra(Constant.VALUE).equals(Constant.REGIST)) {
            Intent intent = new Intent(ActivityVerificationCode.this, ActivityInputPassword.class);
            intent.putExtra(Constant.PHONE, mPhone);
            intent.putExtra(Constant.VALUE, Constant.REGIST);
            startActivity(intent);
        } else if (getIntent().getStringExtra(Constant.VALUE).equals(Constant.MODIFYPWD)) {
            Intent intent = new Intent(ActivityVerificationCode.this, ActivityInputPassword.class);
            intent.putExtra(Constant.PHONE, mPhone);
            intent.putExtra(Constant.VALUE, Constant.MODIFYPWD);
            startActivity(intent);
        }
    }

    @NonNull
    @Override
    public ActivityVerificationCodePresenter createPresenter() {
        return new ActivityVerificationCodePresenter();
    }

    @Override
    public void showGetCode() {
        mEastCloudProgressDialog.show();
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideGetCode() {
        mEastCloudProgressDialog.hide();
    }

    @Override
    public void getCodeSucceed(String messageId) {
        Toast.makeText(this, "验证码已发送,请注意查收!", Toast.LENGTH_SHORT).show();
        this.mMessageId = messageId;
    }
}
