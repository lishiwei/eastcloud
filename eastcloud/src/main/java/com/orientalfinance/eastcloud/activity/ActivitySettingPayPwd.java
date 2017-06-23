package com.orientalfinance.eastcloud.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.javabean.BankCardInfo;
import com.orientalfinance.eastcloud.view.LoadingButton;
import com.orientalfinance.eastcloud.view.MainGuideDialog;
import com.orientalfinance.eastcloud.view.passwordview.GridPasswordView;
import com.orientalfinance.eastcloud.view.passwordview.PasswordType;

/**
 * Created by lzy on 2017/6/16.
 * email:lizy@oriental-finance.com
 */
public class ActivitySettingPayPwd extends AppCompatActivity implements GridPasswordView.OnPasswordChangedListener
        , LoadingButton.OnLoadingListener, View.OnClickListener {

    private GridPasswordView gridPasswordView;
    private LoadingButton loadingButton;
    private String passWord;
    private ImageView imageViewBack;
    BankCardInfo mTemBankCardInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_pay_pwd);

        initViews();
        mTemBankCardInfo = getIntent().getParcelableExtra(Constant.VALUE);

    }

    private void initViews() {
        initToolbar();
        gridPasswordView = (GridPasswordView) findViewById(R.id.grid_password_pay);
        gridPasswordView.setPasswordType(PasswordType.NUMBER);
        gridPasswordView.setPasswordVisibility(false);
        gridPasswordView.setOnPasswordChangedListener(this);

        loadingButton = (LoadingButton) findViewById(R.id.btn_add_next);
        loadingButton.setOnLoadingListener(this);
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbarTitle.setText("设置支付密码");

        imageViewBack = (ImageView) findViewById(R.id.toolbar_icon_back);
        imageViewBack.setOnClickListener(this);
    }


    @Override
    public void onTextChanged(String psw) {

    }

    //获取密码
    @Override
    public void onInputFinish(String psw) {
        passWord = gridPasswordView.getPassWord();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_icon_back:
                showTipDialog();
                break;
        }
    }

    public void showTipDialog() {
        new MainGuideDialog.Builder(this)
                .setTitle("确定放弃本次操作吗？")
                .setMessage("您确定退出后银行卡添加不成功")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
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

    //请求网络
    @Override
    public void onLoadingClick(LoadingButton view) {
        Intent intent = new Intent(this, ActivityConfirmPayPwd.class);
        intent.putExtra(Constant.VALUE,mTemBankCardInfo);
        intent.putExtra(Constant.PAYPASSOWRD,passWord);
        startActivity(intent);
        view.setCompleted();
    }

}
