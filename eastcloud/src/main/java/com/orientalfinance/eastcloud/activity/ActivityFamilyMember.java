package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityFamilyMemberBinding;
import com.orientalfinance.eastcloud.adapter.FamilyMemberRvAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerFamilyMemberComponent;
import com.orientalfinance.eastcloud.dagger.component.FamilyMemberComponent;
import com.orientalfinance.eastcloud.dagger.modules.ActivityFamilyMemberModules;
import com.orientalfinance.eastcloud.mvp.View.FamilyMemberView;
import com.orientalfinance.eastcloud.mvp.View.FamilyMemberViewViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.FamilyMemberPresenter;

import javax.inject.Inject;

public class ActivityFamilyMember extends BaseActivity<FamilyMemberComponent, FamilyMemberView, FamilyMemberPresenter, FamilyMemberViewViewState> implements FamilyMemberView {
    ActivityFamilyMemberBinding mActivityFamilyMemberBinding;
    @Inject
    FamilyMemberRvAdapter mFamilyMemberRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityFamilyMemberBinding = DataBindingUtil.setContentView(this, getLayoutId());
        Toolbar toolbar = mActivityFamilyMemberBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActivityFamilyMemberBinding.rvFamilyMember.setAdapter(mFamilyMemberRvAdapter);
        mActivityFamilyMemberBinding.rvFamilyMember.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public boolean hasToolBar() {
        return true;
    }

    @Override
    public String getToolBarTitle() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_family_member;
    }

    @Override
    protected FamilyMemberComponent constructComponent(AppComponent appComponent) {
        return DaggerFamilyMemberComponent.builder().appComponent(appComponent).activityFamilyMemberModules(new ActivityFamilyMemberModules()).build();
    }
}
