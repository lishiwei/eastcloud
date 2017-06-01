package com.orientalfinance.eastcloud.module.Retrofit;

import com.orientalfinance.eastcloud.module.Movie;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 29435 on 2017/5/31.
 */

public interface ApiService {

    @GET("users/{user}/repos")
    Flowable<List<Movie>> getMovies(int pageSize, int pageNum);
}
