package com.orientalfinance.eastcloud.dagger.modules;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.FamilyMemberRvAdapter;
import com.orientalfinance.eastcloud.module.javabean.FamilyMember;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lishiwei on 2017/3/31.
 */
@Module
public class ActivityFamilyMemberModules {

    public ActivityFamilyMemberModules() {

    }

    @Provides
    public List<FamilyMember> getFamilyMember() {
        List<FamilyMember> familyMembers = new ArrayList<>();
        familyMembers.add(new FamilyMember(R.drawable.moyu+"", "太上皇"));
        familyMembers.add(new FamilyMember(R.drawable.moyu+"", "皇后"));
        familyMembers.add(new FamilyMember(R.drawable.moyu+"", "皇阿玛"));
        familyMembers.add(new FamilyMember(R.drawable.moyu+"", "增加成员"));
        return familyMembers;
    }

    @Provides
    FamilyMemberRvAdapter getAdapter(List<FamilyMember> familyMembers) {
        return new FamilyMemberRvAdapter(familyMembers);
    }
}
