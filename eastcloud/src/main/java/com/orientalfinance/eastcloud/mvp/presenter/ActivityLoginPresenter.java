package com.orientalfinance.eastcloud.mvp.presenter;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.orientalfinance.eastcloud.module.Detail;
import com.orientalfinance.eastcloud.module.Movie;
import com.orientalfinance.eastcloud.module.Retrofit.EastcloudRetrofit;
import com.orientalfinance.eastcloud.module.Retrofit.MyTransform;
import com.orientalfinance.eastcloud.module.core.CommonRequestParam;
import com.orientalfinance.eastcloud.mvp.View.ActivityDetailView;
import com.orientalfinance.eastcloud.mvp.View.ActivityLoginView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import org.reactivestreams.Publisher;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityLoginPresenter extends MvpNullObjectBasePresenter<ActivityLoginView> {
    private static final String TAG = ActivityLoginPresenter.class.getSimpleName();

    @Override
    public void attachView(ActivityLoginView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }

    public void login() {
        getView().showLogin();
        CommonRequestParam commonRequestParam = new CommonRequestParam("", "");
        EastcloudRetrofit.getRetrofitService().getMovies(commonRequestParam.getS(), commonRequestParam.getSn()).compose(new MyTransform<Movie>()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().showError();
            }
        }).subscribe(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movies) throws Exception {
                getView().setUser(movies.get(0));
            }
        });
    }

    public void start() {


    }
}
