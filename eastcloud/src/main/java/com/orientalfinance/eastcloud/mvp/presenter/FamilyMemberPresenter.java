package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.FamilyMember;
import com.orientalfinance.eastcloud.mvp.View.FamilyMemberView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class FamilyMemberPresenter extends MvpNullObjectBasePresenter<FamilyMemberView> {
    private static final String TAG = FamilyMemberPresenter.class.getSimpleName();

    @Inject
    public FamilyMemberPresenter() {

    }

    public void getFamily(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showFamilyList(requestParam).compose(new ListTransform<List<FamilyMember>>()).subscribe(new Consumer<List<FamilyMember>>() {
            @Override
            public void accept(@NonNull List<FamilyMember> familyMembers) throws Exception {
                getView().hideDialog();
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
