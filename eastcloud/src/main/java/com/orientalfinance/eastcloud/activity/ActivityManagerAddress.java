package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.ManagerAddressAdapter;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ManagerAddressView;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityManagerAddPresenter;

import java.util.ArrayList;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class ActivityManagerAddress extends MvpActivity<ManagerAddressView, ActivityManagerAddPresenter> {

    private ListView listViewAddress;
    private ImageView ivAddAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_address);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initViews() {
        listViewAddress = (ListView) findViewById(R.id.lv_all_address);
        //假数据
        ArrayList<Address> mlist = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Address address = new Address();
            address.setAddress("上海上海市杨浦区五角场街道武东路198号财大科技园12层");
            address.setUserName("小叮当");
            address.setUserPhone("13818832455");

            mlist.add(address);
        }

        ManagerAddressAdapter managerAddressAdapter = new ManagerAddressAdapter(this, mlist);
        listViewAddress.setAdapter(managerAddressAdapter);

        ivAddAddress = (ImageView) findViewById(R.id.iv_add_address);

        ivAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipActivity();
            }
        });
        listViewAddress.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                skipActivity();
            }
        });
    }

    private void skipActivity() {
        startActivity(new Intent(ActivityManagerAddress.this, ActivityAddAddress.class));
    }

    @NonNull
    @Override
    public ActivityManagerAddPresenter createPresenter() {
        return new ActivityManagerAddPresenter();
    }
}
