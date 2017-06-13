package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityEditAddressBinding;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityEditAddressView;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityEditAddressPresenter;

import java.io.Serializable;


/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class ActivityEditAddress extends MvpActivity<ActivityEditAddressView, ActivityEditAddressPresenter> {

    private Address address;
    private ActivityEditAddressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_address);
        binding.toolbar.setTitle("");
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        address = (Address) getIntent().getSerializableExtra("address");

        binding.setAddress(address);

        initViews();
    }

    private void initViews() {

    }

    @NonNull
    @Override
    public ActivityEditAddressPresenter createPresenter() {
        return new ActivityEditAddressPresenter();
    }
}
