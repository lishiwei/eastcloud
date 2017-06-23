package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface ShangHaiView extends BaseMvpView {
public void showChannelList(List<HomePageChannel> homePageChannels);
}
