package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.CheckVersionResult;
import com.orientalfinance.eastcloud.module.javabean.RecommandCategory;

import java.util.List;

/**
 * Created by 29435 on 2017/5/25.
 */

public interface HomepageView extends BaseMvpView {
    public void showCategory(List<RecommandCategory> categories);
public void checkVersionSucceed(CheckVersionResult checkVersionResult);
}
