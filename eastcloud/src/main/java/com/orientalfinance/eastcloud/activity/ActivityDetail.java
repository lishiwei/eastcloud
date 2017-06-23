package com.orientalfinance.eastcloud.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anton46.stepsview.StepsView;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityDetailBinding;
import com.orientalfinance.databinding.ItemDetailBinding;
import com.orientalfinance.eastcloud.adapter.CommentAdapter;
import com.orientalfinance.eastcloud.adapter.DetailPageAdapter;
import com.orientalfinance.eastcloud.adapter.DetailRVAdapter;
import com.orientalfinance.eastcloud.dagger.component.ActivityDetailComponent;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerActivityDetailComponent;
import com.orientalfinance.eastcloud.dagger.modules.ActivityDetailModule;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.core.AcacheUtil;
import com.orientalfinance.eastcloud.module.javabean.Comment;
import com.orientalfinance.eastcloud.module.javabean.CommentBean;
import com.orientalfinance.eastcloud.module.javabean.Detail;
import com.orientalfinance.eastcloud.module.javabean.DetailChannel;
import com.orientalfinance.eastcloud.module.javabean.ReplyBean;
import com.orientalfinance.eastcloud.mvp.View.ActivityDetailViewState;
import com.orientalfinance.eastcloud.mvp.View.DetailView;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityDetailPresenter;
import com.orientalfinance.eastcloud.utils.AndroidBug5497Workaround;
import com.orientalfinance.eastcloud.utils.LogUtils;
import com.orientalfinance.eastcloud.utils.TimeConstants;
import com.orientalfinance.eastcloud.utils.TimeUtils;
import com.orientalfinance.eastcloud.view.ExpandListView;
import com.orientalfinance.eastcloud.view.NoTouchLinearLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class ActivityDetail extends BaseActivity<ActivityDetailComponent, DetailView, ActivityDetailPresenter, ActivityDetailViewState> implements DetailView {
    private static final String TAG = ActivityDetail.class.getSimpleName();
    ActivityDetailBinding mActivityDetailBinding;
    @Inject
    DetailRVAdapter mDetailRVAdapter;
    private ExpandListView mListData;
    private TextView mLytCommentVG;
    private NoTouchLinearLayout mLytEdittextVG;
    private EditText mCommentEdittext;
    private Button mSendBut;
    private List<CommentBean> list;
    private CommentAdapter adapter;
    private int count;                    //记录评论ID
    private String comment = "";        //记录对话框中的内容
    private int position;                //记录回复评论的索引
    private boolean isReply;            //是否是回复，true代表回复
    String programId;
    String channelId;
    DetailPageAdapter mDetailPageAdapter;
    List<View> mViews = new ArrayList<>();
    List<String> strings = new ArrayList<>();
    List<Detail> mDetails;
    @Override
    public boolean hasToolBar() {
        return false;
    }

    @Override
    public String getToolBarTitle() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityDetailBinding = DataBindingUtil.setContentView(this, getLayoutId());
        AndroidBug5497Workaround.assistActivity(this);

        mActivityDetailBinding.toolbar.setTitle("");
        setSupportActionBar(mActivityDetailBinding.toolbar);
        ((TextView) mActivityDetailBinding.toolbar.findViewById(R.id.tv_toolbar)).setText("影视详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Detail.ShowDetailRequestParam detailRequestParam = new Detail.ShowDetailRequestParam(getIntent().getStringExtra(Constant.VALUE));
        getPresenter().getDetail(new RequestParam(detailRequestParam));
        initViews();
//        mActivityDetailBinding.rvDetailComment.setAdapter(mDetailRVAdapter);
        //     mActivityDetailBinding.rvDetailComment.setLayoutManager(new FullyLinearLayoutManager(ActivityDetail.this));
        adapter = new CommentAdapter(this, getCommentData(), R.layout.comment_item_list, handler);
        mListData.setAdapter(adapter);
        Comment.CommentRequestParam commentRequestParam = new Comment.CommentRequestParam("0", "10", "0");
        RequestParam requestParam = new RequestParam(commentRequestParam);
        getPresenter().getDetailComments(requestParam);


        List<String> strings = new ArrayList<>();


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    /**
     * 初始化控件
     */
    private void initViews() {
        View viewById = findViewById(R.id.edit_vg_lyt);
        mListData = (ExpandListView) findViewById(R.id.list_data);
        mLytCommentVG = (TextView) findViewById(R.id.comment_vg_lyt);
        mLytEdittextVG = (NoTouchLinearLayout) findViewById(R.id.edit_vg_lyt);
        mCommentEdittext = (EditText) findViewById(R.id.edit_comment);
        mSendBut = (Button) findViewById(R.id.but_comment_send);

        ClickListener cl = new ClickListener();
        mSendBut.setOnClickListener(cl);


        mDetailPageAdapter = new DetailPageAdapter(mViews);
        mActivityDetailBinding.vpDetail.setAdapter(mDetailPageAdapter);

        mActivityDetailBinding.vpDetail.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LogUtils.d(TAG, "onPageScrolled: position" + position);
                LogUtils.d(TAG, "onPageScrolled:positionOffset " + positionOffset);
                LogUtils.d(TAG, "onPageScrolled:positionOffsetPixels " + positionOffsetPixels);
                if (mActivityDetailBinding.flStepview.getChildAt(0) != null) {
                    mActivityDetailBinding.flStepview.getChildAt(0).scrollTo((int) ((position + positionOffset) * 300), 0);

                }
            }

            @Override
            public void onPageSelected(int position) {
                ((StepsView) mActivityDetailBinding.flStepview.getChildAt(0)).setCompletedPosition(position);
                mActivityDetailBinding.etvProfileContent.setContent(mDetails.get(position).getProfile());
                if (TimeUtils.getTimeSpan(mDetails.get(position).getAirTime(), TimeUtils.getNowString(), TimeConstants.SEC) > 0) {
                    mActivityDetailBinding.btnAction.setText("预约");
                    mActivityDetailBinding.btnAction.setClickable(true);
                    mActivityDetailBinding.btnAction.setEnabled(true);
                } else {
                    mActivityDetailBinding.btnAction.setText("在电视上观看");
                    mActivityDetailBinding.btnAction.setClickable(false);
                    mActivityDetailBinding.btnAction.setEnabled(false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        if (AcacheUtil.getInstance().isUserLogin()) {
            mActivityDetailBinding.commentVgLyt.setText("评论一下");
            mLytCommentVG.setOnClickListener(cl);

        } else {
            mActivityDetailBinding.commentVgLyt.setText("登录才可以评论");
            mActivityDetailBinding.commentVgLyt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ActivityDetail.this, ActivityLogin.class));
                }
            });
        }
