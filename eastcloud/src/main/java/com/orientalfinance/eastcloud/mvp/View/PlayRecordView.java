package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.Channel;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface PlayRecordView extends BaseMvpView{

    public void showHistory(List<Channel> channels);

}
