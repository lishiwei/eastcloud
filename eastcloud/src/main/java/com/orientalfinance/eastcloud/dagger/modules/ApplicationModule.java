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
        mApplication.add(new Application("" + R.drawable.licaibao, "理财宝"));
        mApplication.add(new Application("" + R.drawable.dianshiguanjia, "电视管家"));
        mApplication.add(new Application("" + R.drawable.qiandai, "钱袋"));
        mApplication.add(new Application("" + R.drawable.shanhui, "闪惠"));
        return mApplication;
    }

    @Provides
    public HotApplicationRvAdapter getadapter(List<Application> applications) {
        return new HotApplicationRvAdapter(applications);
    }
}
