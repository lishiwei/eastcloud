package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ManagerAddressView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.ValidateUtils;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class ActivityManagerAddressPresenter extends MvpNullObjectBasePresenter<ManagerAddressView> {
public static String TAG = ActivityManagerAddressPresenter.class.getSimpleName();
    public void getAddress(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.getAddress(requestParam).compose(new ListTransform<List<Address>>())
                .subscribe(new Consumer<List<Address>>() {
                    @Override
                    public void accept(List<Address> addresses) throws Exception {
                        getView().hideDialog();
                        getView().showSuccess(addresses);
                    }
                }, new MyConsumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        super.accept(throwable);
                        getView().hideDialog();
                    }
                });
    }
    public void editAddress(RequestParam requestParam) {
       Address.EditRequestParam  editRequestParam = (Address.EditRequestParam) requestParam.getData();
        if (!ValidateUtils.isMobileNO(editRequestParam.getPhone()))
        {
            getView().showError("您的手机号码不正确！");
            return;
        }
        getView().showDialog();
        RemoteDataProxy.editAddress(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                getView().editSuccess();

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {

                getView().hideDialog();

            }
        });
    }
    public void deleteAddress(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.deleteAddress(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                getView().deleteSuccess();

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
