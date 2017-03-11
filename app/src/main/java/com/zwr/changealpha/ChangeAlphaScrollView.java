package com.zwr.changealpha;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 *    Created by zwr on 2017/3/11.
 *
 */
public class ChangeAlphaScrollView extends ScrollView {

    private  OnScrollChangedListener mOnScrollChangedListener;

    public ChangeAlphaScrollView(Context context) {
        super(context);
    }

    public ChangeAlphaScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChangeAlphaScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedListener != null) {
            mOnScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        mOnScrollChangedListener = listener;
    }

    public interface OnScrollChangedListener {
        void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt);
    }
}
