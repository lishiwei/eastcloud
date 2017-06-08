package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityDetailBinding;
import com.orientalfinance.eastcloud.adapter.DetailRVAdapter;
import com.orientalfinance.eastcloud.dagger.component.ActivityDetailComponent;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerActivityDetailComponent;
import com.orientalfinance.eastcloud.dagger.modules.ActivityDetailModule;
import com.orientalfinance.eastcloud.module.javabean.Detail;
import com.orientalfinance.eastcloud.mvp.View.DetailView;
import com.orientalfinance.eastcloud.mvp.View.ActivityDetailViewState;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityDetailPresenter;

import javax.inject.Inject;

public class ActivityDetail extends BaseActivity<ActivityDetailComponent, DetailView, ActivityDetailPresenter, ActivityDetailViewState> implements DetailView {
    private static final String TAG = ActivityDetail.class.getSimpleName();
    ActivityDetailBinding mActivityDetailBinding;
    @Inject
    DetailRVAdapter mDetailRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityDetailBinding = DataBindingUtil.setContentView(this,getLayoutId());
        mActivityDetailBinding.toolbar.setTitle("");
        setSupportActionBar(mActivityDetailBinding.toolbar);
        ((TextView)mActivityDetailBinding.toolbar.findViewById(R.id.tv_toolbar)).setText("影视详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getPresenter().start();
        mActivityDetailBinding.rvDetailComment.setAdapter(mDetailRVAdapter);
        mActivityDetailBinding.rvDetailComment.setLayoutManager(new FullyLinearLayoutManager(ActivityDetail.this));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected ActivityDetailComponent constructComponent(AppComponent appComponent) {
        return DaggerActivityDetailComponent.builder().appComponent(appComponent).activityDetailModule(new ActivityDetailModule()).build();
    }

    @Override
    public void showView(Detail detail) {
        Log.d(TAG, "showView: "+detail);
        Log.d(TAG, "showView: "+mDetailRVAdapter.getComments().toString());
        mActivityDetailBinding.setDetail(detail);
        mDetailRVAdapter.setComments(detail.getComments());

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
