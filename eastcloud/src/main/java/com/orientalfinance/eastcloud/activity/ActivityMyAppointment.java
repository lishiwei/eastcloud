package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityMyAppointmentBinding;
import com.orientalfinance.eastcloud.adapter.MyAppointmentRvAdpter;
import com.orientalfinance.eastcloud.module.Retrofit.DeleteRequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;
import com.orientalfinance.eastcloud.module.javabean.Appointment;
import com.orientalfinance.eastcloud.mvp.View.MyAppointmentView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.MyAppointmentPresenter;
import com.orientalfinance.eastcloud.view.OnSwipeDeleteListener;

import java.util.ArrayList;
import java.util.List;

public class ActivityMyAppointment extends BaseMVPActivity<MyAppointmentView, MyAppointmentPresenter> implements MyAppointmentView {
    ActivityMyAppointmentBinding mActivityMyAppointmentBinding;
    MyAppointmentRvAdpter mMyAppointmentRvAdpter;
    String mDeleteId;
List<Appointment> mAppointments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppointments.add(new Appointment("东方卫视",R.drawable.qipashuo+"","奇葩说","1","aaaaa","aaaa","aaa","aaaaa"));
        mAppointments.add(new Appointment("东方卫视",R.drawable.qipashuo+"","奇葩说","1","aaaaa","aaaa","aaa","aaaaa"));
        mAppointments.add(new Appointment("东方卫视",R.drawable.qipashuo+"","奇葩说","1","aaaaa","aaaa","aaa","aaaaa"));
        mAppointments.add(new Appointment("东方卫视",R.drawable.qipashuo+"","奇葩说","1","aaaaa","aaaa","aaa","aaaaa"));
        mAppointments.add(new Appointment("东方卫视",R.drawable.qipashuo+"","奇葩说","1","aaaaa","aaaa","aaa","aaaaa"));

        mActivityMyAppointmentBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_appointment);
        mMyAppointmentRvAdpter = new MyAppointmentRvAdpter(mAppointments);
        mActivityMyAppointmentBinding.rvMyAppointment.setLayoutManager(new LinearLayoutManager(this));
        mActivityMyAppointmentBinding.rvMyAppointment.setAdapter(mMyAppointmentRvAdpter);
        mActivityMyAppointmentBinding.toolbar.setTitle("");
        setSupportActionBar(mActivityMyAppointmentBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ShowRequestParam showRequestParam = new ShowRequestParam(0, 10);
        getPresenter().showAppointment(new RequestParam(showRequestParam));
        mMyAppointmentRvAdpter.setOnSwipeDeleteListener(new OnSwipeDeleteListener() {
            @Override
            public void onDeleteListener(SwipeMenuLayout swipeMenuLayout, int position) {
                mDeleteId = mMyAppointmentRvAdpter.getAppointmentList().get(position).getId();
                DeleteRequestParam deleteRequestParam = new DeleteRequestParam(mDeleteId);
                getPresenter().deleteAppointment(new RequestParam(deleteRequestParam));
            }
        });
    }

    /**
     * Instantiate a presenter instance
     *
     * @return The {@link } for this view
     */
    @NonNull
    @Override
    public MyAppointmentPresenter createPresenter() {
        return new MyAppointmentPresenter();
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
    public void showAppointment(List<Appointment> appointments) {
        mMyAppointmentRvAdpter.setAppointmentList(appointments);
    }

    @Override
    public void deleteSucceed(int position) {

    }

    @Override
    public void deleteFailed(int position) {
        Toast.makeText(this, "删除失败!", Toast.LENGTH_SHORT).show();
    }
}
