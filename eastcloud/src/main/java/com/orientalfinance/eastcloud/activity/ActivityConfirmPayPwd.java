package com.orientalfinance.eastcloud.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.javabean.BankCardInfo;
import com.orientalfinance.eastcloud.mvp.View.ConfirmPayPwdView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ConfirmPayPwdPresenter;
import com.orientalfinance.eastcloud.view.LoadingButton;
import com.orientalfinance.eastcloud.view.MainGuideDialog;
import com.orientalfinance.eastcloud.view.passwordview.GridPasswordView;
import com.orientalfinance.eastcloud.view.passwordview.PasswordType;

/**
 * Created by lzy on 2017/6/16.
 * email:lizy@oriental-finance.com
 */

public class ActivityConfirmPayPwd extends BaseMVPActivity<ConfirmPayPwdView, ConfirmPayPwdPresenter> implements ConfirmPayPwdView, GridPasswordView.OnPasswordChangedListener
        , LoadingButton.OnLoadingListener {

    private GridPasswordView gridPasswordView;
    private LoadingButton loadingButton;
    private ImageView imageViewBack;
    BankCardInfo mTemBankCardInfo;
    String mFirstPayPwd;
    String mSecondPayPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_confirm_pay_pwd);
        initViews();
        mTemBankCardInfo = getIntent().getParcelableExtra(Constant.VALUE);
        mFirstPayPwd = getIntent().getStringExtra(Constant.PAYPASSOWRD);
    }

    private void initViews() {
        initToolbar();
        gridPasswordView = (GridPasswordView) findViewById(R.id.grid_password_pay);
        gridPasswordView.setPasswordType(PasswordType.NUMBER);
        gridPasswordView.setPasswordVisibility(false);
        gridPasswordView.setOnPasswordChangedListener(this);

        loadingButton = (LoadingButton) findViewById(R.id.btn_add_confirm);
        loadingButton.setOnLoadingListener(this);
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbarTitle.setText("确认支付密码");

        imageViewBack = (ImageView) findViewById(R.id.toolbar_icon_back);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTipDialog();
            }
        });
    }


    public void showTipDialog() {
        new MainGuideDialog.Builder(this)
                .setTitle("确定放弃本次操作吗？")
                .setMessage("您确定退出后银行卡添加不成功")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        loadingButton.setCompleted();
                        finish();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();
    }

    @Override
    public void onLoadingClick(LoadingButton view) {
        if (!mSecondPayPwd.equals(mFirstPayPwd)) {
            Toast.makeText(this, "两次密码不一致！", Toast.LENGTH_SHORT).show();
            return;
        }
        BankCardInfo.CommitRequestParam commitRequestParam = new BankCardInfo.CommitRequestParam(mTemBankCardInfo.getIdCard(), mTemBankCardInfo.getBankNumber(),
                mTemBankCardInfo.getName(), mTemBankCardInfo.getPhone(), mSecondPayPwd);
        getPresenter().commitBank(new RequestParam(commitRequestParam));
    }

    @Override
    public void onTextChanged(String psw) {

    }

    @Override
    public void onInputFinish(String psw) {
        mSecondPayPwd = psw;
    }

    @Override
    public void showDialog() {
        mEastCloudDialog.show();
    }

    @Override
    public void hideDialog() {
        mEastCloudDialog.hide();
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void commitSucceed(EastCloudResponseBody eastCloudResponseBody) {
        Toast.makeText(this, "提交成功!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, ActivityMyBankCard.class));
    }

    @NonNull
    @Override
    public ConfirmPayPwdPresenter createPresenter() {
        return new ConfirmPayPwdPresenter();
    }
}
