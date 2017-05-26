package com.orientalfinance.eastcloud.utils;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;
@Singleton
public class ExecutorUtils implements ThreadExecutor{

    private ExecutorService mExecutor;
    @Inject
     ExecutorUtils() {
        mExecutor = Executors.newFixedThreadPool(5);
    }

    @Override
    public void execute(@NonNull Runnable command) {
        mExecutor.submit(command);
    }

    public void submitRunnable(Runnable runnable) {
        mExecutor.submit(runnable);
    }

}