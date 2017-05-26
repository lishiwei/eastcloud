package com.orientalfinance.eastcloud.dagger.modules;

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
    public ChannelRvAdapter getAdapter(List<Channel> channels) {
        return new ChannelRvAdapter(channels);
    }

    @Provides
    public List<Channel> getChannels() {
        List<Channel> channels = new ArrayList<>();
        channels.add(new Channel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg", "东方卫视", "欢乐颂-第54集", "http://pic.baike.soso.com/p/20131019/20131019001129-112799030.jpg", "19:37"));
        channels.add(new Channel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg", "东方有线", "美国19届环球音乐奖盛典", "http://pic.baike.soso.com/p/20131019/20131019001129-112799030.jpg", "19:37"));
        channels.add(new Channel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg", "城市娱乐", "上海滩大佬们的新生活", "http://pic.baike.soso.com/p/20131019/20131019001129-112799030.jpg", "19:37"));
        channels.add(new Channel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg", "动物世界欢乐多", "野外的生物链", "http://pic.baike.soso.com/p/20131019/20131019001129-112799030.jpg", "19:37"));
        channels.add(new Channel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg", "都市丽人", "天天健身打造迷人人鱼线", "http://pic.baike.soso.com/p/20131019/20131019001129-112799030.jpg", "19:37"));
        channels.add(new Channel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg", "新闻八点档", "欢乐颂", "http://pic.baike.soso.com/p/20131019/20131019001129-112799030.jpg", "19:37"));
        return channels;
    }
}
