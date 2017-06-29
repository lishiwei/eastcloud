package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.ChannelCategory;
import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface ChannelView extends BaseMvpView {
    public void showChannelCategory(List<ChannelCategory> categories);

    public void showChannelList(List<HomePageChannel> channels);
}
