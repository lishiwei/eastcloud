package com.orientalfinance.eastcloud.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.mvp.View.AddFamilyMemberView;
import com.orientalfinance.eastcloud.mvp.presenter.AddFamilyMemberPresenter;

public class ActivityAddFamilyMember extends MvpActivity<AddFamilyMemberView,AddFamilyMemberPresenter>implements AddFamilyMemberView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_family_member);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @NonNull
    @Override
    public AddFamilyMemberPresenter createPresenter() {
        return new AddFamilyMemberPresenter();
    }
}
