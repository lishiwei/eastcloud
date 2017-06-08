package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.DetailRVAdapter;
import com.orientalfinance.eastcloud.module.javabean.Comment;
import com.orientalfinance.eastcloud.module.javabean.Detail;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lishiwei on 2017/3/31.
 */
@Module
public class ActivityDetailModule {

    @Provides
    public Detail getComments() {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(1, "vivi", ""+ R.drawable.huanlesong, "好棒哒", "10分钟前"));
        comments.add(new Comment(1, "vivi", ""+ R.drawable.huanlesong, "好棒哒", "10分钟前"));
        comments.add(new Comment(1, "vivi", ""+ R.drawable.huanlesong, "好棒哒", "10分钟前"));
        comments.add(new Comment(1, "vivi", ""+ R.drawable.huanlesong, "好棒哒", "10分钟前"));
        Detail detail = new Detail(""+ R.drawable.huanlesong, "欢乐颂2", "导演：王吉吉", "演员：刘涛", "年代：2014-4-21", "播放：2111次播放", "评分：98分", "从外地来上海到的樊胜美（蒋欣饰），关曲尔（乔欣饰）\n" +
                "                ，邱莹莹（杨紫饰），三个女生合租一套房，与高智商海归金玲安迪（刘涛饰），魅力超群 的富家女曲筱绡（王子文饰）", comments);
        return detail;
    }

    @Provides
    public DetailRVAdapter getAdapter(Detail detail) {
        return new DetailRVAdapter(detail.getComments());
    }
}
