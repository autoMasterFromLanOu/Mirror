package com.ba.dllo.mirroralone.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by ${巴为焱} on 16/6/29.
 */
public class MyListView extends ListView {
    private Boolean isTouch;

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context) {
        super(context);
    }


    public void setTouch(Boolean touch) {
        isTouch = touch;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (isTouch != null) {
            return isTouch;
        }
        return super.onInterceptTouchEvent(e);
    }
}
