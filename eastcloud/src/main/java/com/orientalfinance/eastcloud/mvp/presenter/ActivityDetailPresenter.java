package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Comment;
import com.orientalfinance.eastcloud.module.javabean.Detail;
import com.orientalfinance.eastcloud.module.javabean.DetailChannel;
import com.orientalfinance.eastcloud.mvp.View.DetailView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityDetailPresenter extends MvpNullObjectBasePresenter<DetailView> {
    private static final String TAG = ActivityDetailPresenter.class.getSimpleName();
    Detail mDetail;

    @Inject
    public ActivityDetailPresenter(Detail detail) {
        mDetail = detail;
    }

    public void start() {

    }

    public void getDetail(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showDetailList(requestParam).compose(new ListTransform<List<Detail>>()).subscribe(new Consumer<List<Detail>>() {
            @Override
            public void accept(@NonNull List<Detail> details) throws Exception {
                getView().hideDialog();
                getView().showDetails(details);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });
    }

    public void getDetailChannels(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showDetailChannel(requestParam).compose(new ListTransform<List<DetailChannel>>()).subscribe(new Consumer<List<DetailChannel>>() {
            @Override
            public void accept(@NonNull List<DetailChannel> channelList) throws Exception {
                getView().hideDialog();
                getView().showDetailChannels(channelList);
            }

        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });
    }

    public void getDetailComments(RequestParam requestParam) {
        RemoteDataProxy.showDetailComments(requestParam).compose(new ListTransform<List<Comment>>()).subscribe(new Consumer<List<Comment>>() {
            @Override
            public void accept(@NonNull List<Comment> comments) throws Exception {

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);

            }
        });
    }
    public void commitComment(RequestParam requestParam)
    {
        RemoteDataProxy.commitComment(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(@NonNull EastCloudResponseBody eastCloudResponseBody) throws Exception {

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);

            }
        });
    }
}
