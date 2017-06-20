package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.Advertisement;
import com.orientalfinance.eastcloud.module.javabean.Banner;
import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface CurrentHitView extends BaseMvpView {

    void showBanner(List<Banner> banners);

    void showAdvertisement(List<Advertisement> advertisements);
    void showCurrentHit(List<HomepageProgram> advertisements);
    void showProgramList(List<HomepageProgram> advertisements);

}
