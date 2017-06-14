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
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.mvp.View.VerificationCodeView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityVerificationCodePresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;
import com.orientalfinance.eastcloud.view.MSGCountTimeView;


public class ActivityVerificationCode extends BaseMVPActivity<VerificationCodeView, ActivityVerificationCodePresenter> implements VerificationCodeView {
    ActivityForgetPassWordBinding mActivityForgetPassWordBinding;
    String mCode;
    String TAG = ActivityVerificationCode.class.getSimpleName();

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

//                getPresenter().verificateCode(new VerificationCode(mActivityForgetPassWordBinding.etPhoneNumber.getText().toString(), mCode));
            }
        });

        mActivityForgetPassWordBinding.tvGetCode.setTotaltime(10000);
        mActivityForgetPassWordBinding.tvGetCode.isAllowRun(true);
        mActivityForgetPassWordBinding.tvGetCode.onDownTime(new MSGCountTimeView.onDownTime() {


            @Override
            public void onClick() {

                mActivityForgetPassWordBinding.tvGetCode.setBackgroundDrawable(getDrawable(R.drawable.grey_rectangle));
                LogUtils.d(TAG, "onClick: ");

                getPresenter().sendVerificationCode(mActivityForgetPassWordBinding.etPhoneNumber.getText().toString());
            }

            @Override
            public void onCount() {
            }

            @Override
            public void onFinish() {
                mActivityForgetPassWordBinding.tvGetCode.setBackgroundDrawable(getDrawable(R.drawable.bg_movieproperty));
            }
        });

    }

    @Override
    public void verificateSucceed() {
        if (getIntent().getStringExtra(Constant.VALUE).equals(Constant.MODIFYPWD)) {
            Intent intent = new Intent(ActivityVerificationCode.this, ActivityModifyPassWord.class);
            startActivity(intent);
        } else if (getIntent().getStringExtra(Constant.VALUE).equals(Constant.REGIST)) {
            Intent intent = new Intent(ActivityVerificationCode.this, ActivitySettingPassword.class);
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
        mEastCloudDialog.show();
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideGetCode() {
        mEastCloudDialog.hide();
    }

    @Override
    public void getCodeSucceed(String code) {
        this.mCode = code;
    }
}
