package com.orientalfinance.eastcloud.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.orientalfinance.R;


/**
 * 类描述：App主点击按钮
 * 作者：lzy on 2016/11/04
 */
public class LoadingButton extends View {

    private int textColor;
    private int backgroundNormal;
    private float textSize;
    private String content;
    private int default_padding;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingTop;
    private int paddingRight;
    private Paint paintRect;
    private Paint paintTxt;
    private RectF rect;
    private float txtHeight;
    private Matrix matrix;
    private ObjectAnimator animator;
    private int mViewWidth;
    private int mViewHeight;
    private int STATE_NORMAL = 0;
    private int STATE_LOADING = 1;
    private int STATE_COMPLETED = 2;
    private int state = STATE_NORMAL;
    private String loadingTxt;
    private String contentNormal;
    private float corners;
    private int backgroundPressed;
    private Bitmap bitmap;
    private float drawablePadding;
    private String contentLoadingTxt;
    private String contentNormalTXT;

    public LoadingButton(Context context) {
        this(context, null, 0);
    }

    public LoadingButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        initData(context);
    }

    /**
     * 方法描述：初始化属性值
     *
     * @param context 上下文
     * @param attrs   属性集合
     */
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingButton);
        backgroundNormal = typeArray.getColor(R.styleable.LoadingButton_button_background_color_normal,
                Color.parseColor("#3A96FF"));
        backgroundPressed = typeArray.getColor(R.styleable.LoadingButton_button_background_color_pressed,
                Color.parseColor("#1E90FF"));
        textColor = typeArray.getColor(R.styleable.LoadingButton_button_text_color, Color.WHITE);
        textSize = typeArray.getDimension(R.styleable.LoadingButton_button_text_size, (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        contentNormal = typeArray.getString(R.styleable.LoadingButton_button_text);
        loadingTxt = typeArray.getString(R.styleable.LoadingButton_button_loading_text);
        drawablePadding = typeArray.getDimension(R.styleable.LoadingButton_drawable_paddingLeftOfTxt, (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 6, getResources().getDisplayMetrics()));
        corners = typeArray.getDimension(R.styleable.LoadingButton_corners, (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 6, getResources().getDisplayMetrics()));
        typeArray.recycle();
    }

    private void initData(Context context) {
        setNormalText(contentNormal);
        setLoadingText(loadingTxt);
        content = contentNormalTXT;

        default_padding = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 22, getResources().getDisplayMetrics());

        paddingBottom = getPaddingBottom();
        paddingLeft = getPaddingLeft();
        paddingTop = getPaddingTop();
        paddingRight = getPaddingRight();

        //矩形画笔
        paintRect = new Paint();
        paintRect.setColor(backgroundNormal);
        paintRect.setAntiAlias(true);
        paintRect.setStyle(Paint.Style.FILL);

        //矩形对象
        rect = new RectF();

        //文字画笔
        paintTxt = new Paint();
        paintTxt.setColor(textColor);
        paintRect.setAntiAlias(true);
        paintTxt.setTextAlign(Paint.Align.CENTER);
        paintTxt.setTextSize(textSize);

        txtHeight = (float) getTxtHeight(paintTxt);

        bitmap = zoomImg(BitmapFactory.decodeResource(context.getResources(), R.mipmap.button_loading),
                (int) txtHeight, (int) txtHeight);
    }

    /**
     * 方法描述：重置图片的宽高
     */
    private Bitmap zoomImg(Bitmap bm, int width, int height) {
        int originWidth = bm.getWidth();
        int originHeight = bm.getHeight();
        float scaleWidth = ((float) width) / originWidth;
        float scaleHeight = ((float) height) / originHeight;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bm, 0, 0, originWidth, originHeight, matrix, true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureWidth = measureWidth(widthMeasureSpec);
        int measureHeight = measureHeight(heightMeasureSpec);
        initRect(measureWidth, measureHeight);
        setMeasuredDimension(measureWidth, measureHeight);
    }

    /**
     * 方法描述：矩形对象初始化
     */
    private void initRect(int measureWidth, int measureHeight) {
        rect.left = 0;
        rect.top = 0;
        rect.right = measureWidth;
        rect.bottom = measureHeight;
    }

    /**
     * 方法描述：测量view的宽度
     *
     * @return view的宽度(单位px)
     */
    private int measureWidth(int measureSpec) {
        int width;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            width = specSize;
        } else {
            width = (int) paintTxt.measureText(content) + paddingLeft + paddingRight;
            if (specMode == MeasureSpec.AT_MOST) {
                width = Math.min(width, specSize);
            }
        }
        return width;
    }

    /**
     * 方法描述：测量View的高度
     *
     * @return View的高度（单位px）
     */
    private int measureHeight(int measureSpec) {
        int height = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            height = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            height = (int) txtHeight + paddingTop + paddingBottom + default_padding;
        }
        return height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float txtWidth = getTxtWidth(paintTxt, contentLoadingTxt);
        int bitmapWidth = bitmap.getWidth();
        canvas.drawRoundRect(rect, corners, corners, paintRect);
        if (state == STATE_NORMAL) {
            canvas.drawText(content, paddingLeft + rect.width() / 2 - paddingRight,
                    rect.height() / 2 + txtHeight / 3, paintTxt);
        }
        if (state == STATE_LOADING) {
            if (content.equals("")) {
                canvas.translate(mViewWidth / 2, mViewHeight / 2);
                matrix.preTranslate(-bitmap.getWidth() / 2, -bitmap.getHeight() / 2);
                canvas.drawBitmap(bitmap, matrix, null);
            } else {
                canvas.drawText(content, mViewWidth / 2 + paddingLeft - paddingRight +
                                bitmapWidth / 2 + drawablePadding / 2,
                        rect.height() / 2 + txtHeight / 3, paintTxt);
                canvas.translate(mViewWidth / 2 + paddingLeft - paddingRight - txtWidth / 2
                        - drawablePadding / 2, mViewHeight / 2);
                matrix.preTranslate(-bitmap.getWidth() / 2, -bitmap.getHeight() / 2);
                canvas.drawBitmap(bitmap, matrix, null);
            }
        }
        if (state == STATE_COMPLETED) {
            canvas.drawText(content, paddingLeft + rect.width() / 2 - paddingRight,
                    rect.height() / 2 + txtHeight / 3, paintTxt);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (listener == null) {
            return true;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                return true;
            case MotionEvent.ACTION_DOWN:
                paintRect.setColor(backgroundPressed);
                if (state == STATE_LOADING) {
                    return true;
                }
                content = contentNormalTXT;
                state = STATE_NORMAL;
                postInvalidate();
                break;
            case MotionEvent.ACTION_UP:
                RectF rectF = calcViewScreenLocation(this);
                boolean contains = rectF.contains(event.getRawX(), event.getRawY());
                paintRect.setColor(backgroundNormal);
                if (contains) {
                    content = contentLoadingTxt;
                    state = STATE_LOADING;
                    startAnim();
                    postInvalidate();
                    listener.onLoadingClick(this);
                } else if (state == STATE_NORMAL) {
                    content = contentNormalTXT;
                    paintRect.setColor(backgroundNormal);
                    state = STATE_NORMAL;
                    postInvalidate();
                }
                break;
        }
        return true;
    }


    /**
     * 方法描述：计算指定的 View 在屏幕中的坐标
     */
    private RectF calcViewScreenLocation(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new RectF(location[0], location[1], location[0] + view.getWidth(),
                location[1] + view.getHeight());
    }

    /**
     * 方法描述：获取去文本的宽度
     */
    private float getTxtWidth(Paint paint, String txt) {
        return paint.measureText(txt);
    }

    /**
     * 方法描述：获取文本字符的高度
     *
     * @param mPaint 画文本字符的画笔
     * @return 文本字符的高度
     */
    private double getTxtHeight(Paint mPaint) {
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        return Math.ceil(fm.descent - fm.ascent);
    }

    /**
     * 方法描述：开启动画
     */
    private void startAnim() {
        if (animator == null) {
            initAnimator();
            animator.start();
            return;
        }
        if (!animator.isRunning()) {
            animator.start();
        }
    }

    /**
     * 方法描述：取消动画
     */
    private void cancelAnim() {
        if (animator != null && animator.isRunning()) {
            animator.cancel();
        }
    }

    /**
     * 方法描述：初始化加载动画
     */
    private void initAnimator() {
        matrix = new Matrix();
        animator = ObjectAnimator.ofFloat(matrix, "rotation", 0, 360);
        animator.setDuration(1000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                matrix.setRotate((float) animation.getAnimatedValue());
                invalidate();
            }
        });
    }

    /**
     * 方法描述：加载完成以后设置view复位
     */
    public void setCompleted() {
        content = contentNormalTXT;
        state = STATE_COMPLETED;
        cancelAnim();
        postInvalidate();
    }

    /**
     * 方法描述：未点击时LoadingButton显示的文本
     *
     * @param normalText 文本字符串
     */
    private void setNormalText(@Nullable String normalText) {
        if (null != normalText) {
            this.contentNormalTXT = normalText;
        } else {
            this.contentNormalTXT = "";
        }
    }

    /**
     * 方法描述：点击按钮后加显示的加载文本
     *
     * @param loadingText 加载文本
     */
    private void setLoadingText(@Nullable String loadingText) {
        if (null != loadingText) {
            this.contentLoadingTxt = loadingText;
        } else {
            this.contentLoadingTxt = "";
        }
    }

    private OnLoadingListener listener;

    /**
     * 方法描述：设置点击监听器（相当于Button的setOnClickListener（））
     *
     * @param loadingListener 监听接口的实现类实例
     */
    public void setOnLoadingListener(OnLoadingListener loadingListener) {
        this.listener = loadingListener;
    }

    /**
     * 类描述：点击监听接口
     */
    public interface OnLoadingListener {
        void onLoadingClick(LoadingButton view);
    }
}