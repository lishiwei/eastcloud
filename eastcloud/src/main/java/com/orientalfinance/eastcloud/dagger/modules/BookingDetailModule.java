package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.eastcloud.adapter.BookingDetailRVAdapter;
import com.orientalfinance.eastcloud.adapter.CurrentHitRvAdpter;
import com.orientalfinance.eastcloud.adapter.DetailRVAdapter;
import com.orientalfinance.eastcloud.dagger.CurrentHit;
import com.orientalfinance.eastcloud.dagger.HotMovie;
import com.orientalfinance.eastcloud.dagger.HotVariety;
import com.orientalfinance.eastcloud.dagger.LiveVideo;
import com.orientalfinance.eastcloud.module.Comment;
import com.orientalfinance.eastcloud.module.Detail;
import com.orientalfinance.eastcloud.module.Movie;
import com.orientalfinance.eastcloud.module.core.MovieLocalDataSource;
import com.orientalfinance.eastcloud.module.core.MovieRemoteDataSource;
import com.orientalfinance.eastcloud.module.core.MovieRepository;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 29435 on 2017/5/26.
 */
@Module
public class BookingDetailModule {

    @Provides
    public Detail getComments() {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(1, "vivi", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg", "好棒哒", "10分钟前"));
        comments.add(new Comment(1, "vivi", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg", "好棒哒", "10分钟前"));
        comments.add(new Comment(1, "vivi", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg", "好棒哒", "10分钟前"));
        comments.add(new Comment(1, "vivi", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg", "好棒哒", "10分钟前"));
        Detail detail = new Detail("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2369900843,1093290712&fm=23&gp=0.jpg", "欢乐颂2", "王吉吉", "刘涛", "2014-4-21", "2111", "98", "从外地来上海到的樊胜美（蒋欣饰），关曲尔（乔欣饰）\n" +
                "                ，邱莹莹（杨紫饰），三个女生合租一套房，与高智商海归金玲安迪（刘涛饰），魅力超群 的富家女曲筱绡（王子文饰）", comments);
        return detail;
    }

    @Provides
    public BookingDetailRVAdapter getAdapter(Detail detail) {
        return new BookingDetailRVAdapter(detail.getComments());
    }
}
