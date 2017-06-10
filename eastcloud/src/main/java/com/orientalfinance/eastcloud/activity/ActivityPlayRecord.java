package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityPlayRecordBinding;
import com.orientalfinance.eastcloud.adapter.PlayRecordRvAdpter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerPlayRecordComponent;
import com.orientalfinance.eastcloud.dagger.component.PlayRecordComponent;
import com.orientalfinance.eastcloud.dagger.modules.PlayRecordModule;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.PlayRecordView;
import com.orientalfinance.eastcloud.mvp.View.PlayRecordViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.PlayRecordPresenter;

import javax.inject.Inject;

public class ActivityPlayRecord extends BaseActivity<PlayRecordComponent, PlayRecordView, PlayRecordPresenter, PlayRecordViewState> implements PlayRecordView {
    @Inject
    PlayRecordRvAdpter mPlayRecordRvAdpter;
    ActivityPlayRecordBinding mActivityPlayRecordBinding;

    @Override
    public boolean hasToolBar() {
        return false;
    }

    @Override
    public String getToolBarTitle() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityPlayRecordBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mActivityPlayRecordBinding.toolbar.setTitle("");

        setSupportActionBar(mActivityPlayRecordBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActivityPlayRecordBinding.rvBefore.setLayoutManager(new FullyLinearLayoutManager(this));
        mActivityPlayRecordBinding.rvBefore.setAdapter(mPlayRecordRvAdpter);
        mActivityPlayRecordBinding.rvToday.setLayoutManager(new FullyLinearLayoutManager(this));
        mActivityPlayRecordBinding.rvToday.setAdapter(mPlayRecordRvAdpter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_play_record;
    }

    @Override
    protected PlayRecordComponent constructComponent(AppComponent appComponent) {
        return DaggerPlayRecordComponent.builder().appComponent(appComponent).playRecordModule(new PlayRecordModule()).build();
    }

    @Override
    public void showView() {

    }
}
