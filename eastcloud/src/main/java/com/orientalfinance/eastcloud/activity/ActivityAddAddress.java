package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityAddAddressBinding;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddAddressView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityAddAddressPresenter;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class ActivityAddAddress extends BaseMVPActivity<ActivityAddAddressView, ActivityAddAddressPresenter> implements ActivityAddAddressView {

    private ActivityAddAddressBinding mAddAddressBinding;
    private int isDefaultAddress;

    @NonNull
    @Override
    public ActivityAddAddressPresenter createPresenter() {
        return new ActivityAddAddressPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAddAddressBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_address);
        initViews();
    }

    private void initViews() {
        mAddAddressBinding.toolbar.setTitle("");
        setSupportActionBar(mAddAddressBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAddAddressBinding.tvSaveAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address.AddRequestParam addRequestParam = new Address.AddRequestParam(mAddAddressBinding.etUserName.getText().toString(),
                        mAddAddressBinding.etUserPhone.getText().toString(),
                        "", "", mAddAddressBinding.etDetailAddress.getText().toString(),
                        isDefaultAddress);
                RequestParam<Address.AddRequestParam> requestParam = new RequestParam<Address.AddRequestParam>(addRequestParam);
                getPresenter().addAddress(requestParam);

            }
        });

        mAddAddressBinding.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isDefaultAddress = isChecked ? 0 : 1;
                Toast.makeText(ActivityAddAddress.this, isChecked ? "开" : "关", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showDialog() {
        mEastCloudDialog.show();
    }

    @Override
    public void hideDialog() {
        mEastCloudDialog.hide();
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void commitSucceed() {
        Toast.makeText(this, "添加成功!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
