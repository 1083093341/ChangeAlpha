package com.zwr.changealpha;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

/**
 *   Created by zwr on 2017/3/11.
 */
public class MainActivity extends AppCompatActivity implements ChangeAlphaScrollView.OnScrollChangedListener {

    private ImageView imageView;
    private Toolbar toolBar;
    private float headerHeight;//顶部高度
    private float minHeight;//顶部最低高度，即Bar的高度
    private ChangeAlphaScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        scrollView = (ChangeAlphaScrollView) findViewById(R.id.myScrollView);
        toolBar = (Toolbar) findViewById(R.id.tool_bar_home);
        scrollView.setOnScrollChangedListener(this);
        initMeasure();
    }

    @Override
    public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
        //得到y轴的偏移量
        float scrollY = who.getScrollY();
        //变化率
        float headerBarOffsetY = headerHeight - minHeight;
        float offset = 1 - Math.max((headerBarOffsetY - scrollY) / headerBarOffsetY, 0f);

        //Toolbar背景色透明度
        toolBar.setBackgroundColor(Color.argb((int) (offset * 255), 255, 64, 129));//颜色的RGB值

    }

    //调用此方法重新测量得到控件高度
    private void initMeasure() {
        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        imageView.measure(w, h);
        headerHeight =imageView.getMeasuredHeight();
        toolBar.measure(w,h);
        minHeight=toolBar.getMeasuredHeight();
    }
}
