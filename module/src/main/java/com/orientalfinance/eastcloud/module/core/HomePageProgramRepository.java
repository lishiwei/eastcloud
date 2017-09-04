package com.orientalfinance.eastcloud.module.core;

import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by 29435 on 2017/5/27.
 */

public class HomePageProgramRepository implements DataSource<HomepageProgram> {
    public static String TAG = HomePageProgramRepository.class.getSimpleName();
    HomePageProgramLocalDataSource mHomePageProgramLocalDataSource;
    HomePageProgramRemoteDataSource mHomePageProgramRemoteDataSource;
    List<HomepageProgram> mHomePageProgramList;


    public HomePageProgramRepository(HomePageProgramLocalDataSource HomePageProgramLocalDataSource, HomePageProgramRemoteDataSource HomePageProgramRemoteDataSource) {
        mHomePageProgramLocalDataSource = HomePageProgramLocalDataSource;
        mHomePageProgramRemoteDataSource = HomePageProgramRemoteDataSource;
        mHomePageProgramList = new ArrayList<>();
    }

    @Override
    public Flowable<List<HomepageProgram>> getDatas(com.orientalfinance.eastcloud.module.Retrofit.RequestParam requestParam) {
        if (mHomePageProgramList.size() == 0) {
            return getAndSaveRemoteHomePageProgram(requestParam);
        } else if ( !isDirty()) {
            return Flowable.create(new FlowableOnSubscribe<List<HomepageProgram>>() {
                @Override
                public void subscribe(FlowableEmitter<List<HomepageProgram>> e) throws Exception {
                    e.onNext(mHomePageProgramList);
                }
            }, BackpressureStrategy.BUFFER);
        }
        // TODO: 2017/7/25  
        /* 时间过期或者其他的内存缓存不可用逻辑*/
        else {
            return Flowable.concat(mHomePageProgramLocalDataSource.getDatas(requestParam), mHomePageProgramRemoteDataSource.getDatas(requestParam)).first(mHomePageProgramList).toFlowable();
        }
    }

    // TODO: 2017/7/25  
    /* 内存缓存是否可用逻辑*/
    public boolean isDirty() {
        return false;
    }

    @Override
    public void saveData(HomepageProgram data) {

    }

    private Flowable<List<HomepageProgram>> getAndSaveRemoteHomePageProgram(com.orientalfinance.eastcloud.module.Retrofit.RequestParam requestParam) {
        return mHomePageProgramRemoteDataSource.getDatas(requestParam).flatMap(new Function<List<HomepageProgram>, Flowable<List<HomepageProgram>>>() {
            @Override
            public Flowable<List<HomepageProgram>> apply(List<HomepageProgram> HomePagePrograms) throws Exception {
                return Flowable.fromIterable(HomePagePrograms).doOnNext(new Consumer<HomepageProgram>() {
                    @Override
                    public void accept(HomepageProgram homepageProgram) throws Exception {
                        mHomePageProgramLocalDataSource.saveData(homepageProgram);
                        mHomePageProgramList.add(homepageProgram);
                    }
                }).toList().toFlowable();
            }
        });
    }
}
