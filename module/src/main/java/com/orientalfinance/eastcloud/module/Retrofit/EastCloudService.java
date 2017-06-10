package com.orientalfinance.eastcloud.module.Retrofit;


import com.orientalfinance.eastcloud.module.javabean.Movie;
import com.orientalfinance.eastcloud.module.javabean.User;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by 29435 on 2017/5/31.
 */

public interface EastCloudService {

    @GET("users/{user}/repos")
    Flowable<List<Movie>> getMovies(String s , String  sn);
    @GET("users/{user}/repos")
    Flowable<User> login(String s , String  sn);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> changePassword(String s ,String  sn);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> regist(String s ,String  sn);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> getDedail(String s ,String  sn);

    /**
     * test
     */
    

}
