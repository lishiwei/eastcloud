package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.TV;
import com.orientalfinance.eastcloud.mvp.View.MyTVView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 29435 on 2017/5/26.
 */

public class MyTvPresenter extends MvpNullObjectBasePresenter<MyTVView> {
    private static final String TAG = MyTvPresenter.class.getSimpleName();

    @Inject
    public MyTvPresenter() {
    }

    public void showTVBox(RequestParam requestParam) {


        RemoteDataProxy.showTvBoxList(requestParam).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody<TV>, List<TV>>() {
            @Override
            public List<TV> apply(EastCloudResponseBody<TV> tvResponseBody) throws Exception {
                return tvResponseBody.getResult();
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtils.d(TAG, "accept: " + throwable.getMessage());
            }
        }).subscribe(new Consumer<List<TV>>() {
                         @Override
                         public void accept(List<TV> list) throws Exception {
                             LogUtils.d(TAG, "accept: " + list.toString());
                         }
                     }
        );
//        RemoteDataProxy.showTvBoxList1(requestParam).compose(new ObjectTransform<ResponseBody>()).doOnError(new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                LogUtils.d(TAG, "accept:throwable " + throwable.toString());
//                LogUtils.d(TAG, "accept: throwable" + throwable.getMessage());
//            }
//        }).subscribe(new Consumer<ResponseBody>() {
//            @Override
//            public void accept(ResponseBody tvList) throws Exception {
//
//                LogUtils.d(TAG, "accept: " + tvList.contentLength());
//                LogUtils.d(TAG, "accept: " + tvList.toString());
//            }
//        });
    }

    public void delTVBox(final RequestParam requestParam) {


        RemoteDataProxy.delTvBox(requestParam).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody, String>() {
            @Override
            public String apply(EastCloudResponseBody eastCloudResponseBody) throws Exception {
                return eastCloudResponseBody.getCode();
            }
        })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.d(TAG, "accept: " + throwable.getMessage());
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                if (s == null) {

                }
            }
        });

    }

    public void scanTVBox(RequestParam requestParam) {


        RemoteDataProxy.scanTvBox(requestParam).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody<TV>, List<TV>>() {
            @Override
            public List<TV> apply(EastCloudResponseBody<TV> tvResponseBody) throws Exception {
                return tvResponseBody.getResult();
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                LogUtils.d(TAG, "accept: " + throwable.getMessage());
            }
        }).subscribe(new Consumer<List<TV>>() {
                         @Override
                         public void accept(List<TV> list) throws Exception {
                             LogUtils.d(TAG, "accept: " + list.toString());
                         }
                     }
        );
//        RemoteDataProxy.showTvBoxList1(requestParam).compose(new ObjectTransform<ResponseBody>()).doOnError(new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                LogUtils.d(TAG, "accept:throwable " + throwable.toString());
//                LogUtils.d(TAG, "accept: throwable" + throwable.getMessage());
//            }
//        }).subscribe(new Consumer<ResponseBody>() {
//            @Override
//            public void accept(ResponseBody tvList) throws Exception {
//
//                LogUtils.d(TAG, "accept: " + tvList.contentLength());
//                LogUtils.d(TAG, "accept: " + tvList.toString());
//            }
//        });
    }

    @Override
    public void attachView(MyTVView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }


    public void start() {


    }
}
