package com.orientalfinance.eastcloud.update;

/**
 * Created by lzy on 2017/6/9.
 * email:lizy@oriental-finance.com
 */

public interface UpdateProgressListener {

    void start();


    void update(int progress);


    void success();


    void error();
}
