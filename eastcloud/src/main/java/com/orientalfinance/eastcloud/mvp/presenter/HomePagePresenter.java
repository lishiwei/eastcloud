package com.orientalfinance.eastcloud.mvp.presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.orientalfinance.eastcloud.module.Movie;
import com.orientalfinance.eastcloud.module.core.MovieRepository;
import com.orientalfinance.eastcloud.mvp.View.HomepageView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/25.
 */

public class HomePagePresenter extends MvpNullObjectBasePresenter<HomepageView> {
    @Inject
    public HomePagePresenter() {
    }

    @Override
    public void start() {

    }

    @Override
    public void attachView(HomepageView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }
}
