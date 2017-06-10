package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.MyselfRvAdapter;
import com.orientalfinance.eastcloud.adapter.RVAdapter;
import com.orientalfinance.eastcloud.module.javabean.ItemMyself;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 29435 on 2017/5/25.
 */
@Module
public class MyselfModule {

    @Provides
    public List<ItemMyself> getImages() {
        List<ItemMyself> itemMyselfs = new ArrayList<>();
        itemMyselfs.add(new ItemMyself(R.drawable.setting, "观看历史"));
        itemMyselfs.add(new ItemMyself(R.drawable.setting, "我的预约"));
        itemMyselfs.add(new ItemMyself(R.drawable.setting, "我的收藏"));
        itemMyselfs.add(new ItemMyself(R.drawable.setting, "我的应用"));
        itemMyselfs.add(new ItemMyself(R.drawable.setting, "我的地址"));
        itemMyselfs.add(new ItemMyself(R.drawable.setting, "绑定银行卡"));
        itemMyselfs.add(new ItemMyself(R.drawable.setting, "分享好友"));
        itemMyselfs.add(new ItemMyself(R.drawable.setting, "我的电视"));
        itemMyselfs.add(new ItemMyself(R.drawable.setting, "意见反馈"));
        return itemMyselfs;
    }

    @Provides
    public MyselfRvAdapter getAdapter(List<ItemMyself> itemMyselfs) {
        return new MyselfRvAdapter(itemMyselfs);
    }

    @Provides
    public RVAdapter getMyAdapter(List<ItemMyself> itemMyselfs) {
        return new RVAdapter<ItemMyself>(BR.item, R.layout.item_myself, itemMyselfs);
    }
}
