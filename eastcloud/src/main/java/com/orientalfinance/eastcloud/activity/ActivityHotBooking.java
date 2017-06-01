package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityHotBookingBinding;
import com.orientalfinance.eastcloud.adapter.CurrentHitRvAdpter;
import com.orientalfinance.eastcloud.dagger.HotMovie;
import com.orientalfinance.eastcloud.dagger.HotVariety;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerHotBookingComponent;
import com.orientalfinance.eastcloud.dagger.component.HotBookingComponent;
import com.orientalfinance.eastcloud.dagger.modules.HotBookingModule;
import com.orientalfinance.eastcloud.mvp.View.FullyGridLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.HotBookingView;
import com.orientalfinance.eastcloud.mvp.View.HotBookingViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.HotBookingPresenter;

import javax.inject.Inject;

public class ActivityHotBooking extends BaseActivity<HotBookingComponent, HotBookingView, HotBookingPresenter, HotBookingViewState> implements HotBookingView {

    @Inject
    @HotMovie
    CurrentHitRvAdpter mHotMovieRvAdpter;
    @Inject
    @HotVariety
    CurrentHitRvAdpter mHotVarietyRvAdpter;

    ActivityHotBookingBinding mActivityHotBookingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityHotBookingBinding = DataBindingUtil.setContentView(this, R.layout.activity_hot_booking);
        mActivityHotBookingBinding.rvHotMovie.setLayoutManager(new FullyGridLayoutManager(this,3, LinearLayoutManager.VERTICAL,false));
        mActivityHotBookingBinding.rvHotMovie.setAdapter(mHotMovieRvAdpter);
        mActivityHotBookingBinding.rvHotVariety.setLayoutManager(new FullyGridLayoutManager(this,3, LinearLayoutManager.VERTICAL,false));
        mActivityHotBookingBinding.rvHotVariety.setAdapter(mHotVarietyRvAdpter);

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
    public void showView() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
