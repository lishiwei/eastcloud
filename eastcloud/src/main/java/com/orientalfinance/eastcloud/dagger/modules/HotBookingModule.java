package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.eastcloud.adapter.HotBookingRvAdpter;
import com.orientalfinance.eastcloud.dagger.qualifier.CurrentHit;
import com.orientalfinance.eastcloud.dagger.qualifier.HotMovie;
import com.orientalfinance.eastcloud.dagger.qualifier.HotVariety;
import com.orientalfinance.eastcloud.dagger.qualifier.LiveVideo;
import com.orientalfinance.eastcloud.module.core.HomePageProgramLocalDataSource;
import com.orientalfinance.eastcloud.module.core.HomePageProgramRemoteDataSource;
import com.orientalfinance.eastcloud.module.core.HomePageProgramRepository;
import com.orientalfinance.eastcloud.module.javabean.AppointmentProgram;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 29435 on 2017/5/26.
 */
@Module
public class HotBookingModule {

    @Provides
    @HotMovie
    public HotBookingRvAdpter getHotMovieAdapter(@CurrentHit List<AppointmentProgram> movies) {
        return new HotBookingRvAdpter(movies);
    }

    @Provides
    @HotVariety
    public HotBookingRvAdpter getHotVarietyAdapter(@CurrentHit List<AppointmentProgram> movies) {
        return new HotBookingRvAdpter(movies);
    }

    @Provides
    public HomePageProgramRepository getRespository() {
        return new HomePageProgramRepository(new HomePageProgramLocalDataSource(), new HomePageProgramRemoteDataSource());
    }

    @Provides
    @LiveVideo
    public List<AppointmentProgram> getLiveVideoMovie() {
        List<AppointmentProgram> movies = new ArrayList<>();
        movies.add(new AppointmentProgram("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg", "1111","思美人", "虐心古装大戏","",""));
        movies.add(new AppointmentProgram("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "孤芳不自赏", "angalebaby钟汉良","","",""));
        movies.add(new AppointmentProgram("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "撞车", "北美票房第一名","","",""));
        movies.add(new AppointmentProgram("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "山河故人", "柏林电影节金橄榄枝","","",""));
        return movies;
    }

    @Provides
    @CurrentHit
    public List<AppointmentProgram> getCurrentHitMovie() {
        List<AppointmentProgram> movies = new ArrayList<>();
        movies.add(new AppointmentProgram("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg","1", "思美人", "虐心古装大戏","",null));
        movies.add(new AppointmentProgram("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "孤芳不自赏", "angalebaby钟汉良","","",""));
        movies.add(new AppointmentProgram("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "撞车", "北美票房第一名","","",null));
        movies.add(new AppointmentProgram("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "山河故人", "柏林电影节金橄榄枝","","",""));
        movies.add(new AppointmentProgram("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "三生三世", "玄幻仙侠 爱恋三世","","",""));
        movies.add(new AppointmentProgram("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789120684&di=b8f339571076919f41f545f062144957&imgtype=0&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Fnews%2F20160327%2F201603271858181486.jpg", "漂亮的她", "热巴变形记","","",""));
        return movies;
    }
}
