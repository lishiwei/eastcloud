package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.History;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface PlayRecordView extends BaseMvpView {

    void showHistory(List<History> histories);

    void deleteSucceed(int id);
    void deleteFailed(int position);
}
