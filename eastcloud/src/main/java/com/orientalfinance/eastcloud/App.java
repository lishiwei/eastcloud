package com.orientalfinance.eastcloud;

import android.app.Application;


import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerAppComponent;
import com.orientalfinance.eastcloud.dagger.modules.AppModules;

/**
 * Created by 29435 on 2017/5/25.
 */

public class App extends Application {
    AppComponent mAppComponent;
    static App mApp;
    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        this.mAppComponent = DaggerAppComponent.builder().appModules(new AppModules(this)).build();

    }
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public  static App getApp() {
        return mApp;
    }
}
