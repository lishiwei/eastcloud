package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.eastcloud.dagger.qualifier.PerFragment;
import com.orientalfinance.eastcloud.module.core.HomePageProgramLocalDataSource;
import com.orientalfinance.eastcloud.module.core.HomePageProgramRemoteDataSource;
import com.orientalfinance.eastcloud.module.core.HomePageProgramRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 29435 on 2017/5/26.
 */
@Module
public class CurrentHitModule {

//    @Provides
//    public List<String> getImages() {
//        List<String> mImageUrl = new ArrayList<>();
//        mImageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495688974250&di=c382c32a6fb44c42537924b23ae89265&imgtype=0&src=http%3A%2F%2Fwww.dj193.com%2Fat%2FImage_1347.jpg");
//        mImageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495688495353&di=57da1cd0358b1e0a045c68deb7183ee4&imgtype=0&src=http%3A%2F%2Fimg2.manshijian.com%2Fupload%2Fmember%2Fimage%2F1417%2F6aec1cdeeb9906bd921fd56d4c5edebf.jpg");
//        mImageUrl.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg");
//        return mImageUrl;
//    }
//
//    @Provides
//    @CurrentHit
//    public CurrentHitRvAdpter getadapter(@CurrentHit List<HomepageProgram> movies) {
//        return new CurrentHitRvAdpter(movies);
//    }
//
    @Provides
    @PerFragment
    public HomePageProgramRepository getRespository() {
        return new HomePageProgramRepository(new HomePageProgramLocalDataSource(), new HomePageProgramRemoteDataSource());
    }
//
//    @Provides
//    @LiveVideo
//    public LiveVideoRvAdapter getLiveVideoDapter(@LiveVideo List<HomepageProgram> movies) {
//        return new LiveVideoRvAdapter(movies);
//    }
//
//    @Provides
//    @LiveVideo
//    public List<HomepageProgram> getLiveVideoMovie() {
//        List<HomepageProgram> movies = new ArrayList<>();
//        movies.add(new HomepageProgram(R.drawable.taiguoezuojvzhiwen+"", "泰国恶作剧之吻", "小清新二次元恋爱奋斗史","",""));
//        movies.add(new HomepageProgram(+R.drawable.gujianqitan+"", "古剑奇谭3", "李易峰今晚8:00决战大开始","",""));
//        movies.add(new HomepageProgram(R.drawable.qipashuo+"", "奇葩说", "单亲妈妈到底是利还是弊","",""));
//        movies.add(new HomepageProgram(R.drawable.benpaobaxiongdi+"", "奔跑吧兄弟2", "神秘嘉宾叫嚣大黑牛李晨","",""));
//        return movies;
//    }
//
//    @Provides
//    @CurrentHit
//    public List<HomepageProgram> getCurrentHitMovie() {
//        List<HomepageProgram> movies = new ArrayList<>();
//        movies.add(new HomepageProgram(R.drawable.taiguoezuojvzhiwen+"", "泰国恶作剧之吻", "小清新二次元恋爱奋斗史","",""));
//        movies.add(new HomepageProgram(+R.drawable.gujianqitan+"", "古剑奇谭3", "李易峰今晚8:00决战大开始","",""));
//        movies.add(new HomepageProgram(R.drawable.qipashuo+"", "奇葩说", "单亲妈妈到底是利还是弊","",""));
//        movies.add(new HomepageProgram(R.drawable.benpaobaxiongdi+"", "奔跑吧兄弟2", "神秘嘉宾叫嚣大黑牛李晨","",""));
//        return movies;
//    }
}
