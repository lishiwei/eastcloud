package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.javabean.BankCardInfo;
import com.orientalfinance.eastcloud.module.javabean.Message;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public interface ActivityAddBankCardView extends BaseMvpView {
    public void codeSucceed(Message message);
    public void checkSucceed(BankCardInfo bankCardInfo);
    public void commitSucceed(EastCloudResponseBody eastCloudResponseBody);

}
