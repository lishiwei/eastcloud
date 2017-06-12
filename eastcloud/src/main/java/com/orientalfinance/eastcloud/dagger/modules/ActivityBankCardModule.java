package com.orientalfinance.eastcloud.dagger.modules;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.orientalfinance.eastcloud.adapter.BankCardInfoRvAdpter;
import com.orientalfinance.eastcloud.module.javabean.BankCardInfo;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lishiwei on 2017/3/31.
 */
@Module
public class ActivityBankCardModule {
    AppCompatActivity mAppCompatActivity;

    public ActivityBankCardModule(AppCompatActivity appCompatActivity) {
        mAppCompatActivity = appCompatActivity;
    }

    @Provides
    public List<BankCardInfo> getTv() {
        List<BankCardInfo> bankCardInfoList = new ArrayList<>();
        bankCardInfoList.add(new BankCardInfo("工商银行", "储蓄卡", "123456789", ""));
        bankCardInfoList.add(new BankCardInfo("工商银行", "储蓄卡", "123456789", ""));
        bankCardInfoList.add(new BankCardInfo("工商银行", "储蓄卡", "123456789", ""));
        bankCardInfoList.add(new BankCardInfo("工商银行", "储蓄卡", "123456789", ""));
        bankCardInfoList.add(new BankCardInfo("工商银行", "储蓄卡", "123456789", ""));
        return bankCardInfoList;
    }

    @Provides
    BankCardInfoRvAdpter getAdapter(List<BankCardInfo> bankCardInfos) {
        return new BankCardInfoRvAdpter(bankCardInfos);
    }

    @Provides
    FullyLinearLayoutManager getLinearLayoutManager() {
        return new FullyLinearLayoutManager(mAppCompatActivity, LinearLayoutManager.VERTICAL, false);
    }
}
