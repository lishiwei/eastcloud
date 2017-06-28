package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.ObjectTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.BankCardInfo;
import com.orientalfinance.eastcloud.module.javabean.Message;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddBankCardView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class AddBankCardPresenter extends MvpNullObjectBasePresenter<ActivityAddBankCardView> {

    public void getVerificationCode(RequestParam requestParam) {
        RemoteDataProxy.codeSend(requestParam).compose(new ObjectTransform<Message>()).subscribe(new Consumer<Message>() {
            @Override
            public void accept(@NonNull Message message) throws Exception {
                getView().codeSucceed(message);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().showError(throwable.getMessage());
            }
        });
    }

    public void checkBank(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.checkBank(requestParam).compose(new ObjectTransform<BankCardInfo>()).subscribe(new Consumer<BankCardInfo>() {
            @Override
            public void accept(@NonNull BankCardInfo bankCardInfo) throws Exception {
                getView().hideDialog();
                getView().checkSucceed(bankCardInfo);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().showError(throwable.getMessage());
            }
        });
    } public void commitBank(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.commitBank(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(@NonNull EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                getView().commitSucceed(eastCloudResponseBody);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().showError(throwable.getMessage());
            }
        });
    }
}
