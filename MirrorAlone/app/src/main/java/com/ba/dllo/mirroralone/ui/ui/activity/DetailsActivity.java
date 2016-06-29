package com.ba.dllo.mirroralone.ui.ui.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.MyApp;
import com.ba.dllo.mirroralone.ui.ui.activity.adornimage.VideoViewActivity;
import com.ba.dllo.mirroralone.ui.ui.activity.buydetails.OrderDetailsActivity;
import com.ba.dllo.mirroralone.ui.ui.adapter.DetailsBelowAdapter;
import com.ba.dllo.mirroralone.ui.ui.adapter.DetailsUpAdapter;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;
import com.ba.dllo.mirroralone.ui.ui.utils.ScreenUtils;
import com.ba.dllo.mirroralone.view.NoScrollListView;
import com.zhy.autolayout.AutoFrameLayout;

import java.util.List;

/**
 * 第二级详情界面
 * Created by ${巴为焱} on 16/6/27.
 */

@BindContent(R.layout.activity_details)
public class DetailsActivity extends BaseActivity implements AbsListView.OnScrollListener, View.OnClickListener {
    @BindView(R.id.aty_details_below_lv)
    private ListView belowLv;
    @BindView(R.id.aty_details_up_lv)
    private NoScrollListView upLv;
    @BindView(R.id.aty_details_bottom_rl)
    private View amLayout;
    @BindView(R.id.aty_details_wear_images_btn)
    private Button adornBtn;
    @BindView(R.id.aty_details_bug_img)
    private ImageView bugImg;
    @BindView(R.id.aty_details_back_img)
    private ImageView backImg;

    @Override
    public void initData() {
        // 一开始就利用属性动画将底部功能栏滑出屏幕
        showObjectAnimator(0, -ScreenUtils.getScreenHeight(MyApp.getContext()), 0);

        //给底层listview添加头布局
        View view = LayoutInflater.from(this).inflate(R.layout.head_view, null);
        // 底层ListView头布局中全透明部分
        AutoFrameLayout frameLayout = (AutoFrameLayout) view.findViewById(R.id.head_detail_null_fl);
        frameLayout.setMinimumHeight(ScreenUtils.getScreenHeight(MyApp.getContext()));
        View headView = LayoutInflater.from(this).inflate(R.layout.head_view_two, null);

        // 表层ListView头布局 只为了把其挤出屏幕
        ImageView nullImage = new ImageView(this);
        nullImage.setMinimumHeight((ScreenUtils.getScreenHeight(MyApp.getContext()) * 2));
        nullImage.setMinimumWidth(ScreenUtils.getScreenWidth(MyApp.getContext()));
        nullImage.setAlpha(0f);

        belowLv.addHeaderView(view);
        belowLv.addHeaderView(headView);
        upLv.addHeaderView(nullImage);
        belowLv.setAdapter(new DetailsBelowAdapter(this));
        upLv.setAdapter(new DetailsUpAdapter(this));
    }

    @Override
    public void setListener() {
        belowLv.setOnScrollListener(this);
        //购买按钮的监听
        bugImg.setOnClickListener(this);
        backImg.setOnClickListener(this);
        adornBtn.setOnClickListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    /**
     * 底层ListView 滑动监听
     *
     * @param view
     * @param firstVisibleItem 第一个可见的Item
     * @param visibleItemCount 屏幕中可见的Item个数
     * @param totalItemCount   全部Item个数
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        if (firstVisibleItem >= 1) {
            // 当第一个可见的Item >=1 时, 让表层ListView滑动
            upLv.setScrollY((int) (getScrollY(belowLv) * 1.2));
        }


        if (firstVisibleItem == 0) {
            // 当第一个可见的Item为0时, 将底部功能栏滑出屏幕
            showObjectAnimator(0, -ScreenUtils.getScreenHeight(MyApp.getContext()), 0);

        } else {
            // 当底部功能栏的X位置为-768 将其滑入屏幕
            if (amLayout.getX() == -ScreenUtils.getScreenHeight(MyApp.getContext())) {
                showObjectAnimator(-ScreenUtils.getScreenHeight(MyApp.getContext()), 0, 300);
            }
        }
    }


    // 获取滑动距离方法
    public int getScrollY(ListView l) {
        View v = l.getChildAt(0);
        if (v == null) {
            return 0;
        }
        int firstVisibleItem = l.getFirstVisiblePosition();
        int top = v.getTop();
        return -top + firstVisibleItem * v.getHeight();
    }


    /**
     * 让底部功能栏滑动的属性动画
     *
     * @param fromX
     * @param toX
     * @param time
     */
    public void showObjectAnimator(float fromX, float toX, long time) {
        ObjectAnimator.ofFloat(amLayout, "translationX", fromX, toX).setDuration(time).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aty_details_back_img:
                finish();
                break;
            case R.id.aty_details_bug_img:
                startActivity(new Intent(this, OrderDetailsActivity.class));
                break;
            case R.id.aty_details_wear_images_btn:
                startActivity(new Intent(this, VideoViewActivity.class));
                break;
        }
    }
}
