package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityHotBookingBinding;
import com.orientalfinance.eastcloud.adapter.HotBookingRvAdpter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerHotBookingComponent;
import com.orientalfinance.eastcloud.dagger.component.HotBookingComponent;
import com.orientalfinance.eastcloud.dagger.modules.HotBookingModule;
import com.orientalfinance.eastcloud.dagger.qualifier.HotMovie;
import com.orientalfinance.eastcloud.dagger.qualifier.HotVariety;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;
import com.orientalfinance.eastcloud.module.javabean.AppointmentProgram;
import com.orientalfinance.eastcloud.mvp.View.FullyGridLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.HotBookingView;
import com.orientalfinance.eastcloud.mvp.View.HotBookingViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.HotBookingPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ActivityHotBooking extends BaseActivity<HotBookingComponent, HotBookingView, HotBookingPresenter, HotBookingViewState> implements HotBookingView {

    @Inject
    @HotMovie
    HotBookingRvAdpter mHotMovieRvAdpter;

    @Override
    public boolean hasToolBar() {
        return false;
    }

    @Override
    public String getToolBarTitle() {
        return null;
    }


    @Inject
    @HotVariety
    HotBookingRvAdpter mHotVarietyRvAdpter;

    ActivityHotBookingBinding mActivityHotBookingBinding;
    List<AppointmentProgram> mHotMovie = new ArrayList<>();
    List<AppointmentProgram> mHotVariety = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityHotBookingBinding = DataBindingUtil.setContentView(this, R.layout.activity_hot_booking);
        mActivityHotBookingBinding.rvHotMovie.setLayoutManager(new FullyGridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
        mActivityHotBookingBinding.rvHotMovie.setAdapter(mHotMovieRvAdpter);
        mActivityHotBookingBinding.rvHotVariety.setLayoutManager(new FullyGridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
        mActivityHotBookingBinding.rvHotVariety.setAdapter(mHotVarietyRvAdpter);
        ((TextView) mActivityHotBookingBinding.toolbar.findViewById(R.id.textView)).setText("热门预约");
        mActivityHotBookingBinding.toolbar.setTitle("");
        setSupportActionBar(mActivityHotBookingBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ShowRequestParam showRequestParam = new ShowRequestParam(0, 12);
        getPresenter().exchangeHotMovie(new RequestParam(showRequestParam));
        ShowRequestParam showRequestParam1 = new ShowRequestParam(0, 12);
        getPresenter().exchangeHotVariety(new RequestParam(showRequestParam1));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hot_booking;
    }

    @Override
    protected HotBookingComponent constructComponent(AppComponent appComponent) {
        return DaggerHotBookingComponent.builder().appComponent(appComponent).hotBookingModule(new HotBookingModule()).build();
    }


    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void exchangeHotMovie(List<AppointmentProgram> appointmentPrograms) {
        for (int i = 0; i < 6; i++) {
            mHotMovie.add(appointmentPrograms.get(i));

        }
        mHotMovieRvAdpter.setProgramList(mHotMovie);
        mHotMovieRvAdpter.notifyDataSetChanged();
    }

    @Override
    public void exchangeHotVariety(List<AppointmentProgram> appointmentPrograms) {
        for (int i = 6; i < 12; i++) {
            mHotVariety.add(appointmentPrograms.get(i));

        }
        mHotVarietyRvAdpter.setProgramList(mHotVariety);
        mHotVarietyRvAdpter.notifyDataSetChanged();
    }


}
