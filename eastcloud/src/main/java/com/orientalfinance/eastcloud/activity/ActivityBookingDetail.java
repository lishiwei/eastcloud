package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityBookingDetailBinding;
import com.orientalfinance.eastcloud.adapter.BookingDetailRVAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.BookingDetailComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerBookingDetailComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerHotBookingComponent;
import com.orientalfinance.eastcloud.dagger.modules.BookingDetailModule;
import com.orientalfinance.eastcloud.dagger.modules.HotBookingModule;
import com.orientalfinance.eastcloud.module.Detail;
import com.orientalfinance.eastcloud.module.Movie;
import com.orientalfinance.eastcloud.mvp.View.BookingDetailView;
import com.orientalfinance.eastcloud.mvp.View.BookingDetailViewState;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.BookingDetailPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ActivityBookingDetail extends BaseActivity<BookingDetailComponent, BookingDetailView, BookingDetailPresenter, BookingDetailViewState> implements BookingDetailView {
    @Inject
    BookingDetailRVAdapter mBookingDetailRVAdapter;
    ActivityBookingDetailBinding mActivityBookingDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBookingDetailBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mActivityBookingDetailBinding.toolbar.setTitle("");
        setSupportActionBar(mActivityBookingDetailBinding.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getPresenter().start();
        mActivityBookingDetailBinding.rvDetailComment.setAdapter(mBookingDetailRVAdapter);
        mActivityBookingDetailBinding.rvDetailComment.setLayoutManager(new FullyLinearLayoutManager(ActivityBookingDetail.this));
        List<String> strings = new ArrayList<>();
        strings.add("17:00 \n 中华养生");
        strings.add("18:40 \n 欢乐喜剧人");
        strings.add("20:40 \n  思美人");

        mActivityBookingDetailBinding.stepsView.setLabels(strings.toArray(new String[strings.size()]))
                .setBarColorIndicator(getResources().getColor(R.color.material_blue_grey_800))
                .setProgressColorIndicator(Color.GRAY)
                .setLabelColorIndicator(Color.GRAY)
                .setCompletedPosition(0)
                .drawView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_booking_detail;
    }

    @Override
    protected BookingDetailComponent constructComponent(AppComponent appComponent) {
        return DaggerBookingDetailComponent.builder().appComponent(appComponent).bookingDetailModule(new BookingDetailModule()).build();
    }

    @Override
    public void showView(Detail detail) {
        mActivityBookingDetailBinding.setDetail(detail);
        mBookingDetailRVAdapter.setComments(detail.getComments());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void getDetail(String detailId) {

    }

    @Override
    public void showExchange() {

    }

    @Override
    public void stopExchange() {

    }

    @Override
    public void exchangeHotMovie(List<Movie> movieList) {

    }

    @Override
    public void exchangeHotVariety(List<Movie> movieList) {

    }
}
