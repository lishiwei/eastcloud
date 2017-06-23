package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.Detail;
import com.orientalfinance.eastcloud.module.javabean.DetailChannel;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface DetailView extends BaseMvpView {

    public void showDetails(List<Detail> details);
    public void showDetailChannels(List<DetailChannel> detailChannels);
    public void showCommitSucceed();
}
