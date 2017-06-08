package com.orientalfinance.eastcloud.module.Retrofit;

import com.orientalfinance.eastcloud.module.Movie;

import org.reactivestreams.Publisher;

import java.util.List;
import java.util.Objects;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 29435 on 2017/6/7.
 */

public class MyTransform<T extends Object> implements FlowableTransformer<List<T>, List<T>> {
    @Override
    public Publisher<List<T>> apply(Flowable<List<T>> upstream) {

        return upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread());
    }
}
