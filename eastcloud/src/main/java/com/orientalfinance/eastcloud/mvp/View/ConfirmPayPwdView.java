package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public interface ConfirmPayPwdView extends BaseMvpView {
    public void commitSucceed(EastCloudResponseBody eastCloudResponseBody);

}
