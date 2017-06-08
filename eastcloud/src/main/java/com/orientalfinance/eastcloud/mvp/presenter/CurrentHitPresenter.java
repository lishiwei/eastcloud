package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.core.MovieRepository;
import com.orientalfinance.eastcloud.module.core.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Movie;
import com.orientalfinance.eastcloud.mvp.View.CurrentHitView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 29435 on 2017/5/26.
 */

public class CurrentHitPresenter extends MvpNullObjectBasePresenter<CurrentHitView> {
    private static final String TAG = CurrentHitPresenter.class.getSimpleName();
    MovieRepository mMovieRepository;

    @Inject
    public CurrentHitPresenter(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }
//@Inject
//    public CurrentHitPresenter() {
//        mMovieRepository = movieRepository;
//    }
    public void start() {
        getView().showLoading();
        mMovieRepository.getDatas(new MovieRequestParam(0,0) ).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movies) throws Exception {
                getView().showView(movies);
                getView().hideLoading();
            }
        });
    }

    @Override
    public void attachView(CurrentHitView view) {
        super.attachView(view);

    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
public static final class MovieRequestParam implements RequestParam{
    int pageSize;
    int pageNum;

    public MovieRequestParam(int pageSize, int pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }
}
}
