package com.orientalfinance.eastcloud.module.core;

import android.support.annotation.NonNull;
import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by lishiwei on 16/5/17.
 */
public interface DataSource < T > {
    Flowable<List<T>> getDatas(int pageSize, int pageNo);

    public void saveData(T data);

}
