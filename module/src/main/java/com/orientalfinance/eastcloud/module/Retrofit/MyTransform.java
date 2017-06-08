package com.orientalfinance.eastcloud.module.Retrofit;



import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 29435 on 2017/6/7.
 */

public class MyTransform<T extends Object> implements FlowableTransformer<T, T> {
    @Override
    public Publisher<T> apply(Flowable<T> upstream) {

        return upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread());
    }
}
