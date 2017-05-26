package com.orientalfinance.eastcloud.dagger.component;


import com.orientalfinance.eastcloud.dagger.modules.AppModules;
import com.orientalfinance.eastcloud.utils.ExecutorUtils;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lishiwei on 2017/3/13.
 */
@Singleton
@Component(modules = AppModules.class)
public interface AppComponent  {
    ExecutorUtils getExecutors();
}
