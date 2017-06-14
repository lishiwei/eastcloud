package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityTopBoxBinding;
import com.orientalfinance.eastcloud.utils.StringUtil;

import java.util.ArrayList;

import cn.qqtheme.framework.picker.DoublePicker;

public class ActivityTopBoxDetail extends AppCompatActivity implements View.OnClickListener {
    ActivityTopBoxBinding mActivityTopBoxBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityTopBoxBinding = DataBindingUtil.setContentView(this, R.layout.activity_top_box);
        Toolbar toolbar = mActivityTopBoxBinding.toolbar;

        setSupportActionBar(mActivityTopBoxBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        initViews();

    }

    private void initViews() {
        mActivityTopBoxBinding.llBoxLocation.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    public void onDoublePicker(View view) {
        final ArrayList<String> firstData = new ArrayList<>();
        firstData.add("我        家");
        firstData.add("父        母");
        firstData.add("朋        友");
        firstData.add("朋        友");
        firstData.add("其        他");
        final ArrayList<String> secondData = new ArrayList<>();
        secondData.add("客       厅");
        secondData.add("主       卧");
        secondData.add("次       卧 ");
        secondData.add("书       房");
        final DoublePicker picker = new DoublePicker(this, firstData, secondData);
        picker.setDividerVisible(true);
        picker.setCycleDisable(true);
        picker.setOffset(4);
        picker.setSelectedIndex(2, 1);
        picker.setFirstLabel("", null);
        picker.setSecondLabel("     家     ", "     厅");
        picker.setOnPickListener(new DoublePicker.OnPickListener() {
            @Override
            public void onPicked(int selectedFirstIndex, int selectedSecondIndex) {
                String s = firstData.get(selectedFirstIndex) + "-" + secondData.get(selectedSecondIndex);
                mActivityTopBoxBinding.tvLocation.setText(StringUtil.replaceEmpty(s));
                Toast.makeText(ActivityTopBoxDetail.this,
                        firstData.get(selectedFirstIndex) + s + secondData.get(selectedSecondIndex),
                        Toast.LENGTH_SHORT).show();
            }
        });
        picker.show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_tv:

                break;
            case R.id.ll_BoxLocation:
                onDoublePicker(mActivityTopBoxBinding.getRoot());
                break;
        }
    }
}
