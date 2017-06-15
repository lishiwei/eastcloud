package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.ObjectTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Message;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.AddFamilyMemberView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.ValidateUtils;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class AddFamilyMemberPresenter extends MvpNullObjectBasePresenter<AddFamilyMemberView> {
    private static final String TAG = AddFamilyMemberPresenter.class.getSimpleName();

    @Inject
    public AddFamilyMemberPresenter() {
    }

    public void sendVerificationCode(RequestParam requestParam) {

        getView().showDialog();
        if (!ValidateUtils.isMobileNO(((User.SendCodeRequestParam) requestParam.getData()).phone)) {
            getView().showError("您的手机号输入有误!");
            return;
        }

        RemoteDataProxy.codeSend(requestParam).compose(new ObjectTransform<Message>()).subscribe(new Consumer<Message>() {
            @Override
            public void accept(@NonNull Message message) throws Exception {
                getView().hideDialog();
                getView().showCodeSucceed(message.getMsgId());
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });
    }

    public void addFamilyMember(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.addFamily(requestParam).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(@NonNull EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                getView().showAddSucceed();
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
