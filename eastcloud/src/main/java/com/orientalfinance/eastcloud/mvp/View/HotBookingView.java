package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.AppointmentProgram;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface HotBookingView extends BaseMvpView {

    void showExchangeHotMovie();
    void stopExchangeHotMovie();

    void showHotVariety();
    void stopHotVariety();

    void exchangeHotMovie(List<AppointmentProgram> appointmentPrograms);

    void exchangeHotVariety(List<AppointmentProgram> appointmentPrograms);
}
