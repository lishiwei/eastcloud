package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityAddAddressBinding;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddAddressView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityAddAddressPresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;

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
                CityPicker cityPicker = new CityPicker.Builder(ActivityAddAddress.this)
                        .textSize(20)
                        .title("地址选择")
                        .backgroundPop(0xa0000000)
                        .titleBackgroundColor("#234Dfa")
                        .titleTextColor("#000000")
                        .backgroundPop(0xa0000000)
                        .confirTextColor("#000000")
                        .cancelTextColor("#000000")
                        .province("上海市")
                        .city("上海市")
                        .district("杨浦区")
                        .textColor(Color.parseColor("#000000"))
                        .provinceCyclic(true)
                        .cityCyclic(false)
                        .districtCyclic(false)
                        .visibleItemsCount(7)
                        .itemPadding(10)
                        .onlyShowProvinceAndCity(false)
                        .build();
                cityPicker.show();

                //监听方法，获取选择结果
                cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
                    @Override
                    public void onSelected(String... citySelected) {
                        //省份
                        String province = citySelected[0];
                        //城市
                        String city = citySelected[1];
                        //区县（如果设定了两级联动，那么该项返回空）
                        String district = citySelected[2];
                        //邮编
                        String code = citySelected[3];
                        mAddress = province + city + district;
                        mAddressCode = code;
                        LogUtils.d(TAG, "onSelected: "+code);
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(ActivityAddAddress.this, "已取消", Toast.LENGTH_LONG).show();
                    }
                });
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
