package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.PlayRecordRvAdpter;
import com.orientalfinance.eastcloud.module.javabean.History;

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
    public List<History> getLiveVideoMovie() {
        List<History> movies = new ArrayList<>();
        movies.add(new History(""+ R.drawable.simeiren, "思美人", "aaaa","虐心古装大戏"));
        movies.add(new History(""+R.drawable.gufangbuzishang, "孤芳不自赏","aaaa", "angalebaby钟汉良"));
        movies.add(new History(""+R.drawable.zhuangche, "撞车","aaaaa", "北美票房第一名"));
        movies.add(new History(""+R.drawable.shanheguren, "山河故人","aaaaa", "柏林电影节金橄榄枝"));
        return movies;
    }

    @Provides
    public PlayRecordRvAdpter getAdapter(List<History> list) {
        return new PlayRecordRvAdpter(list);
    }
}
