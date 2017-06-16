package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.Appointment;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface MyAppointmentView extends BaseMvpView {

    void showAppointment(List<Appointment> appointments);

    void deleteSucceed(int position);
    void deleteFailed(int position);
}
