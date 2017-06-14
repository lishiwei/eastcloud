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

public class NullTransform implements FlowableTransformer<EastCloudResponseBody, EastCloudResponseBody> {
    @Override
    public Publisher<EastCloudResponseBody> apply(Flowable<EastCloudResponseBody> upstream) {
        return upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody, EastCloudResponseBody>() {
            @Override
            public EastCloudResponseBody apply(EastCloudResponseBody tEastCloudResponseBody) throws Exception {
                return tEastCloudResponseBody;

            }
        });
    }
}
