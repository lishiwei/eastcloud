package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.DetailRVAdapter;
import com.orientalfinance.eastcloud.adapter.PlayRecordRvAdpter;
import com.orientalfinance.eastcloud.module.Comment;
import com.orientalfinance.eastcloud.module.Detail;
import com.orientalfinance.eastcloud.module.Movie;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lishiwei on 2017/3/31.
 */
@Module
public class PlayRecordModule {

    @Provides
    public List<Movie> getLiveVideoMovie() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(""+ R.drawable.simeiren, "思美人", "虐心古装大戏"));
        movies.add(new Movie(""+R.drawable.gufangbuzishang, "孤芳不自赏", "angalebaby钟汉良"));
        movies.add(new Movie(""+R.drawable.zhuangche, "撞车", "北美票房第一名"));
        movies.add(new Movie(""+R.drawable.shanheguren, "山河故人", "柏林电影节金橄榄枝"));
        return movies;
    }

    @Provides
    public PlayRecordRvAdpter getAdapter(List<Movie> list) {
        return new PlayRecordRvAdpter(list);
    }
}
