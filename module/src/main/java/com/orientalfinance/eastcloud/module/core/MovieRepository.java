package com.orientalfinance.eastcloud.module.core;

import com.orientalfinance.eastcloud.module.javabean.Movie;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
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
    public Flowable<List<Movie>> getDatas(RequestParam requestParam) {
        if (mMovieList.size() == 0) {
            return getAndSaveRemoteMovie(requestParam);
        } else {
            return Flowable.create(new FlowableOnSubscribe<List<Movie>>() {
                @Override
                public void subscribe(FlowableEmitter<List<Movie>> e) throws Exception {
                    e.onNext(mMovieList);
                }
            }, BackpressureStrategy.BUFFER);
        }
//        else {
//            return Flowable.concat(mMovieLocalDataSource.getDatas(pageSize,pageNo),mMovieRemoteDataSource.getDatas(pageSize,pageNo)).first().toFlowable();
//        }
    }

    @Override
    public void saveData(Movie data) {

    }

    private Flowable<List<Movie>> getAndSaveRemoteMovie(RequestParam requestParam) {
        return mMovieRemoteDataSource.getDatas(requestParam).flatMap(new Function<List<Movie>, Flowable<List<Movie>>>() {
            @Override
            public Flowable<List<Movie>> apply(List<Movie> movies) throws Exception {
                return Flowable.fromIterable(movies).doOnNext(new Consumer<Movie>() {
                    @Override
                    public void accept(Movie movie) throws Exception {
                        mMovieLocalDataSource.saveData(movie);
                        mMovieList.add(movie);
                    }
                }).toList().toFlowable();
            }
        });
    }
}
