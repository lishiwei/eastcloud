package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.SearchHot;
import com.orientalfinance.eastcloud.module.javabean.SearchResult;
import com.orientalfinance.eastcloud.mvp.View.SearchView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class SearchPresenter extends MvpNullObjectBasePresenter<SearchView> {
    private static final String TAG = SearchPresenter.class.getSimpleName();


    @Inject
    public SearchPresenter() {

    }
    public void showSearchHot(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showSearchHot(requestParam).compose(new ListTransform<List<SearchHot>>()).subscribe(new Consumer<List<SearchHot>>() {
            @Override
            public void accept(@NonNull List<SearchHot> searchHots) throws Exception {
             getView().showSearchHot(searchHots);
                getView().hideDialog();

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });
    }

    public void showSearchResult(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showSearchResult(requestParam).compose(new ListTransform<List<SearchResult>>()).subscribe(new Consumer<List<SearchResult>>() {
            @Override
            public void accept(@NonNull List<SearchResult> searchResults) throws Exception {
                getView().hideDialog();
                getView().showSearchResult(searchResults);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });
    }
}
