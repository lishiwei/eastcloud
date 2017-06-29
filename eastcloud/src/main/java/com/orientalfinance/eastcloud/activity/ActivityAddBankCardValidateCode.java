package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityAddBankCardCodeBinding;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddBankCardValidateCodeView;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityAddBankCardValidateCodePresenter;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class ActivityAddBankCardValidateCode extends MvpActivity<ActivityAddBankCardValidateCodeView,
        ActivityAddBankCardValidateCodePresenter> implements View.OnClickListener {

    private ActivityAddBankCardCodeBinding activityAddBankCardCodeBinding;

    @NonNull
    @Override
    public ActivityAddBankCardValidateCodePresenter createPresenter() {
        return new ActivityAddBankCardValidateCodePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddBankCardCodeBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_bank_card_code);

        initViews();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private void initViews() {
        activityAddBankCardCodeBinding.toolbar.setTitle("");
        setSupportActionBar(activityAddBankCardCodeBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityAddBankCardCodeBinding.btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm:
                startActivity(new Intent(ActivityAddBankCardValidateCode.this, ActivityAddBankCardSuccess.class));
                break;
        }
    }
}
