package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivitySearchBinding;
import com.orientalfinance.eastcloud.adapter.SearchRvAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerSearchComponent;
import com.orientalfinance.eastcloud.dagger.component.SearchComponent;
import com.orientalfinance.eastcloud.dagger.modules.SearchModule;
import com.orientalfinance.eastcloud.dagger.qualifier.HotSearch;
import com.orientalfinance.eastcloud.dagger.qualifier.Searched;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.SearchHot;
import com.orientalfinance.eastcloud.module.javabean.SearchResult;
import com.orientalfinance.eastcloud.mvp.View.SearchView;
import com.orientalfinance.eastcloud.mvp.View.SearchViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.SearchPresenter;

import java.util.List;

import javax.inject.Inject;

public class ActivitySearch extends BaseActivity<SearchComponent, SearchView, SearchPresenter, SearchViewState> implements SearchView {
    @Inject
    @HotSearch
    SearchRvAdapter mHotSearchRvAdapter;

    @Override
    public boolean hasToolBar() {
        return false;
    }

    @Override
    public String getToolBarTitle() {
        return null;
    }

    @Inject
    @Searched
    SearchRvAdapter mSearchedRvAdapter;
    ActivitySearchBinding mActivitySearchBinding;
    List<String> mSearchHots;
    List<String> mSearchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySearchBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mActivitySearchBinding.rvHistory.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        mActivitySearchBinding.rvHistory.setAdapter(mSearchedRvAdapter);
        mActivitySearchBinding.rvSearched.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
        mActivitySearchBinding.rvSearched.setAdapter(mSearchedRvAdapter);
        ((TextView) mActivitySearchBinding.toolbar.findViewById(R.id.textView)).setText("搜索");
        setSupportActionBar(mActivitySearchBinding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RequestParam requestParam = new RequestParam();
        getPresenter().showSearchHot(requestParam);
        mActivitySearchBinding.cetSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                SearchResult.SearchRequestParam searchRequestParam = new SearchResult.SearchRequestParam(0, 10, "楚乔传");
                getPresenter().showSearchResult(new RequestParam(searchRequestParam));
                return true;
            }
        });
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
    public void showDialog() {
        mEastCloudDialog.show();
    }

    @Override
    public void hideDialog() {
        mEastCloudDialog.hide();
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void showSearchHot(List<SearchHot> searchHots) {
        for (int i = 0; i < searchHots.size(); i++) {
            mSearchHots.add(searchHots.get(i).getHotword());
        }
        mHotSearchRvAdapter.setStringList(mSearchHots);
        mHotSearchRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSearchResult(List<SearchResult> searchResults) {

    }
}
