package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
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
import com.orientalfinance.eastcloud.module.Retrofit.DeleteRequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;
import com.orientalfinance.eastcloud.module.javabean.AppointmentProgram;
import com.orientalfinance.eastcloud.mvp.View.FullyGridLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.HotBookingView;
import com.orientalfinance.eastcloud.mvp.View.HotBookingViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.HotBookingPresenter;
import com.orientalfinance.eastcloud.utils.ClickHandler;
import com.orientalfinance.eastcloud.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.orientalfinance.R.id.textView;

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

    RotateAnimation mHotBookingRotateAnimation;
    RotateAnimation mHotVarietyRotateAnimation;
    @Inject
    @HotVariety
    HotBookingRvAdpter mHotVarietyRvAdpter;

    ActivityHotBookingBinding mActivityHotBookingBinding;
    List<AppointmentProgram> mHotMovie = new ArrayList<>();
    List<AppointmentProgram> mHotVariety = new ArrayList<>();
    ClickHandler mClickHandler = new ClickHandler() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ll_HotBooking:
                    ShowRequestParam showRequestParam = new ShowRequestParam(0, 5);

                    getPresenter().exchangeHotMovie(new RequestParam(showRequestParam));
                    break;
                case R.id.ll_HotVariety:
                    ShowRequestParam showRequestParam1 = new ShowRequestParam(6, 11);
                    getPresenter().exchangeHotVariety(new RequestParam(showRequestParam1));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityHotBookingBinding = DataBindingUtil.setContentView(this, R.layout.activity_hot_booking);
        mActivityHotBookingBinding.rvHotMovie.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mActivityHotBookingBinding.rvHotMovie.setAdapter(mHotMovieRvAdpter);
        mActivityHotBookingBinding.rvHotVariety.setLayoutManager(new FullyGridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
        mActivityHotBookingBinding.rvHotVariety.setAdapter(mHotVarietyRvAdpter);
        mActivityHotBookingBinding.setClickHandler(mClickHandler);
        ((TextView) mActivityHotBookingBinding.toolbar.findViewById(textView)).setText("热门预约");
        mActivityHotBookingBinding.toolbar.setTitle("");
        setSupportActionBar(mActivityHotBookingBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mHotBookingRotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mHotBookingRotateAnimation.setDuration(1000);
        mHotBookingRotateAnimation.setRepeatMode(Animation.RESTART);
        mHotBookingRotateAnimation.setRepeatCount(Animation.INFINITE);
        mHotVarietyRotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mHotVarietyRotateAnimation.setDuration(1000);
        mHotVarietyRotateAnimation.setRepeatMode(Animation.RESTART);
        mHotVarietyRotateAnimation.setRepeatCount(Animation.INFINITE);
        ShowRequestParam showRequestParam = new ShowRequestParam(0, 5);

        getPresenter().exchangeHotMovie(new RequestParam(showRequestParam));
        ShowRequestParam showRequestParam1 = new ShowRequestParam(6, 11);

        getPresenter().exchangeHotMovie(new RequestParam(showRequestParam1));

        mHotMovieRvAdpter.setOnAddAppointmentListener(new HotBookingRvAdpter.OnAddAppointmentListener() {
            @Override
            public void onAddAppointment(String program_id) {
                AppointmentProgram.AddAppointmentRequestParam addAppointmentRequestParam = new AppointmentProgram.AddAppointmentRequestParam(program_id, "1");
                getPresenter().addAppointment(new RequestParam(addAppointmentRequestParam));
            }
        });
        mHotMovieRvAdpter.setOnCancelAppointmentListener(new HotBookingRvAdpter.OnCancelAppointmentListener() {
            @Override
            public void onCancelAppointment(String program_id) {

                DeleteRequestParam deleteRequestParam = new DeleteRequestParam(program_id);
                getPresenter().deleteAppointment(new RequestParam(deleteRequestParam));
            }
        });
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
mEastCloudProgressDialog.show();
    }

    @Override
    public void hideDialog() {
mEastCloudProgressDialog.hide();
    }

    @Override
    public void showError(String errorMsg) {
        ToastUtils.showShort(errorMsg);
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

    @Override
    public void showExchangeHotMovie() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_HotBooking);

        imageView.startAnimation(mHotBookingRotateAnimation);
    }

    @Override
    public void showHotVariety() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_HotVariety);

        imageView.startAnimation(mHotVarietyRotateAnimation);
    }

    @Override
    public void stopExchangeHotMovie() {
        mHotBookingRotateAnimation.cancel();
    }

    @Override
    public void stopHotVariety() {
        mHotVarietyRotateAnimation.cancel();
    }

    @Override
    public void showSucceed() {
        mHotMovieRvAdpter.notifyDataSetChanged();
    }

    @Override
    public void deleteFailed(int position) {

    }
}
