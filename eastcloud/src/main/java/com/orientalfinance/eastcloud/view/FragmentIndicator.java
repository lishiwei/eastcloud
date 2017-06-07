package com.orientalfinance.eastcloud.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lishiwei
 */
public class FragmentIndicator extends LinearLayout implements OnClickListener {

    private int mDefaultIndicator = 0;
    private static int mCurIndicator;
    private static int mCurIndicator1;
    private static View[] mIndicators;
    private OnIndicateListener mOnIndicateListener;
    private List<String> indicatorTagIcons = new ArrayList<>();
    private List<String> indicatorTagTexts = new ArrayList<>();
    private List<Integer> indicatorNormalIcons = new ArrayList<>();
    private List<Integer> indicatorClickedIcons = new ArrayList<>();
    private List<Integer> indicatorTexts = new ArrayList<>();
    private int indicaterItemSize;


    private static final int COLOR_UNSELECT = Color.argb(100, 0x88, 0x88, 0x88);
    private static final int COLOR_SELECT = Color.parseColor("#3598dc");

    private static final int COLOR_CLICKED = Color.parseColor("#f7f7f7");
    private static final int COLOR_UNCLICKED = Color.parseColor("#e4e4e4");

    private FragmentIndicator(Context context) {
        super(context);
    }

    public FragmentIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        mCurIndicator = mDefaultIndicator;
        setOrientation(LinearLayout.HORIZONTAL);

        init();
    }

    public void removeIndicators() {
        for (int i = 0; i < mIndicators.length; i++) {
            mIndicators[i] = null;
        }
    }

    private View createIndicator(int iconResID, int stringResID, int stringColor,
                                 String iconTag, String textTag) {
        LinearLayout view = new LinearLayout(getContext());
        view.setOrientation(LinearLayout.VERTICAL);
        view.setLayoutParams(new LayoutParams(

                0, DensityUtil.dp2px(54), 1));
        view.setGravity(Gravity.BOTTOM | Gravity.CENTER);
        ImageView iconView = new ImageView(getContext());
        iconView.setTag(iconTag);

        iconView.setLayoutParams(new LayoutParams(
                DensityUtil.dp2px(22), DensityUtil.dp2px(22), 1));
        iconView.setImageResource(iconResID);


        TextView textView = new TextView(getContext());
        textView.setTag(textTag);
        textView.setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        textView.setTextColor(stringColor);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        textView.setPadding(0, 0, 0, DensityUtil.dp2px(4));
        textView.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        textView.setText(stringResID);
        textView.setVisibility(View.VISIBLE);

        view.addView(iconView);
//        if (textTag.equals("text_tag_2")) {
//            iconView.setLayoutParams(new LayoutParams(
//                    DensityUtil.dp2px(30), DensityUtil.dp2px(30), 1));
//        } else {
        view.addView(textView);
//        }
        return view;

    }

    private void init() {
        indicatorClickedIcons.add(R.drawable.tab_home_selected);
        indicatorClickedIcons.add(R.drawable.tab_channel_selected);
        indicatorClickedIcons.add(R.drawable.tab_remote_selected);
        indicatorClickedIcons.add(R.drawable.tab_application_selected);
        indicatorClickedIcons.add(R.drawable.tab_my_selected);


        indicatorNormalIcons.add(R.drawable.tab_home_normal);
        indicatorNormalIcons.add(R.drawable.tab_channel_normal);
        indicatorNormalIcons.add(R.drawable.tab_remote_normal);
        indicatorNormalIcons.add(R.drawable.tab_application_normal);
        indicatorNormalIcons.add(R.drawable.tab_my_normal);

        indicatorTexts.add(R.string.title_recommend);
        indicatorTexts.add(R.string.title_channel);
        indicatorTexts.add(R.string.title_remote_control);
        indicatorTexts.add(R.string.title_application);
        indicatorTexts.add(R.string.title_myself);

        for (int i = 0; i < indicatorTexts.size(); i++) {
            indicatorTagIcons.add("icon_tag_" + i);
        }
        for (int i = 0; i < indicatorTexts.size(); i++) {
            indicatorTagTexts.add("text_tag_" + i);
        }

        mIndicators = new View[indicatorTexts.size()];
        for (int i = 0; i < indicatorTexts.size(); i++) {
            if (i == 0) {
                mIndicators[i] = createIndicator(indicatorClickedIcons.get(i), indicatorTexts.get(i),
                        COLOR_SELECT, indicatorTagIcons.get(i), indicatorTagTexts.get(i));
//                mIndicators[i].setBackgroundColor(COLOR_CLICKED);
            } else {
                mIndicators[i] = createIndicator(indicatorNormalIcons.get(i), indicatorTexts.get(i),
                        COLOR_UNSELECT, indicatorTagIcons.get(i), indicatorTagTexts.get(i));
                //mIndicators[i].setBackgroundColor(COLOR_UNCLICKED);

            }

            mIndicators[i].setTag(Integer.valueOf(i));
            mIndicators[i].setOnClickListener(this);
            addView(mIndicators[i]);
        }
//
    }

    public void setIndicator(int which) {

        // mIndicators[mCurIndicator].setBackgroundColor(COLOR_UNCLICKED);
        ImageView prevIcon;
        TextView prevText;
        for (int i = 0; i < mIndicators.length; i++) {

            if (i == mCurIndicator) {
                prevIcon = (ImageView) mIndicators[mCurIndicator].findViewWithTag(indicatorTagIcons.get(mCurIndicator));
                prevIcon.setImageResource(indicatorNormalIcons.get(i));
                prevText = (TextView) mIndicators[mCurIndicator].findViewWithTag(indicatorTagTexts.get(mCurIndicator));

                if (prevText != null) {
                    prevText.setTextColor(COLOR_UNSELECT);
                }
            }
        }
        //mIndicators[which].setBackgroundColor(COLOR_CLICKED);
        ImageView currIcon;
        TextView currText;
        for (int j = 0; j < mIndicators.length; j++) {

            if (j == which) {

                currIcon = (ImageView) mIndicators[j].findViewWithTag(indicatorTagIcons.get(j));
                currIcon.setImageResource(indicatorClickedIcons.get(j));
                currText = (TextView) mIndicators[j].findViewWithTag(indicatorTagTexts.get(j));
                if (currText != null) {
                    currText.setTextColor(COLOR_SELECT);
                }

                break;
            }
        }

        mCurIndicator = which;


    }

    public interface OnIndicateListener {

        void onIndicate(View v, int which);

    }

    public void setOnIndicateListener(OnIndicateListener listener) {
        mOnIndicateListener = listener;

    }

    public OnIndicateListener getmOnIndicateListener() {
        return mOnIndicateListener;
    }

    @Override
    public void onClick(View v) {
        if (mOnIndicateListener != null) {
            int tag = (Integer) v.getTag();
            for (int i = 0; i < mIndicators.length; i++) {
                if (tag == i && mCurIndicator != i) {
                    Log.d("aaaaaaa", "onClick: " + v.toString() + i);
                    mOnIndicateListener.onIndicate(v, i);

                    setIndicator(i);
                    break;
                }
            }
        }
    }
}
