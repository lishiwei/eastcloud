package com.orientalfinance.eastcloud.dagger.component;

import com.orientalfinance.eastcloud.activity.ActivityHotBooking;
import com.orientalfinance.eastcloud.dagger.BaseActivityComponent;
import com.orientalfinance.eastcloud.dagger.qualifier.PerActivity;
import com.orientalfinance.eastcloud.dagger.modules.HotBookingModule;

import dagger.Component;

/**
 * Created by lishiwei on 2017/3/31.
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = HotBookingModule.class)
public interface HotBookingComponent extends BaseActivityComponent<ActivityHotBooking>{

}
