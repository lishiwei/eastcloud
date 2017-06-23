package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityEditAddressBinding;
import com.orientalfinance.eastcloud.module.Retrofit.DeleteRequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityEditAddressView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityEditAddressPresenter;


/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class ActivityEditAddress extends BaseMVPActivity<ActivityEditAddressView, ActivityEditAddressPresenter> implements ActivityEditAddressView {

    private Address address;
    private ActivityEditAddressBinding binding;
    public int isDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_address);
        binding.toolbar.setTitle("");
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        address = (Address) getIntent().getSerializableExtra("address");

        binding.setAddress(address);


        binding.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isDefault = isChecked ? 0 : 1;

            }
        });
        binding.tvSaveAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address.EditRequestParam editRequestParam = new Address.EditRequestParam(address.getId(), binding.etUserName.getText().toString(),
                        binding.etUserPhone.getText().toString(),
                        "", "", binding.etDetailAddress.getText().toString(),
                        isDefault+"");
                getPresenter().editAddress(new RequestParam<Address.EditRequestParam>(editRequestParam));
            }
        });
        binding.tvDeleteAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteRequestParam deleteRequestParam = new DeleteRequestParam(address.getId());
                getPresenter().deleteAddress(new RequestParam(deleteRequestParam));
            }
        });
    }

    @NonNull
    @Override
    public ActivityEditAddressPresenter createPresenter() {
        return new ActivityEditAddressPresenter();
    }

    @Override
    public void showDialog() {
        mEastCloudProgressDialog.show();
    }

    @Override
    public void editSucceed() {
        Toast.makeText(this, "修改成功!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideDialog() {
        mEastCloudProgressDialog.hide();
    }

    @Override
    public void deleteSuccess() {
        Toast.makeText(this, "删除成功!!", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
