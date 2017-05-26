package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.eastcloud.App;

import com.orientalfinance.eastcloud.adapter.CurrentHitRvAdpter;
import com.orientalfinance.eastcloud.adapter.HotApplicationRvAdapter;
import com.orientalfinance.eastcloud.adapter.LiveVideoRvAdapter;
import com.orientalfinance.eastcloud.dagger.CurrentHit;
import com.orientalfinance.eastcloud.dagger.LiveVideo;
import com.orientalfinance.eastcloud.module.Application;
import com.orientalfinance.eastcloud.module.Movie;

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
       mApplication.add(new Application("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg","理财宝"));
       mApplication.add(new Application("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg","电视管家"));
       mApplication.add(new Application("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg","钱袋"));
       mApplication.add(new Application("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg","闪惠"));
       mApplication.add(new Application("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg","闪惠"));
       mApplication.add(new Application("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg","闪惠"));
        return mApplication;
    }

    @Provides
    public HotApplicationRvAdapter getadapter(List<Application> applications) {
        return new HotApplicationRvAdapter(applications);
    }

}
