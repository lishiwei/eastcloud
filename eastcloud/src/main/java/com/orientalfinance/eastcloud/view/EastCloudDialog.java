package com.orientalfinance.eastcloud.view;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by 29435 on 2017/6/13.
 */

public class EastCloudDialog {
    Dialog mDialog;
//    Context mContext;

    public EastCloudDialog(Context context) {
//        mContext = context;
        mDialog = new Dialog(context);
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
}
