package com.orientalfinance.eastcloud.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.orientalfinance.R;

/**
 * Created by 29435 on 2017/6/23.
 */

public class BottomPopWindow {
    PopupWindow mPopupWindow;
    OnDismissListener mOnDismissListener;
    Context mContext;

    public BottomPopWindow(Context context, View view) {

        mContext = context;
        initPopWindow(view);
    }

    private void initPopWindow(View view) {


        mPopupWindow = new PopupWindow(LayoutInflater.from(mContext).inflate(R.layout.popwindow, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        //点击外部消失
        mPopupWindow.setOutsideTouchable(true);
        //设置可以点击
        mPopupWindow.setTouchable(true);
        //进入退出的动画
        mPopupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        ((ViewGroup) mPopupWindow.getContentView()).addView(view);

        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroundAlpha(1.0f);
                if (mOnDismissListener != null) {
                    mOnDismissListener.onDismiss();
                }
            }
        });
    }

    public void show() {
        setBackgroundAlpha(0.5f);//设置屏幕透明度

        mPopupWindow.showAtLocation(mPopupWindow.getContentView(), Gravity.BOTTOM, 0, 0);

    }

    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((AppCompatActivity) mContext).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        ((AppCompatActivity) mContext).getWindow().setAttributes(lp);
    }

    public OnDismissListener getOnDismissListener() {
        return mOnDismissListener;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        mOnDismissListener = onDismissListener;
    }

    /**
     * Listener that is called when this popup window is dismissed.
     */
    public interface OnDismissListener {
        /**
         * Called when this popup window is dismissed.
         */
        public void onDismiss();
    }
}
