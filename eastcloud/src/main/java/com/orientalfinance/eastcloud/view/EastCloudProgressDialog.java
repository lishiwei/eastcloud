package com.orientalfinance.eastcloud.view;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by 29435 on 2017/6/13.
 */

public class EastCloudProgressDialog {
    ProgressDialog mDialog;
//    Context mContext;

    public EastCloudProgressDialog(Context context) {
//        mContext = context;
        mDialog = new ProgressDialog(context);
        mDialog.setTitle("加载中...");
    }

    public void setTitle(String title) {
        mDialog.setTitle(title);
    }

    public void show() {
        mDialog.show();
    }

    public void hide() {
        mDialog.hide();
    }

    public void dismiss() {
        mDialog.dismiss();
    }
}
