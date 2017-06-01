package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityDetailBinding;
import com.orientalfinance.databinding.ActivityTvplayDetailBinding;
import com.orientalfinance.eastcloud.adapter.DetailRVAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerTVPlayDetailComponent;
import com.orientalfinance.eastcloud.dagger.component.TVPlayDetailComponent;
import com.orientalfinance.eastcloud.dagger.modules.TVPlayDetailModule;
import com.orientalfinance.eastcloud.module.Detail;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.TVPlayDetailView;
import com.orientalfinance.eastcloud.mvp.View.TVPlayDetailViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.TVPlayDetailPresenter;

import javax.inject.Inject;

public class ActivityTVPlayDetail extends BaseActivity<TVPlayDetailComponent, TVPlayDetailView, TVPlayDetailPresenter, TVPlayDetailViewState> implements TVPlayDetailView {
    ActivityTvplayDetailBinding mActivityTvplayDetailBinding;
    @Inject
    DetailRVAdapter mDetailRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityTvplayDetailBinding = DataBindingUtil.setContentView(this, getLayoutId());
        getPresenter().start();
        mActivityTvplayDetailBinding.rvDetailComment.setAdapter(mDetailRVAdapter);
        mActivityTvplayDetailBinding.rvDetailComment.setLayoutManager(new FullyLinearLayoutManager(ActivityTVPlayDetail.this));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tvplay_detail;
    }

    @Override
    protected TVPlayDetailComponent constructComponent(AppComponent appComponent) {
        return DaggerTVPlayDetailComponent.builder().appComponent(appComponent).tVPlayDetailModule(new TVPlayDetailModule()).build();
    }

    @Override
    public void showView(Detail detail) {
        mActivityTvplayDetailBinding.setDetail(detail);
        mDetailRVAdapter.setComments(detail.getComments());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
