package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityAddAddressBinding;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddAddressView;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityAddAddressPresenter;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class ActivityAddAddress extends MvpActivity<ActivityAddAddressView, ActivityAddAddressPresenter> {

    private ActivityAddAddressBinding addAddressBinding;

    @NonNull
    @Override
    public ActivityAddAddressPresenter createPresenter() {
        return new ActivityAddAddressPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addAddressBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_address);
        initViews();
    }

    private void initViews() {
        addAddressBinding.toolbar.setTitle("");
        setSupportActionBar(addAddressBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addAddressBinding.tvSaveAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityAddAddress.this, ActivityManagerAddress.class));
                finish();
            }
        });

        addAddressBinding.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ActivityAddAddress.this, isChecked ? "开" : "关", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
