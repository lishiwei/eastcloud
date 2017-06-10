package com.orientalfinance.eastcloud.dagger.component;

import com.orientalfinance.eastcloud.activity.ActivityMyTV;
import com.orientalfinance.eastcloud.dagger.BaseActivityComponent;
import com.orientalfinance.eastcloud.dagger.modules.ActivityMyTVModule;
import com.orientalfinance.eastcloud.dagger.qualifier.PerActivity;

import dagger.Component;

/**
 * Created by lishiwei on 2017/3/31.
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = ActivityMyTVModule.class)
public interface ActivityMyTVComponent extends BaseActivityComponent<ActivityMyTV> {

}
