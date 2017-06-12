package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityMyBankCardBinding;
import com.orientalfinance.eastcloud.adapter.BankCardInfoRvAdpter;
import com.orientalfinance.eastcloud.dagger.component.ActivityBankCardComponent;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerActivityBankCardComponent;
import com.orientalfinance.eastcloud.dagger.modules.ActivityBankCardModule;
import com.orientalfinance.eastcloud.mvp.View.BankCardView;
import com.orientalfinance.eastcloud.mvp.View.BankCardViewState;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.BankCardPresenter;

import javax.inject.Inject;

public class ActivityMyBankCard extends BaseActivity<ActivityBankCardComponent, BankCardView, BankCardPresenter, BankCardViewState> implements BankCardView {
    ActivityMyBankCardBinding mActivityMyBankCardBinding;
    @Inject
    BankCardInfoRvAdpter mBankCardInfoRvAdpter;
    @Inject
    FullyLinearLayoutManager mFullyLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMyBankCardBinding = DataBindingUtil.setContentView(this, getLayoutId());
        setSupportActionBar(mActivityMyBankCardBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        mActivityMyBankCardBinding.rvMyBankCard.setAdapter(mBankCardInfoRvAdpter);
        mActivityMyBankCardBinding.rvMyBankCard.setLayoutManager(mFullyLinearLayoutManager);
    }

    @Override
    public boolean hasToolBar() {
        return false;
    }

    @Override
    public String getToolBarTitle() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_bank_card;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflate = getMenuInflater();

        menuInflate.inflate(R.menu.addbankcard,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu_addBankCard)
        {
//            startActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected ActivityBankCardComponent constructComponent(AppComponent appComponent) {
        return DaggerActivityBankCardComponent.builder().appComponent(appComponent).activityBankCardModule(new ActivityBankCardModule(this)).build();
    }
}
