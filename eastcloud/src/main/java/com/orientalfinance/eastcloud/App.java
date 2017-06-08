package com.orientalfinance.eastcloud;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.support.multidex.MultiDex;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.model.FunctionConfig;
import com.luck.picture.lib.model.FunctionOptions;
import com.luck.picture.lib.model.PictureConfig;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerAppComponent;
import com.orientalfinance.eastcloud.dagger.modules.AppModules;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

import static com.umeng.socialize.utils.DeviceConfig.context;

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
        FunctionOptions options = new FunctionOptions.Builder()
                .setType(FunctionConfig.TYPE_IMAGE)
                .setCompress(true)
                .setGrade(Luban.THIRD_GEAR)
                .create();
        PictureConfig.getInstance().init(options);
        JPushInterface.setDebugMode(true);//正式版的时候设置false，关闭调试
        JPushInterface.init(this);
        //建议添加tag标签，发送消息的之后就可以指定tag标签来发送了
        Set<String> set = new HashSet<>();
        set.add("lishiwei");//名字任意，可多添加几个
        JPushInterface.setTags(this, set, null);//设置标签
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static App getApp() {
        return mApp;
    }
}
