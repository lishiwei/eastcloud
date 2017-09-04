package com.orientalfinance.eastcloud.module.core;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by 29435 on 2017/5/27.
 */

public class HomePageProgramRemoteDataSource implements DataSource<HomepageProgram> {


    @Override
    public Flowable<List<HomepageProgram>> getDatas(com.orientalfinance.eastcloud.module.Retrofit.RequestParam requestParam) {
        return RemoteDataProxy.showProgramList(requestParam).compose(new ListTransform<List<HomepageProgram>>());
    }

    @Override
    public void saveData(HomepageProgram data) {

    }
}
