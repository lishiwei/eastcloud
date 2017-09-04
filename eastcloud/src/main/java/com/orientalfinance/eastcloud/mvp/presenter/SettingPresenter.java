package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.ObjectTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.AvatarUrl;
import com.orientalfinance.eastcloud.mvp.View.SettingView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.io.File;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class SettingPresenter extends MvpNullObjectBasePresenter<SettingView> {

    public void modifyUserInfo(RequestParam requestParam, final File file) {
        getView().showDialog();
        RemoteDataProxy.modifyUserInfo(requestParam,file).compose(new ObjectTransform<AvatarUrl>()).subscribe(new Consumer<AvatarUrl>() {
            @Override
            public void accept(@NonNull AvatarUrl AvatarUrl) throws Exception {
                getView().hideDialog();
                getView().showSucceed();
                if (file!=null)
                {
                    getView().updateAvatarSucceed(file.getPath());
                }
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

