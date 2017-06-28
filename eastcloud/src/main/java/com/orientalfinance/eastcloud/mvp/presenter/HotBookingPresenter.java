package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.AppointmentProgram;
import com.orientalfinance.eastcloud.mvp.View.HotBookingView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/25.
 */

public class HotBookingPresenter extends MvpNullObjectBasePresenter<HotBookingView> {

    @Inject
    public HotBookingPresenter() {

    }


    public void exchangeHotMovie(RequestParam requestParam) {

        getView().showExchangeHotMovie();
        RemoteDataProxy.showAppointmentProgram(requestParam).compose(new ListTransform<List<AppointmentProgram>>()).subscribe(new Consumer<List<AppointmentProgram>>() {
            @Override
            public void accept(@NonNull List<AppointmentProgram> appointmentPrograms) throws Exception {
                getView().stopExchangeHotMovie();
                getView().exchangeHotMovie(appointmentPrograms);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().stopExchangeHotMovie();

            }
        });
    }

    public void exchangeHotVariety(RequestParam requestParam) {

        getView().showHotVariety();

        RemoteDataProxy.showAppointmentProgram(requestParam).compose(new ListTransform<List<AppointmentProgram>>()).subscribe(new Consumer<List<AppointmentProgram>>() {
            @Override
            public void accept(@NonNull List<AppointmentProgram> appointmentPrograms) throws Exception {
                getView().stopHotVariety();
                getView().exchangeHotMovie(appointmentPrograms);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().stopHotVariety();
            }
        });
    }

    public void addAppointment(RequestParam requestParam) {
        RemoteDataProxy.addAppointmentProgram(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(@NonNull EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().showSucceed();
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
            }
        });
    }
    public void deleteAppointment(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.deleteAppointment(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(@NonNull EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                getView().showSucceed();
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
