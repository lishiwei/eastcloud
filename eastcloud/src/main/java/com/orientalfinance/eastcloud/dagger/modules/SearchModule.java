package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.eastcloud.adapter.SearchRvAdapter;
import com.orientalfinance.eastcloud.dagger.qualifier.HotSearch;
import com.orientalfinance.eastcloud.dagger.qualifier.Searched;

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
        List<String> strings = new ArrayList<>();
        strings.add("择天记");
        strings.add("外科风云");
        strings.add("人民的名义");
        strings.add("继承人");
        strings.add("继承人");
        return strings;
    }

    @HotSearch
    @Provides
    public SearchRvAdapter getHotSearchAdapter(List<String> strings) {
        return new SearchRvAdapter(strings);
    }


    @Provides
    @Searched
    public SearchRvAdapter getSearchedAdapter(List<String> strings) {
        return new SearchRvAdapter(strings);
    }
}
