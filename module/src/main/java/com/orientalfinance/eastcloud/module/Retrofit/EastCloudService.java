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
    Flowable<List<Movie>> getMovies(RequestParam requestParam);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> login(RequestParam requestParam);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> changePassword(RequestParam requestParam);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> regist(RequestParam requestParam);
    @GET("users/{user}/repos")
    Flowable<List<Movie>> getDedail(RequestParam requestParam);

}
