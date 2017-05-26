package com.orientalfinance.eastcloud.dagger.modules;

import android.content.Context;


import com.orientalfinance.eastcloud.App;
import com.orientalfinance.eastcloud.utils.ExecutorUtils;
import com.orientalfinance.eastcloud.utils.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lishiwei on 2017/3/13.
 */


@Module
public class AppModules {
    private final App mApp;

    public AppModules(App app)
    {
        this.mApp = app;
    }
    @Provides
    @Singleton
    public ThreadExecutor providerExecutor(ExecutorUtils executorUtils) {
        return executorUtils;
    }
    @Provides
    @Singleton
    Context providerApplicationContext()
    {
        return mApp;
    }
}
