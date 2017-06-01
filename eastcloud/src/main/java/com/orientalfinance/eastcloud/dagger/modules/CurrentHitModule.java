package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.eastcloud.adapter.CurrentHitRvAdpter;
import com.orientalfinance.eastcloud.adapter.LiveVideoRvAdapter;
import com.orientalfinance.eastcloud.dagger.CurrentHit;
import com.orientalfinance.eastcloud.dagger.LiveVideo;
import com.orientalfinance.eastcloud.dagger.PerFragment;
import com.orientalfinance.eastcloud.module.Movie;
import com.orientalfinance.eastcloud.module.core.MovieLocalDataSource;
import com.orientalfinance.eastcloud.module.core.MovieRemoteDataSource;
import com.orientalfinance.eastcloud.module.core.MovieRepository;
import com.orientalfinance.eastcloud.mvp.presenter.CurrentHitPresenter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 29435 on 2017/5/26.
 */
@Module
public class CurrentHitModule {

    @Provides
    public List<String> getImages() {
        List<String> mImageUrl = new ArrayList<>();
        mImageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495688974250&di=c382c32a6fb44c42537924b23ae89265&imgtype=0&src=http%3A%2F%2Fwww.dj193.com%2Fat%2FImage_1347.jpg");
        mImageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495688495353&di=57da1cd0358b1e0a045c68deb7183ee4&imgtype=0&src=http%3A%2F%2Fimg2.manshijian.com%2Fupload%2Fmember%2Fimage%2F1417%2F6aec1cdeeb9906bd921fd56d4c5edebf.jpg");
        mImageUrl.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg");
        return mImageUrl;
    }

    @Provides
    public CurrentHitRvAdpter getadapter() {
        return new CurrentHitRvAdpter(new ArrayList<Movie>());
    }
@Provides
@PerFragment
public MovieRepository getRespository()
{
    return new MovieRepository(new MovieLocalDataSource(),new MovieRemoteDataSource());
}
    @Provides
    public LiveVideoRvAdapter getLiveVideoDapter() {
        return new LiveVideoRvAdapter(new ArrayList<Movie>());
    }

    @Provides
    @LiveVideo
    public List<Movie> getLiveVideoMovie() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg", "思美人", "虐心古装大戏"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "孤芳不自赏", "angalebaby钟汉良"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "撞车", "北美票房第一名"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "山河故人", "柏林电影节金橄榄枝"));
        return movies;
    }
    @Provides
    @CurrentHit
    public List<Movie> getCurrentHitMovie() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg", "思美人", "虐心古装大戏"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "孤芳不自赏", "angalebaby钟汉良"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "撞车", "北美票房第一名"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "山河故人", "柏林电影节金橄榄枝"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496383441&di=5b5732cc70f067d23cfcb8e43e760ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Feditor%2F2017-1-8%2F201718205214593bgfed.jpg", "三生三世", "玄幻仙侠 爱恋三世"));
        movies.add(new Movie("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789120684&di=b8f339571076919f41f545f062144957&imgtype=0&src=http%3A%2F%2Fimg.52fuqing.com%2Fupload%2Fnews%2F20160327%2F201603271858181486.jpg", "漂亮的她", "热巴变形记"));
        return movies;
    }
}
