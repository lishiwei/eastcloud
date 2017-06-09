package com.orientalfinance.eastcloud.update;

/**
 * Created by lzy on 2017/6/9.
 * email:lizy@oriental-finance.com
 */

public interface UpdateProgressListener {

    public void start();


    public void update(int progress);


    public void success();


    public void error();
}
