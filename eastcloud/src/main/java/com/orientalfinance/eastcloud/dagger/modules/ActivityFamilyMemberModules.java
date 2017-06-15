package com.orientalfinance.eastcloud.dagger.modules;

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

        return familyMembers;
    }

    @Provides
    FamilyMemberRvAdapter getAdapter(List<FamilyMember> familyMembers) {
        return new FamilyMemberRvAdapter(familyMembers);
    }
}
