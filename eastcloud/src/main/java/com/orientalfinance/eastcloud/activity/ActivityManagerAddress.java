package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.ManagerAddressAdapter;
import com.orientalfinance.eastcloud.module.Retrofit.DeleteRequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ManagerAddressView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityManagerAddressPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class ActivityManagerAddress extends BaseMVPActivity<ManagerAddressView, ActivityManagerAddressPresenter> implements ManagerAddressView {

    private ListView listViewAddress;
    private ImageView ivAddAddress;
    List<Address> mlist;
    ManagerAddressAdapter managerAddressAdapter;
    int mEditPosition;
    int mDeletePosition;

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
        ShowRequestParam showRequestParam = new ShowRequestParam(0, 10);
        RequestParam<ShowRequestParam> requestParam = new RequestParam<ShowRequestParam>(showRequestParam);
        getPresenter().getAddress(requestParam);
    }

    private void initViews() {
        listViewAddress = (ListView) findViewById(R.id.lv_all_address);
        mlist = new ArrayList<>();

        managerAddressAdapter = new ManagerAddressAdapter(this, mlist);
        listViewAddress.setAdapter(managerAddressAdapter);
        managerAddressAdapter.setOnItemCheckedListener(new ManagerAddressAdapter.OnItemCheckedListener() {
            @Override
            public void OnItemChecked(int position) {

                Address address = mlist.get(position);
                mEditPosition = position;
                Address.EditRequestParam editRequestParam = new Address.EditRequestParam(address.getId(), address.getUserName(), address.getUserPhone(), "", "", address.getAddress(), "0");
                RequestParam requestParam = new RequestParam(editRequestParam);
                getPresenter().editAddress(requestParam);
            }
        });
        managerAddressAdapter.setOnItemDeleteListener(new ManagerAddressAdapter.OnItemDeleteListener() {
            @Override
            public void onItemDelete(int position) {
                mDeletePosition = position;

                DeleteRequestParam deleteRequestParam = new DeleteRequestParam(mlist.get(position).getId());
                getPresenter().deleteAddress(new RequestParam(deleteRequestParam));
            }
        });
        ivAddAddress = (ImageView) findViewById(R.id.iv_add_address);
        ivAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipActivity();
            }
        });

    }

    @Override
    public void deleteSuccess() {
        ShowRequestParam showRequestParam = new ShowRequestParam(0, 10);
        RequestParam<ShowRequestParam> requestParam = new RequestParam<ShowRequestParam>(showRequestParam);
        getPresenter().getAddress(requestParam);
    }

    private void skipActivity() {
        startActivity(new Intent(ActivityManagerAddress.this, ActivityAddAddress.class));
    }

    @NonNull
    @Override
    public ActivityManagerAddressPresenter createPresenter() {
        return new ActivityManagerAddressPresenter();
    }


    @Override
    public void showSuccess(List<Address> addressList) {
        mlist = addressList;
        Collections.sort(mlist, new Comparator<Address>() {
            @Override
            public int compare(Address o1, Address o2) {
                return o1.isDefault()-o2.isDefault();
            }
        });
        managerAddressAdapter.setList(mlist);
    }

    @Override
    public void showError(String errorMsg) {

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
    public void editSuccess() {
        ShowRequestParam showRequestParam = new ShowRequestParam(0, 10);
        RequestParam<ShowRequestParam> requestParam = new RequestParam<ShowRequestParam>(showRequestParam);
        getPresenter().getAddress(requestParam);
    }
}
