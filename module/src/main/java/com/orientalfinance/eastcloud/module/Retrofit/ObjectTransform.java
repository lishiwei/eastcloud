package com.orientalfinance.eastcloud.module.Retrofit;


import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 29435 on 2017/6/7.
 */

public class ObjectTransform<T extends Object> implements FlowableTransformer<EastCloudResponseBody<T>, T> {
    @Override
    public Publisher<T> apply(Flowable<EastCloudResponseBody<T>> upstream) {
        return upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody<T>, T>() {
            @Override
            public T apply(EastCloudResponseBody<T> tEastCloudResponseBody) throws Exception {
                if (tEastCloudResponseBody.getResult() == null) {

                    return null;
                } else {
                    return tEastCloudResponseBody.getResult();
                }

            }
        });
    }
}
