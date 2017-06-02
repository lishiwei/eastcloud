package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.ChannelRvAdapter;
import com.orientalfinance.eastcloud.module.Channel;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 29435 on 2017/5/25.
 */
@Module
public class ShangHaiModules {

    @Provides
    public List<String> getImages() {
        List<String> mImageUrl = new ArrayList<>();
        mImageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495688974250&di=c382c32a6fb44c42537924b23ae89265&imgtype=0&src=http%3A%2F%2Fwww.dj193.com%2Fat%2FImage_1347.jpg");
        mImageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495688495353&di=57da1cd0358b1e0a045c68deb7183ee4&imgtype=0&src=http%3A%2F%2Fimg2.manshijian.com%2Fupload%2Fmember%2Fimage%2F1417%2F6aec1cdeeb9906bd921fd56d4c5edebf.jpg");
        mImageUrl.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg");
        return mImageUrl;
    }

    @Provides
    public ChannelRvAdapter getAdapter(List<Channel> channels) {
        return new ChannelRvAdapter(channels);
    }

    @Provides
    public List<Channel> getChannels() {
        List<Channel> channels = new ArrayList<>();
        channels.add(new Channel(R.drawable.dongfangweishi+"", "东方卫视", "欢乐颂-第54集", R.drawable.shanghai+"", "19:37"));
        channels.add(new Channel(R.drawable.dongfangyouxian+"", "东方有线", "美国19届环球音乐奖盛典", R.drawable.shanghai+"", "19:37"));
        channels.add(new Channel(R.drawable.chengshiyule+"", "城市娱乐", "上海滩大佬们的新生活", R.drawable.shanghai+"", "19:37"));
        channels.add(new Channel(R.drawable.dongwushijie+"", "动物世界欢乐多", "野外的生物链", R.drawable.shanghai+"", "19:37"));
        channels.add(new Channel(R.drawable.doushiliren+"", "都市丽人", "天天健身打造迷人人鱼线",R.drawable.shanghai+"", "19:37"));
        channels.add(new Channel(R.drawable.xinwenbadiandang+"", "新闻八点档", "欢乐颂", R.drawable.shanghai+"", "19:37"));
        return channels;
    }
}