//
    }




    @Override
    protected ActivityDetailComponent constructComponent(AppComponent appComponent) {
        return DaggerActivityDetailComponent.builder().appComponent(appComponent).activityDetailModule(new ActivityDetailModule()).build();
    }

    public void showView(Detail detail) {
        Log.d(TAG, "showView: " + detail);
        Log.d(TAG, "showView: " + mDetailRVAdapter.getComments().toString());
        mActivityDetailBinding.setDetail(detail);
        // mDetailRVAdapter.setComments(detail.getComments());

    }


    public void showLoading() {

    }


    public void hideLoading() {

    }


    /**
     * 获取评论列表数据
     */
    private List<CommentBean> getCommentData() {
        list = new ArrayList<>();
        count = 4;
        for (int i = 0; i < 4; i++) {
            CommentBean bean = new CommentBean();
            bean.setId(i);
            bean.setCommentNickname("亮司");
            bean.setCommentTime("13:" + i + "5");
            bean.setCommnetAccount("12345" + i);
            bean.setCommentContent("雪惠和亮司是真爱");
            bean.setReplyList(getReplyData());
            list.add(bean);
        }
        return list;
    }

    /**
     * 获取回复列表数据
     */
    private List<ReplyBean> getReplyData() {
        List<ReplyBean> replyList = new ArrayList<>();
        return replyList;
    }

    /**
     * 显示或隐藏输入法
     */
    private void onFocusChange(boolean hasFocus) {
        final boolean isFocus = hasFocus;
        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                InputMethodManager imm = (InputMethodManager)
                        mCommentEdittext.getContext().getSystemService(INPUT_METHOD_SERVICE);
                if (isFocus) {
                    //显示输入法
                    mCommentEdittext.requestFocus();//获取焦点
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                } else {
                    //隐藏输入法
                    imm.hideSoftInputFromWindow(mCommentEdittext.getWindowToken(), 0);
                    mLytCommentVG.setVisibility(View.VISIBLE);
                    mLytEdittextVG.setVisibility(View.GONE);
                }
            }
        }, 100);
    }

    /**
     * 点击屏幕其他地方收起输入法
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                onFocusChange(false);

            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    /**
     * 隐藏或者显示输入框
     */
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            /**
             *这堆数值是算我的下边输入区域的布局的，
             * 规避点击输入区域也会隐藏输入区域
             */

            v.getLocationInWindow(leftTop);
            int left = leftTop[0] - 50;
            int top = leftTop[1] - 50;
            int bottom = top + v.getHeight() + 300;
            int right = left + v.getWidth() + 120;
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }

    /**
     * 判断对话框中是否输入内容
     */
    private boolean isEditEmply() {
        comment = mCommentEdittext.getText().toString().trim();
        if (comment.equals("")) {
            Toast.makeText(getApplicationContext(), "评论不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        mCommentEdittext.setText("");
        return true;
    }

    /**
     * 发表评论
     */
    private void publishComment() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);

        CommentBean bean = new CommentBean();
        bean.setId(count);
        bean.setCommentNickname("雪惠&亮司" + count);
        bean.setCommentTime(str);
        bean.setCommnetAccount("12345" + count);
        bean.setCommentContent(comment);
        list.add(0, bean);//加载到list的最前面
        adapter.addMap(count);
        count++;

        Comment.CommitRequestParam commitRequestParam = new Comment.CommitRequestParam("0", "aaaa", "1", "1");
        getPresenter().commitComment(new RequestParam(commitRequestParam));

        adapter.notifyDataSetChanged();
    }

    private void DelectComment(int postion) {
        list.remove(postion);
        adapter.notifyDataSetChanged();
    }

    /**
     * 回复评论
     */
    private void replyComment() {
        ReplyBean bean = new ReplyBean();
        bean.setId(count + 10);
        bean.setCommentNickname(list.get(position).getCommentNickname());
        bean.setReplyNickname("雪惠");
        bean.setReplyContent(comment);
        adapter.getReplyComment(bean, position);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 10:
                    isReply = true;
                    position = (Integer) msg.obj;
                    mLytCommentVG.setVisibility(View.GONE);
                    mLytEdittextVG.setVisibility(View.VISIBLE);
                    onFocusChange(true);
                    break;
                case 11:
                    isReply = false;
                    position = (Integer) msg.obj;
                    DelectComment(position);
                    break;

            }

        }
    };

    /**
     * 事件点击监听器
     */
    private final class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.but_comment_send:        //发表评论按钮
                    if (isEditEmply()) {        //判断用户是否输入内容
                        if (isReply) {
                            replyComment();
                        } else {
                            publishComment();
                        }
                        mLytCommentVG.setVisibility(View.VISIBLE);
                        mLytEdittextVG.setVisibility(View.GONE);
                        onFocusChange(false);
                    }
                    break;
                case R.id.comment_vg_lyt:        //底部评论按钮
                    isReply = false;
                    mLytEdittextVG.setVisibility(View.VISIBLE);
                    mLytCommentVG.setVisibility(View.GONE);
                    onFocusChange(true);
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //判断控件是否显示
        if (mLytEdittextVG.getVisibility() == View.VISIBLE) {
            mLytEdittextVG.setVisibility(View.GONE);
            mLytCommentVG.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void showDetails(List<Detail> details) {


        strings.add("");

        mDetails = details;
        for (int i = 0; i < details.size(); i++) {
            ItemDetailBinding itemDetailBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.item_detail, null, false);
            itemDetailBinding.setDetail(details.get(i));
            mViews.add(itemDetailBinding.getRoot());
            strings.add(details.get(i).getTitle() + "\n" + details.get(i).getTimes());
        }
        strings.add("");
        mDetailPageAdapter.notifyDataSetChanged();
        StepsView stepview = new StepsView(getBaseContext());
        stepview.setLayoutParams(new FrameLayout.LayoutParams(300 * strings.size(), ViewGroup.LayoutParams.WRAP_CONTENT));
        stepview.setLabels(strings.toArray(new String[strings.size()]))
                .setBarColorIndicator(getResources().getColor(R.color.material_blue_grey_800))
                .setProgressColorIndicator(Color.GRAY)
                .setLabelColorIndicator(Color.GRAY)
                .setCompletedPosition(1)
                .drawView();

        mActivityDetailBinding.flStepview.addView(stepview);
    }



    @Override
    public void showDetailChannels(List<DetailChannel> detailChannels) {

    }

    @Override
    public void showCommitSucceed() {

    }
}
