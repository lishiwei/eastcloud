package com.orientalfinance.eastcloud.module.core;

import android.support.annotation.NonNull;
import android.util.Log;

import com.orientalfinance.eastcloud.module.Application;
import com.orientalfinance.eastcloud.module.Movie;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by 29435 on 2017/5/27.
 */

public class MovieRepository implements DataSource<Movie> {
    public static String TAG = MovieRepository.class.getSimpleName();
    MovieLocalDataSource mMovieLocalDataSource;
    MovieRemoteDataSource mMovieRemoteDataSource;
    List<Movie> mMovieList;

    public MovieRepository(MovieLocalDataSource movieLocalDataSource, MovieRemoteDataSource movieRemoteDataSource) {
        mMovieLocalDataSource = movieLocalDataSource;
        mMovieRemoteDataSource = movieRemoteDataSource;
        mMovieList = new ArrayList<>();
    }

    @Override
    public Flowable<List<Movie>> getDatas(int pageSize, int pageNo) {
        if (mMovieList.size() == 0) {
            return getAndSaveRemoteMovie();
        }
        else {
            return Flowable.create(new FlowableOnSubscribe<List<Movie>>() {
                @Override
                public void subscribe(FlowableEmitter<List<Movie>> e) throws Exception {
                    e.onNext(mMovieList);
                }
            }, BackpressureStrategy.BUFFER);
        }
    }

    @Override
    public void saveData(Movie data) {

    }

    private Flowable<List<Movie>> getAndSaveRemoteMovie() {

        return mMovieRemoteDataSource.getDatas(0, 0).flatMap(new Function<List<Movie>, Publisher<List<Movie>>>() {
            @Override
            public Publisher<List<Movie>> apply(List<Movie> movies) throws Exception {

                return (Publisher<List<Movie>>) Flowable.fromIterable(movies).doOnNext(new Consumer<Movie>() {
                    @Override
                    public void accept(Movie movie) throws Exception {
                        Log.d(TAG, "accept: ");
                        mMovieLocalDataSource.saveData(movie);
                        mMovieList.add(movie);
                    }
                }).toList();
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {

            }
        });
    }
}
