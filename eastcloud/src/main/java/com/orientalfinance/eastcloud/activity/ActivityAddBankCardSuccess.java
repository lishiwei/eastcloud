package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityAddBankCardSuccessBinding;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddBankCardSuccessView;
import com.orientalfinance.eastcloud.mvp.presenter.AddBankCardSuccessPresenter;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class ActivityAddBankCardSuccess extends MvpActivity<ActivityAddBankCardSuccessView,
        AddBankCardSuccessPresenter> {

    private ActivityAddBankCardSuccessBinding bankCardSuccessBinding;

    @NonNull
    @Override
    public AddBankCardSuccessPresenter createPresenter() {
        return new AddBankCardSuccessPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bankCardSuccessBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_bank_card_success);
        initViews();

    }

    private void initViews() {
        bankCardSuccessBinding.toolbar.setTitle("");
        setSupportActionBar(bankCardSuccessBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bankCardSuccessBinding.tvWatchBankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityAddBankCardSuccess.this, ActivityMyBankCard.class));
                finish();
            }
        });
    }
}
