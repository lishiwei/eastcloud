package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityAddBankCardBinding;
import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.core.AcacheUtil;
import com.orientalfinance.eastcloud.module.javabean.BankCardInfo;
import com.orientalfinance.eastcloud.module.javabean.Message;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddBankCardView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.AddBankCardPresenter;
import com.orientalfinance.eastcloud.view.MSGCountTimeView;

public class ActivityAddBankCard extends BaseMVPActivity<ActivityAddBankCardView, AddBankCardPresenter>
        implements ActivityAddBankCardView, View.OnClickListener {

    private ActivityAddBankCardBinding viewDataBinding;
    String mMessageId;
    BankCardInfo mTemBankCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_bank_card);
        initViews();
    }

    private void initViews() {
        viewDataBinding.toolbar.setTitle("");
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewDataBinding.btnAddBankCard.setOnClickListener(this);
        viewDataBinding.tvGetCode.setTotaltime(10000);
        viewDataBinding.tvGetCode.isAllowRun(true);
        viewDataBinding.tvGetCode.onDownTime(new MSGCountTimeView.onDownTime() {
            @Override
            public void onClick() {
                viewDataBinding.tvGetCode.setBackgroundResource(R.drawable.msg_btn_gray_bg);
                Log.e("TAG", "tvGetCode被点击");
                //请求发送验证码
                getPresenter().getVerificationCode(new RequestParam(new User.SendCodeRequestParam(viewDataBinding.etUserPhone.getText().toString())));
            }

            @Override
            public void onCount() {

            }

            @Override
            public void onFinish() {
                viewDataBinding.tvGetCode.setBackgroundResource(R.drawable.btn_red_bg);
            }
        });
    }

    @NonNull
    @Override
    public AddBankCardPresenter createPresenter() {
        return new AddBankCardPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_bank_card:
                //TODO:
                BankCardInfo.CheckRequestParam checkRequestParam = new BankCardInfo.CheckRequestParam(viewDataBinding.etUerIDCard.getText().toString(),
                        viewDataBinding.etUserBankCard.getText().toString(), viewDataBinding.etUserName.getText().toString(),
                        viewDataBinding.etUserPhone.getText().toString(), viewDataBinding.etValidateCode.getText().toString());
                mTemBankCard.setIdCard(checkRequestParam.getId_card());
                mTemBankCard.setBankNumber(checkRequestParam.getBank_code());
                mTemBankCard.setName(checkRequestParam.getName());
                mTemBankCard.setPhone(checkRequestParam.getPhone());

                getPresenter().checkBank(new RequestParam(checkRequestParam));

                break;
        }
    }

    @Override
    public void showDialog() {
        mEastCloudProgressDialog.show();
    }

    @Override
    public void hideDialog() {
        mEastCloudProgressDialog.hide();
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void codeSucceed(Message message) {
        mMessageId = message.getMsgId();
    }

    @Override
    public void checkSucceed(BankCardInfo bankCardInfo) {
        if (bankCardInfo.isFirstCard()) {
            Intent intent = new Intent(this, ActivitySettingPayPwd.class);
            intent.putExtra(Constant.VALUE, mTemBankCard);
            startActivity(intent);

        } else {
            BankCardInfo.CommitRequestParam commitRequestParam = new BankCardInfo.CommitRequestParam(viewDataBinding.etUerIDCard.getText().toString(),
                    viewDataBinding.etUserBankCard.getText().toString(), viewDataBinding.etUserName.getText().toString(),
                    viewDataBinding.etUserPhone.getText().toString(), AcacheUtil.getInstance().getUser().getPayPwd());
            getPresenter().commitBank(new RequestParam(commitRequestParam));
        }
    }

    @Override
    public void commitSucceed(EastCloudResponseBody eastCloudResponseBody) {
        if (Integer.valueOf(eastCloudResponseBody.getCode()) > 0) {
            Toast.makeText(this, "绑定成功!", Toast.LENGTH_SHORT).show();
        }
    }
}
