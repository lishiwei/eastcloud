package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.BankCardInfo;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface BankCardView extends BaseMvpView {
    public void showBankCard(List<BankCardInfo> bankCardInfos);
}
