package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.BankCardInfo;
import com.orientalfinance.eastcloud.mvp.View.BankCardView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class BankCardPresenter extends MvpNullObjectBasePresenter<BankCardView> {
    private static final String TAG = BankCardPresenter.class.getSimpleName();


    @Inject
    public BankCardPresenter() {

    }

    public void getBankCard(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showBankList(requestParam).compose(new ListTransform<List<BankCardInfo>>()).subscribe(new Consumer<List<BankCardInfo>>() {
            @Override
            public void accept(@NonNull List<BankCardInfo> bankCardInfos) throws Exception {
                getView().hideDialog();
                getView().showBankCard(bankCardInfos);

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
