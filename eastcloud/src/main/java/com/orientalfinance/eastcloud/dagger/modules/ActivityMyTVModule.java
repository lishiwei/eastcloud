package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.eastcloud.adapter.MyTVRvAdpter;
import com.orientalfinance.eastcloud.module.javabean.TV;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lishiwei on 2017/3/31.
 */
@Module
public class ActivityMyTVModule {

    public ActivityMyTVModule() {

    }

    @Provides
    public List<TV> getTv() {
        List<TV> tvList = new ArrayList<>();
        tvList.add(new TV("我家", "客厅电视机", "0"));
        tvList.add(new TV("我家", "客厅电视机", "0"));
        tvList.add(new TV("我家", "客厅电视机", "0"));
        tvList.add(new TV("我家", "客厅电视机", "0"));
        tvList.add(new TV("我家", "客厅电视机", "0"));
        return tvList;
    }

    @Provides
    MyTVRvAdpter getAdapter(List<TV> tvList) {
        return new MyTVRvAdpter(tvList);
    }
}
