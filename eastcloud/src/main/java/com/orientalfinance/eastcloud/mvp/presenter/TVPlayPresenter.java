package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;
import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;
import com.orientalfinance.eastcloud.mvp.View.TVPlayView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


/**
 * Created by 29435 on 2017/5/25.
 */

public class TVPlayPresenter extends MvpNullObjectBasePresenter<TVPlayView> {
    public static String TAG = TVPlayPresenter.class.getSimpleName();




    @Inject
    public TVPlayPresenter() {

    }
    public void showProgramList(final RequestParam requestParam) {

        RemoteDataProxy.showProgramList(requestParam).compose(new ListTransform<List<HomepageProgram>>()).subscribe(new Consumer<List<HomepageProgram>>() {
            @Override
            public void accept(@NonNull List<HomepageProgram> homepagePrograms) throws Exception {
                HomePageChannel.ShowChannelRequestParam showChannelRequestParam = (HomePageChannel.ShowChannelRequestParam) requestParam.getData();
                getView().showProgramList(showChannelRequestParam.getCate_id(),homepagePrograms);

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });
    }
}
