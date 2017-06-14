package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityMyAddressBinding;
import com.orientalfinance.eastcloud.adapter.MyAddressAdapter;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityMyAddressView;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityMyAddressPresenter;

import java.util.ArrayList;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class ActivityMyAddress extends MvpActivity<ActivityMyAddressView, ActivityMyAddressPresenter> implements View.OnClickListener {


    private ActivityMyAddressBinding activityMyAddressBinding;

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


        ArrayList<Address> mlist = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Address address = new Address();
            address.setAddress("上海上海市杨浦区五角场街道武东路198号财大科技园12层");
            address.setUserName("小叮当");
            address.setUserPhone("13818832455");
            mlist.add(address);
        }
        activityMyAddressBinding.rcMyAddress.setLayoutManager(new LinearLayoutManager(this));
        activityMyAddressBinding.rcMyAddress.setAdapter(new MyAddressAdapter(mlist));

        activityMyAddressBinding.tvManageAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (R.id.tv_manage_address == v.getId()) {
            Intent intent = new Intent(ActivityMyAddress.this, ActivityManagerAddress.class);
            startActivity(intent);
        }
    }
}
