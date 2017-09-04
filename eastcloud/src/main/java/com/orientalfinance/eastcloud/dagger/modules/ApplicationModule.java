package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.HotApplicationRvAdapter;
import com.orientalfinance.eastcloud.module.javabean.Application;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 29435 on 2017/5/26.
 */
@Module
public class ApplicationModule {

    @Provides
    public List<Application> getImages() {
        List<Application> mApplication = new ArrayList<>();
        mApplication.add(new Application("全部应用"));
        List<Application> temp = new ArrayList<>();
        temp.add(new Application("", "应用宝", "" + R.drawable.moyu, ""));
        temp.add(new Application("", "应用宝", "" + R.drawable.moyu, ""));
        temp.add(new Application("", "应用宝", "" + R.drawable.moyu, ""));
        Application application = new Application();
        application.setAppList(temp);
        mApplication.add(application);

        mApplication.add(new Application("热门应用"));

        mApplication.add(application);
        mApplication.add(new Application("我的应用"));

        mApplication.add(application);

        return mApplication;
    }

    @Provides
    public HotApplicationRvAdapter getadapter(List<Application> applications) {
        return new HotApplicationRvAdapter(applications);
    }
}
