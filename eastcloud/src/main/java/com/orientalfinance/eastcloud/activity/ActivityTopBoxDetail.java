package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityTopBoxBinding;

public class ActivityTopBoxDetail extends AppCompatActivity {
ActivityTopBoxBinding mActivityTopBoxBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityTopBoxBinding = DataBindingUtil.setContentView(this,R.layout.activity_top_box);
        Toolbar toolbar = mActivityTopBoxBinding.toolbar;

        setSupportActionBar(mActivityTopBoxBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
//        mActivityTopBoxBinding.llBoxLocation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ActivityTopBoxDetail.this,ActivityConnectTV.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

}
