package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.mvp.View.ClearEditText;

public class ActivitySettingModify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_modify);
        final Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra(Constant.TITLE);
            ((TextView) findViewById(R.id.tv_toolbar)).setText(title);
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((ClearEditText) findViewById(R.id.clearEditText)).getText()!=null)
                {
                    Intent intent1 = new Intent();
                    intent1.putExtra(Constant.VALUE, ((ClearEditText) findViewById(R.id.clearEditText)).getText().toString());
                    setResult(getIntent().getIntExtra(Constant.REQUEST_CODE,Constant.REALNAME),intent1);
                    finish();
                }
                else {
                    Toast.makeText(ActivitySettingModify.this, "您未填写任何内容！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
