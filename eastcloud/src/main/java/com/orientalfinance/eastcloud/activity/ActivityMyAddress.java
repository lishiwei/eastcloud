package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityMyAddressBinding;
import com.orientalfinance.eastcloud.adapter.MyAddressAdapter;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityMyAddressView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityMyAddressPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class ActivityMyAddress extends BaseMVPActivity<ActivityMyAddressView, ActivityMyAddressPresenter> implements ActivityMyAddressView, View.OnClickListener {


    private ActivityMyAddressBinding activityMyAddressBinding;
    private MyAddressAdapter mMyAddressAdapter;
    List<Address> mAddressList;

    @NonNull
    @Override
    public ActivityMyAddressPresenter createPresenter() {
        return new ActivityMyAddressPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMyAddressBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_address);
        activityMyAddressBinding.toolbar.setTitle("");
        setSupportActionBar(activityMyAddressBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAddressList = new ArrayList<>();
        mMyAddressAdapter = new MyAddressAdapter(mAddressList);
        activityMyAddressBinding.rcMyAddress.setLayoutManager(new LinearLayoutManager(this));
        activityMyAddressBinding.rcMyAddress.setAdapter(mMyAddressAdapter);

        activityMyAddressBinding.tvManageAddress.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ShowRequestParam showRequestParam = new ShowRequestParam(0, 10);
        RequestParam<ShowRequestParam> requestParam = new RequestParam<ShowRequestParam>(showRequestParam);
        getPresenter().getAddress(requestParam);
    }

    @Override
    public void showLoading() {
        mEastCloudDialog.show();
    }

    @Override
    public void showSuccess(List<Address> addressList) {
        mMyAddressAdapter.setAddresses(addressList);
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        mEastCloudDialog.hide();
    }

    @Override
    public void onClick(View v) {
        if (R.id.tv_manage_address == v.getId()) {
            Intent intent = new Intent(ActivityMyAddress.this, ActivityManagerAddress.class);
            startActivity(intent);
        }
    }
}
