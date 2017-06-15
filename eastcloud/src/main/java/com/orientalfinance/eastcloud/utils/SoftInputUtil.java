package com.orientalfinance.eastcloud.utils;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Created by lzy on 2017/6/15.
 * email:lizy@oriental-finance.com
 */

public class SoftInputUtil {
    /**
     * 解决在页面底部置输入框，输入法弹出遮挡部分输入框的问题
     *
     * @param root     页面根元素
     * @param editText 被软键盘遮挡的输入框
     */
    public static void controlKeyboardLayout(final View root,
                                             final View editLayout) {
        // TODO Auto-generated method stub
        root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                // TODO Auto-generated method stub
                Rect rect = new Rect();
                //获取root在窗体的可视区域
                root.getWindowVisibleDisplayFrame(rect);
                //获取root在窗体的不可视区域高度(被其他View遮挡的区域高度)
                int rootInVisibleHeigh = root.getRootView().getHeight() - rect.bottom;
                //若不可视区域高度大于100，则键盘显示
                if (rootInVisibleHeigh > 400) {
                    Log.v("hjb", "不可视区域高度大于100，则键盘显示");
                    int[] location = new int[2];
                    //获取editLayout在窗体的坐标
                    editLayout.getLocationInWindow(location);
                    //计算root滚动高度，使editLayout在可见区域
                    int srollHeight = (location[1] + editLayout.getHeight()) - rect.bottom;
                    root.scrollTo(0, srollHeight);
                } else {
                    //键盘隐藏
                    Log.v("hjb", "不可视区域高度小于100，则键盘隐藏");
                    root.scrollTo(0, 0);
                }
            }
        });
    }
}
