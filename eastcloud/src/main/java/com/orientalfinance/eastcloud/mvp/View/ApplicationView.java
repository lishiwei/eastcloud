package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.Application;
import com.orientalfinance.eastcloud.module.javabean.Banner;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface ApplicationView extends BaseMvpView {
public void showAppList(List<Application> applications);
public void showAppBanner(List<Banner> banners);
}
