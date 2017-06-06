package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.utils.LogUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class ActivityLogin extends AppCompatActivity {
    private static final java.lang.String TAG = ActivityLogin.class.getSimpleName();
    boolean isQQauthed ;
    boolean isWechatauthed ;
    boolean isWeiboAuthed ;

    private UMAuthListener mUMAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
            Log.d(TAG, "onStart: ");
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            Toast.makeText(ActivityLogin.this, "成功!", Toast.LENGTH_SHORT).show();

            for (String in : data.keySet()) {
                //map.keySet()返回的是所有key的值
                String str = data.get(in);//得到每个key多对用value的值
                LogUtils.d(TAG, "key     " + in + "value:   " + str);
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            LogUtils.d(TAG, action + "aaaaa" + t.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            LogUtils.d(TAG, action + "bbbbbbb" + action);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isQQauthed = UMShareAPI.get(this).isAuthorize(this, SHARE_MEDIA.QQ);

        isWechatauthed = UMShareAPI.get(this).isAuthorize(this, SHARE_MEDIA.WEIXIN);
        isWeiboAuthed = UMShareAPI.get(this).isAuthorize(this, SHARE_MEDIA.SINA);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.tv_ForgetPassWord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityForgetPassWord.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.tv_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityRegister.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.iv_QQ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isQQauthed) {
                    Log.d(TAG, "onClick: true ");
                    UMShareAPI.get(ActivityLogin.this).deleteOauth(ActivityLogin.this, SHARE_MEDIA.QQ, mUMAuthListener);
                } else {
                    Log.d(TAG, "onClick: false ");

                    UMShareAPI.get(ActivityLogin.this).doOauthVerify(ActivityLogin.this, SHARE_MEDIA.QQ, mUMAuthListener);

                }
            }
        });
        findViewById(R.id.iv_Weibo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWeiboAuthed) {
                    UMShareAPI.get(ActivityLogin.this).deleteOauth(ActivityLogin.this, SHARE_MEDIA.SINA, mUMAuthListener);
                } else {
                    UMShareAPI.get(ActivityLogin.this).doOauthVerify(ActivityLogin.this, SHARE_MEDIA.SINA, mUMAuthListener);

                }
            }
        });
        findViewById(R.id.iv_WeChat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWechatauthed) {
                    UMShareAPI.get(ActivityLogin.this).deleteOauth(ActivityLogin.this, SHARE_MEDIA.WEIXIN, mUMAuthListener);
                } else {
                    UMShareAPI.get(ActivityLogin.this).doOauthVerify(ActivityLogin.this, SHARE_MEDIA.WEIXIN, mUMAuthListener);

                }
            }
        });

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
}
