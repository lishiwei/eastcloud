package com.orientalfinance.eastcloud;

import android.app.Application;


import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerAppComponent;
import com.orientalfinance.eastcloud.dagger.modules.AppModules;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

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
        Config.DEBUG = true;
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
        UMShareAPI.get(this);

    }
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public  static App getApp() {
        return mApp;
    }
}
