package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.eastcloud.adapter.SearchResultRvAdapter;
import com.orientalfinance.eastcloud.adapter.SearchRvAdapter;
import com.orientalfinance.eastcloud.dagger.qualifier.HotSearch;
import com.orientalfinance.eastcloud.dagger.qualifier.Searched;
import com.orientalfinance.eastcloud.module.core.AcacheUtil;
import com.orientalfinance.eastcloud.module.javabean.SearchResult;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lishiwei on 2017/3/31.
 */
@Module
public class SearchModule {

    @Provides
    public List<String> getData() {
        AcacheUtil.getInstance().getHistory();
        return AcacheUtil.getInstance().getHistory();
    }

    @HotSearch
    @Provides
    public SearchRvAdapter getHotSearchAdapter() {
        return new SearchRvAdapter(new ArrayList<String>());
    }


    @Provides
    @Searched
    public SearchRvAdapter getSearchedAdapter(List<String> strings) {
        return new SearchRvAdapter(strings);
    }


    @Provides
    public SearchResultRvAdapter getSearcheResultAdapter() {
        return new SearchResultRvAdapter(new ArrayList<SearchResult>());
    }
}
