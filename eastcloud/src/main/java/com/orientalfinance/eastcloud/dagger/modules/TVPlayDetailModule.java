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
public class TVPlayDetailModule {

    @Provides
    public Detail getComments() {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(1, "vivi", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg", "好棒哒", "10分钟前"));
        comments.add(new Comment(1, "vivi", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg", "好棒哒", "10分钟前"));
        comments.add(new Comment(1, "vivi", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg", "好棒哒", "10分钟前"));
        comments.add(new Comment(1, "vivi", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg", "好棒哒", "10分钟前"));
        comments.add(new Comment(1, "vivi", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg", "好棒哒", "10分钟前"));
        Detail detail = new Detail(""+ R.drawable.huanlexijvren, "欢乐颂2", "王吉吉", "刘涛", "2014-4-21", "2111", "98", "从外地来上海到的樊胜美（蒋欣饰），关曲尔（乔欣饰）\n" +
                "                ，邱莹莹（杨紫饰），三个女生合租一套房，与高智商海归金玲安迪（刘涛饰），魅力超群 的富家女曲筱绡（王子文饰）", comments);
        return detail;
    }

    @Provides
    public DetailRVAdapter getAdapter(Detail detail) {
        return new DetailRVAdapter(detail.getComments());
    }
}
