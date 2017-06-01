package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static java.security.AccessController.getContext;

public class ActivityTVPlayDetail extends BaseActivity<TVPlayDetailComponent, TVPlayDetailView, TVPlayDetailPresenter, TVPlayDetailViewState> implements TVPlayDetailView {
    ActivityTvplayDetailBinding mActivityTvplayDetailBinding;
    @Inject
    DetailRVAdapter mDetailRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityTvplayDetailBinding = DataBindingUtil.setContentView(this, getLayoutId());
        setSupportActionBar(mActivityTvplayDetailBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getPresenter().start();
        mActivityTvplayDetailBinding.rvDetailComment.setAdapter(mDetailRVAdapter);
        mActivityTvplayDetailBinding.rvDetailComment.setLayoutManager(new FullyLinearLayoutManager(ActivityTVPlayDetail.this));
        List<String> strings = new ArrayList<>();
        strings.add("17:00 \n 中华养生");
        strings.add("18:40 \n 欢乐喜剧人");
        strings.add("20:40 \n  思美人");
    mActivityTvplayDetailBinding.stepsView.setLabels(strings.toArray(new String[strings.size()]))
            .setBarColorIndicator(getResources().getColor(R.color.material_blue_grey_800))
            .setProgressColorIndicator(Color.GRAY)
            .setLabelColorIndicator(Color.GRAY)
            .setCompletedPosition(0)
            .drawView();
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
