package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.FamilyMember;

import java.util.List;

/**
 * Created by 29435 on 2017/6/2.
 */

public interface FamilyMemberView extends BaseMvpView {
    void showFamilyMember(List<FamilyMember> familyMembers);
}
