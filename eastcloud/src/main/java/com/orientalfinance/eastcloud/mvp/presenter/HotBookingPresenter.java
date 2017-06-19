package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.core.MovieRepository;
import com.orientalfinance.eastcloud.module.javabean.Movie;
import com.orientalfinance.eastcloud.mvp.View.HotBookingView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by 29435 on 2017/5/25.
 */

public class HotBookingPresenter extends MvpNullObjectBasePresenter<HotBookingView> {
    MovieRepository mMovieRepository;


    public void start() {

    }

    public List<Movie> getLiveVideoMovie() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg", "思美人", "虐心古装大戏"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "孤芳不自赏", "angalebaby钟汉良"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "撞车", "北美票房第一名"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "山河故人", "柏林电影节金橄榄枝"));
        return movies;
    }

    @Inject
    public HotBookingPresenter(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    @Override
    public void attachView(HotBookingView view) {
        getView().showLoading();
        exchangeHotVariety();
        exchangeHotMovie();
    }

    public void exchangeHotMovie() {
        getView().showExchange();

                getView().stopExchange();
                getView().exchangeHotMovie(getLiveVideoMovie());


    }

    public void exchangeHotVariety() {
        getView().showExchange();

    }

    @Override
    public void detachView(boolean retainInstance) {

    }
}
