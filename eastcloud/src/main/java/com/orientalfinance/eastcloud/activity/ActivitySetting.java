package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Toast;

import com.luck.picture.lib.model.FunctionOptions;
import com.luck.picture.lib.model.PictureConfig;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivitySettingBinding;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.SettingView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.SettingPresenter;
import com.orientalfinance.eastcloud.utils.ClickHandler;
import com.orientalfinance.eastcloud.utils.ImageLoaders;
import com.orientalfinance.eastcloud.view.BottomPopWindow;
import com.yalantis.ucrop.entity.LocalMedia;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class ActivitySetting extends BaseMVPActivity<SettingView, SettingPresenter> implements SettingView {
    BottomPopWindow mPopupWindow;
    private static final java.lang.String TAG = ActivitySetting.class.getSimpleName();
    ActivitySettingBinding mActivitySettingBinding;
    ClickHandler mClickHandler = new ClickHandler() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_NickName:
                    Intent intent = new Intent(ActivitySetting.this, ActivitySettingModify.class);
                    intent.putExtra(Constant.TITLE, "修改昵称");
                    intent.putExtra(Constant.REQUEST_CODE, Constant.NICKNAME);
                    startActivityForResult(intent, Constant.NICKNAME);
                    break;
                case R.id.ll_RealName:
                    Intent intent1 = new Intent(ActivitySetting.this, ActivitySettingModify.class);
                    intent1.putExtra(Constant.TITLE, "修改真实姓名");
                    intent1.putExtra(Constant.REQUEST_CODE, Constant.REALNAME);
                    startActivityForResult(intent1, Constant.REALNAME
                    );
                    break;
                case R.id.ll_PhoneNumber:
                    Intent intent2 = new Intent(ActivitySetting.this, ActivitySettingModify.class);
                    intent2.putExtra(Constant.TITLE, "修改手机号码");
                    intent2.putExtra(Constant.REQUEST_CODE, Constant.PHONENUMBER);
                    startActivityForResult(intent2, Constant.PHONENUMBER);
                    break;
                case R.id.tv_ClearCache:
                    showDialog();
                    Flowable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(@io.reactivex.annotations.NonNull Long aLong) throws Exception {
                            hideDialog();
                            Toast.makeText(ActivitySetting.this, "清楚缓存成功!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case R.id.btn_Quit:
                    getPresenter().quitLogin(new RequestParam());
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {

            switch (requestCode) {
                case Constant.NICKNAME:

                    mActivitySettingBinding.tvNickName.setText(data.getStringExtra(Constant.VALUE));
                    break;
                case Constant.REALNAME:
                    mActivitySettingBinding.tvRealName.setText(data.getStringExtra(Constant.VALUE));
                    break;
                case Constant.PHONENUMBER:
                    mActivitySettingBinding.tvPhoneNumber.setText(data.getStringExtra(Constant.VALUE));
                    break;
            }
        }
    }

    private DatePicker mDatePicker;
    private int year;
    private int month;
    private int day;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mDatePicker = new DatePicker(this);


// 获取日历对象
        calendar = Calendar.getInstance();
// 获取当前对应的年、月、日的信息
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        mDatePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mActivitySettingBinding.tvBirthDay.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
                Toast.makeText(ActivitySetting.this, "year + \"-\" + monthOfYear + \"-\" + dayOfMonth", Toast.LENGTH_SHORT).show();
            }
        });

        mPopupWindow = new BottomPopWindow(this, mDatePicker);
        mPopupWindow.setOnDismissListener(new BottomPopWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        mActivitySettingBinding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
        mActivitySettingBinding.setUrl(R.drawable.myself + "");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActivitySettingBinding.setHandler(mClickHandler);
        final FunctionOptions functionOptions = new FunctionOptions.Builder().setEnableCrop(true).setMaxSelectNum(1).create();

        mActivitySettingBinding.ivUserAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureConfig.getInstance().init(functionOptions).openPhoto(ActivitySetting.this, resultCallback);
            }
        });
        mActivitySettingBinding.tvBirthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.show();
            }
        });
        mActivitySettingBinding.tbMessage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                User.ModifyRequestParam modifyRequestParam = new User.ModifyRequestParam();
                if (isChecked) {
                    modifyRequestParam.setMsg_push("0");
                } else {
                    modifyRequestParam.setMsg_push("1");

                }
                getPresenter().modifyUserInfo(new RequestParam(modifyRequestParam));
            }
        });

    }

    @NonNull
    @Override
    public SettingPresenter createPresenter() {
        return new SettingPresenter();
    }


    private PictureConfig.OnSelectResultCallback resultCallback = new PictureConfig.OnSelectResultCallback() {
        @Override
        public void onSelectSuccess(List<LocalMedia> resultList) {

            // 多选回调
            String path;
            LocalMedia media = resultList.get(0);
            if (media.isCut() && !media.isCompressed()) {
                // 裁剪过
                path = media.getCutPath();
            } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                path = media.getCompressPath();
            } else {
                // 原图地址
                path = media.getPath();
            }
            ImageLoaders.displayCircleImage(mActivitySettingBinding.ivUserAvatar, path);

        }

        @Override
        public void onSelectSuccess(LocalMedia media) {

        }
    };

    @Override
    public void showSucceed() {

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
}
