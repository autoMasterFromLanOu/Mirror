package com.ba.dllo.mirroralone.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by ${巴为焱} on 16/6/28.
 */
public class NoScrollListView extends ListView {
    public NoScrollListView(Context context) {
        super(context);
    }

    public NoScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    // onInterceptTouchEvent()是用于处理事件（重点onInterceptTouchEvent这个事件是从父控件开始往子控件传的，直到有拦截或者到没有这个事件的view，然后就往回从子到父控件，这次是onTouch的）
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // 是否允许Touch事件继续向下（子控件）传递，一但返回True（代表事件在当前的viewGroup中会被处理）
        return true;
    }

    // onTouchEvent()用于处理事件（重点onTouch这个事件是从子控件回传到父控件的，一层层向下传），返回值决定当前控件是否消费（consume）了这个事件，也就是说在当前控件在处理完Touch事件后，是否还允许Touch事件继续向上（父控件）传递。
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // 返回false，则向上传递给父控件
        return false;
    }
}
