package com.orientalfinance.eastcloud.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityAddAddressBinding;
import com.orientalfinance.eastcloud.citypicker.CityPicker;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddAddressView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityAddAddressPresenter;
import com.orientalfinance.eastcloud.utils.KeyboardUtils;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class ActivityAddAddress extends BaseMVPActivity<ActivityAddAddressView, ActivityAddAddressPresenter> implements ActivityAddAddressView {

    private static final java.lang.String TAG = ActivityAddAddress.class.getSimpleName();
    private ActivityAddAddressBinding mAddAddressBinding;
    private int isDefaultAddress = 0;
    String mAddress;
    String mAddressCode;

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
        mAddAddressBinding.cityPicker.setVisibility(View.INVISIBLE);
        mAddAddressBinding.tvSaveAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address.AddRequestParam addRequestParam = new Address.AddRequestParam(mAddAddressBinding.etUserName.getText().toString(),
                        mAddAddressBinding.etUserPhone.getText().toString(),
                        mAddressCode, mAddress, mAddAddressBinding.etDetailAddress.getText().toString(),
                        isDefaultAddress + "");
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
        mAddAddressBinding.etUserAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                KeyboardUtils.hideSoftInput(ActivityAddAddress.this);
                mAddAddressBinding.cityPicker.setVisibility(View.VISIBLE);
                mAddAddressBinding.cityPicker.setOnSelectedListener(new CityPicker.OnSelectedListener() {
                    @Override
                    public void selected(String cityString, String cityCode) {
                        mAddressCode = cityCode;
                        mAddress = cityString;
                    }
                });
            }
        });
    }
public void hideInput()
{
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
}
    @Override
    public void showDialog() {
        mEastCloudProgressDialog.show();
    }

    @Override
    public void hideDialog() {
        mEastCloudProgressDialog.hide();
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
