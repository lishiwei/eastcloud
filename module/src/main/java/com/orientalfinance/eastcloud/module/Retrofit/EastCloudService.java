package com.orientalfinance.eastcloud.module.Retrofit;

import com.orientalfinance.eastcloud.module.Movie;
import com.orientalfinance.eastcloud.module.core.RequestParam;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 29435 on 2017/5/31.
 */

public interface EastCloudService {

    @GET("users/{user}/repos")
    Flowable<List<Movie>> getMovies(String s ,String  sn);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> login(String s ,String  sn);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> changePassword(String s ,String  sn);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> regist(String s ,String  sn);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> getDedail(String s ,String  sn);

}
