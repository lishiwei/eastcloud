package com.orientalfinance.eastcloud.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.view.LoadingButton;
import com.orientalfinance.eastcloud.view.MainGuideDialog;
import com.orientalfinance.eastcloud.view.passwordview.GridPasswordView;
import com.orientalfinance.eastcloud.view.passwordview.PasswordType;

/**
 * Created by lzy on 2017/6/16.
 * email:lizy@oriental-finance.com
 */

public class ActivityConfirmPayPwd extends AppCompatActivity implements GridPasswordView.OnPasswordChangedListener
        , LoadingButton.OnLoadingListener {

    private GridPasswordView gridPasswordView;
    private LoadingButton loadingButton;
    private ImageView imageViewBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_confirm_pay_pwd);
        initViews();
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

    }

    @Override
    public void onTextChanged(String psw) {

    }

    @Override
    public void onInputFinish(String psw) {

    }
}
