package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.Collection;

import java.util.List;

/**
 * Created by lzy on 2017/6/15.
 * email:lizy@oriental-finance.com
 */

public interface ActivityMyCollectionView extends BaseMvpView {
    public void showCollection(List<Collection> collections);

    public void deleteSucceed(int id);
}
