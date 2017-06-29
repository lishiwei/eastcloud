package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.RecommandCategory;
import com.orientalfinance.eastcloud.mvp.View.HomepageView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/25.
 */

public class HomePagePresenter extends MvpNullObjectBasePresenter<HomepageView> {
    @Inject
    public HomePagePresenter() {
    }

    public void showCategory(RequestParam requestParam) {
        RemoteDataProxy.showCategory(requestParam).compose(new ListTransform<List<RecommandCategory>>()).subscribe(new Consumer<List<RecommandCategory>>() {
            @Override
            public void accept(@NonNull List<RecommandCategory> categories) throws Exception {
                getView().showCategory(categories);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
            }
        });
    }


}
