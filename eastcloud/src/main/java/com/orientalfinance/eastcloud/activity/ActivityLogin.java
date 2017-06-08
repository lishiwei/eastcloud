package com.orientalfinance.eastcloud.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.core.CommonRequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.ActivityLoginView;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityLoginPresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.SocializeUtils;

import java.util.Map;

public class ActivityLogin extends MvpActivity<ActivityLoginView, ActivityLoginPresenter> implements ActivityLoginView, View.OnClickListener {
    private static final java.lang.String TAG = ActivityLogin.class.getSimpleName();
    boolean isQQauthed;
    boolean isWechatauthed;
    boolean isWeiboAuthed;
    Dialog mDialog;
    CommonRequestParam mCommonRequestParam;
    private UMAuthListener mUMAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调

            SocializeUtils.safeShowDialog(mDialog);
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            SocializeUtils.safeCloseDialog(mDialog);
            Toast.makeText(ActivityLogin.this, "成功!", Toast.LENGTH_SHORT).show();

            if (data == null) {
                return;
            }
            for (String in : data.keySet()) {
                //map.keySet()返回的是所有key的值
                String str = data.get(in);//得到每个key多对用value的值
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            SocializeUtils.safeCloseDialog(mDialog);
            Toast.makeText(ActivityLogin.this, "c出错啦!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            SocializeUtils.safeCloseDialog(mDialog);
            Toast.makeText(ActivityLogin.this, "取消啦!", Toast.LENGTH_SHORT).show();
            Toast.makeText(ActivityLogin.this, "取消啦!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isQQauthed = UMShareAPI.get(this).isAuthorize(this, SHARE_MEDIA.QQ);
        mDialog = new ProgressDialog(this);
        isWechatauthed = UMShareAPI.get(this).isAuthorize(this, SHARE_MEDIA.WEIXIN);
        isWeiboAuthed = UMShareAPI.get(this).isAuthorize(this, SHARE_MEDIA.SINA);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.tv_ForgetPassWord).setOnClickListener(this);
        findViewById(R.id.tv_register).setOnClickListener(this);
        findViewById(R.id.iv_QQ).setOnClickListener(this);
        findViewById(R.id.iv_Weibo).setOnClickListener(this);
        findViewById(R.id.iv_WeChat).setOnClickListener(this);
        mCommonRequestParam = new CommonRequestParam("", "");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        UMShareAPI.get(this).onSaveInstanceState(outState);
    }

    @NonNull
    @Override
    public ActivityLoginPresenter createPresenter() {
        return new ActivityLoginPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_QQ:
                if (isQQauthed) {

                    UMShareAPI.get(ActivityLogin.this).deleteOauth(ActivityLogin.this, SHARE_MEDIA.QQ, mUMAuthListener);
                } else {


                    UMShareAPI.get(ActivityLogin.this).doOauthVerify(ActivityLogin.this, SHARE_MEDIA.QQ, mUMAuthListener);

                }
                break;
            case R.id.iv_WeChat:
                if (isWechatauthed) {
                    UMShareAPI.get(ActivityLogin.this).deleteOauth(ActivityLogin.this, SHARE_MEDIA.WEIXIN, mUMAuthListener);
                } else {
                    UMShareAPI.get(ActivityLogin.this).doOauthVerify(ActivityLogin.this, SHARE_MEDIA.WEIXIN, mUMAuthListener);

                }
                break;
            case R.id.iv_Weibo:
                if (isWeiboAuthed) {
                    UMShareAPI.get(ActivityLogin.this).deleteOauth(ActivityLogin.this, SHARE_MEDIA.SINA, mUMAuthListener);
                } else {
                    UMShareAPI.get(ActivityLogin.this).doOauthVerify(ActivityLogin.this, SHARE_MEDIA.SINA, mUMAuthListener);

                }
                break;
            case R.id.button:

                getPresenter().login(mCommonRequestParam);
                break;
            case R.id.tv_register:
                Intent intent = new Intent(ActivityLogin.this, ActivityRegister.class);
                startActivity(intent);
                break;
            case R.id.tv_ForgetPassWord:
                Intent intent1 = new Intent(ActivityLogin.this, ActivityForgetPassWord.class);
                startActivity(intent1);
                LogUtils.d(TAG, "onClick: ");
                break;
        }
    }

    @Override
    public void showLogin() {

    }

    @Override
    public void showError() {
        Toast.makeText(this, "您的账号密码不正确", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSucceed(User user) {

    }
}
