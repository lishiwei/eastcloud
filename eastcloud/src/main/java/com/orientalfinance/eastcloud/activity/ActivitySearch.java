package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivitySearchBinding;
import com.orientalfinance.eastcloud.adapter.SearchRvAdapter;
import com.orientalfinance.eastcloud.dagger.HotSearch;
import com.orientalfinance.eastcloud.dagger.Searched;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerSearchComponent;
import com.orientalfinance.eastcloud.dagger.component.SearchComponent;
import com.orientalfinance.eastcloud.dagger.modules.SearchModule;
import com.orientalfinance.eastcloud.module.Detail;
import com.orientalfinance.eastcloud.mvp.View.SearchView;
import com.orientalfinance.eastcloud.mvp.View.SearchViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.SearchPresenter;

import javax.inject.Inject;

public class ActivitySearch extends BaseActivity<SearchComponent, SearchView, SearchPresenter, SearchViewState> implements SearchView {
    @Inject
    @HotSearch
    SearchRvAdapter mHotSearchRvAdapter;

    @Inject
    @Searched
    SearchRvAdapter mSearchedRvAdapter;
    ActivitySearchBinding mActivitySearchBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySearchBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mActivitySearchBinding.rvHistory.setLayoutManager(new GridLayoutManager(this, 5, LinearLayoutManager.VERTICAL, false));
        mActivitySearchBinding.rvHistory.setAdapter(mSearchedRvAdapter);
        mActivitySearchBinding.rvSearched.setLayoutManager(new GridLayoutManager(this, 5, LinearLayoutManager.VERTICAL, false));
        mActivitySearchBinding.rvSearched.setAdapter(mSearchedRvAdapter);
        ((TextView)mActivitySearchBinding.toolbar.findViewById(R.id.textView)).setText("搜索");
        setSupportActionBar(mActivitySearchBinding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected SearchComponent constructComponent(AppComponent appComponent) {
        return DaggerSearchComponent.builder().appComponent(appComponent).searchModule(new SearchModule()).build();
    }

    @Override
    public void showView(Detail detail) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
