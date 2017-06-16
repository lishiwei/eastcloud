package com.orientalfinance.eastcloud.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import java.io.Serializable;

/**
 * 类描述：TextView工具类
 * Created by lzy on 2017/6/16.
 * email:lizy@oriental-finance.com
 */

public class TextViewUtils {

    /**
     * 方法描述：修改TextView部分字体的颜色
     *
     * @param color 颜色值为int类型
     * @param start 要修改TextView的内容起始位置
     * @param end   要修改TextView的内容结束位置
     */
    public static void modifySomeFontColor(TextView textView, int color, int start, int end) {
        String content = textView.getText().toString();
        if (end > content.length()) {
            throw new StringIndexOutOfBoundsException("String index out of range:" + content.length());
        }
        ForegroundColorSpan modifySpan = new ForegroundColorSpan(color);
        SpannableStringBuilder builder = new SpannableStringBuilder(content);
        builder.setSpan(modifySpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(builder);
    }

    /**
     * 方法描述：修改TextView部分字体的颜色
     *
     * @param color  颜色值为int类型
     * @param string 需要修改的字符串
     */
    public static void modifySomeFontColorByString(TextView textView, int color, String string) {
        String content = textView.getText().toString();
        if (!content.contains(string)) {
            throw new StringNotFoundException("字符串====>" + content + "不包含字符串：" + string);
        }
        int start = content.indexOf(string);
        int end = string.length() + start;
        SpannableStringBuilder builder = new SpannableStringBuilder(content);
        ForegroundColorSpan modifySpan = new ForegroundColorSpan(color);
        builder.setSpan(modifySpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(builder);
    }

    /**
     * 方法描述：修改TextView部分字体的背景颜色
     *
     * @param color 颜色值为int类型
     * @param start 要修改TextView的内容起始位置
     * @param end   要修改TextView的内容结束位置
     */

    public static void modifySomeFontBackground(TextView textView, int color, int start, int end) {
        String content = textView.getText().toString();
        if (end > content.length()) {
            throw new StringIndexOutOfBoundsException("String index out of range:" + content.length());
        }
        SpannableStringBuilder builder = new SpannableStringBuilder(content);
        BackgroundColorSpan modifySpan = new BackgroundColorSpan(color);
        builder.setSpan(modifySpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(builder);
    }

    /**
     * 方法描述：修改TextView部分字体的背景颜色
     *
     * @param color  颜色值为int类型
     * @param string 需要修改的字符串
     */
    public static void modifySomeFontBackgroundByString(TextView textView, int color, String string) {
        String content = textView.getText().toString();
        if (!content.contains(string)) {
            throw new StringNotFoundException("字符串====>" + content + "不包含字符串：" + string);
        }
        int start = content.indexOf(string);
        int end = string.length() + start;
        BackgroundColorSpan modifySpan = new BackgroundColorSpan(color);
        SpannableStringBuilder builder = new SpannableStringBuilder(content);
        builder.setSpan(modifySpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(builder);
    }

    public static class StringNotFoundException extends RuntimeException implements Serializable {
        public StringNotFoundException(String msg) {
            super(msg);
        }
    }
}
