package com.orientalfinance.eastcloud.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orientalfinance.R;

/**
 * Created by 29435 on 2017/6/27.
 */

public class ItemIndicator extends LinearLayout {
    LinearLayout mLinearLayout;
    ImageView mImageView;
    RotateAnimation mRotateAnimation;
    TextView mTextView;

    public ItemIndicator(Context context) {
        super(context);
        init(context);
    }

    public ItemIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ItemIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.itemindicator, this, true);
        mLinearLayout = (LinearLayout) findViewById(R.id.ll_Indicator);
        mImageView = (ImageView) findViewById(R.id.iv_Indicator);
        mTextView = (TextView) findViewById(R.id.tv_indicator);
        mRotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateAnimation.setDuration(1000);
        mRotateAnimation.setRepeatMode(Animation.RESTART);
        mRotateAnimation.setRepeatCount(Animation.INFINITE);
        mLinearLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView.startAnimation(mRotateAnimation);
                if (getOnIndicatorClickListener() != null) {
                    getOnIndicatorClickListener().onClick(v);
                }
            }
        });
    }

    public void setIndicatorText(String string) {
        mTextView.setText(string);
    }

    public void stopRefresh() {
        mRotateAnimation.cancel();
    }

    OnIndicatorClickListener mOnIndicatorClickListener;

    public OnIndicatorClickListener getOnIndicatorClickListener() {
        return mOnIndicatorClickListener;
    }

    public void setOnIndicatorClickListener(OnIndicatorClickListener onIndicatorClickListener) {
        mOnIndicatorClickListener = onIndicatorClickListener;
    }

    public interface OnIndicatorClickListener {
        public void onClick(View v);
    }
}
