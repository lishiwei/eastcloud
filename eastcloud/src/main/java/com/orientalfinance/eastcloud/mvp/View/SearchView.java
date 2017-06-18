package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.SearchHot;
import com.orientalfinance.eastcloud.module.javabean.SearchResult;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface SearchView extends BaseMvpView{

public void showSearchHot(List<SearchHot> searchHots);
public void showSearchResult(List<SearchResult> searchResults);
}
