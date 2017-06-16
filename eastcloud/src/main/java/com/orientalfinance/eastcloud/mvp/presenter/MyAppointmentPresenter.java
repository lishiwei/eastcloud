package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Appointment;
import com.orientalfinance.eastcloud.mvp.View.MyAppointmentView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class MyAppointmentPresenter extends MvpNullObjectBasePresenter<MyAppointmentView> {
    private static final String TAG = MyAppointmentPresenter.class.getSimpleName();


    @Inject
    public MyAppointmentPresenter() {
    }

    public void showAppointment(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showAppointment(requestParam).compose(new ListTransform<List<Appointment>>()).subscribe(new Consumer<List<Appointment>>() {
            @Override
            public void accept(@NonNull List<Appointment> appointmentList) throws Exception {
                getView().hideDialog();
                getView().showAppointment(appointmentList);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });

    }

    public void deleteAppointment(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.deleteAppointment(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(@NonNull EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                getView().deleteSucceed(0);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
                getView().deleteFailed(0);

            }
        });
    }
}
