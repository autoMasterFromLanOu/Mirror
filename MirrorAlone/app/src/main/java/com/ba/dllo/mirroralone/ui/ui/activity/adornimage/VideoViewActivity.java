package com.ba.dllo.mirroralone.ui.ui.activity.adornimage;

import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.activity.BaseActivity;
import com.ba.dllo.mirroralone.ui.ui.adapter.adornimage.VideoViewAdapter;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;
import com.ba.dllo.mirroralone.ui.ui.utils.ScreenUtils;
import com.ba.dllo.mirroralone.view.CommonVideoView;
import com.ba.dllo.mirroralone.view.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${巴为焱} on 16/6/29.
 */
@BindContent(R.layout.activity_videoview)
public class VideoViewActivity extends BaseActivity implements View.OnClickListener {
    private CommonVideoView commonVideoView;
    private List<Integer> imgs;
    private VideoViewAdapter videoViewAdapter;
    private PopupWindow myPop;
    @BindView(R.id.aty_video_lv)
    private MyListView myListView;
    @BindView(R.id.aty_video_rl)
    private View autoRl;
    private ImageView popImg;
    @BindView(R.id.item_video_close)
    private ImageView closeImg;

    @Override
    public void initData() {
        initPop();
        getSupportActionBar().hide();
        //给listView添加头布局
        View view = LayoutInflater.from(this).inflate(R.layout.item_videoview, null);
        commonVideoView = (CommonVideoView) view.findViewById(R.id.item_videoview);
        myListView.addHeaderView(view);
        commonVideoView.start("http://7xr7f7.com2.z0.glb.qiniucdn.com/Jimmy%20fairly%20-%20Spring%202014-HD.mp4");

        videoViewAdapter = new VideoViewAdapter(this);
        imgs = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            imgs.add(R.mipmap.ic_han);
        }
        videoViewAdapter.setImgs(imgs);
        myListView.setAdapter(videoViewAdapter);
    }

    private void initPop() {
        // 获取屏幕的宽与高
        int x = ScreenUtils.getScreenWidth(this);
        int y = ScreenUtils.getScreenHeight(this);
        myPop = new PopupWindow(x, y);

        View view = LayoutInflater.from(this).inflate(R.layout.item_popupwindow, null);
        popImg = (ImageView) view.findViewById(R.id.item_pop_img);

        // 通过setAnimationStyle()方法来设置
        // 开始和关闭的popupWindow动画
        myPop.setAnimationStyle(R.style.popwindow_anim_style);
        myPop.setContentView(view);
        myPop.setBackgroundDrawable(new BitmapDrawable());
        myPop.setFocusable(true);
        myPop.update();
        popImg.setOnClickListener(this);
    }


    @Override
    public void setListener() {
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myPop.showAtLocation(view, Gravity.CENTER, 0, 0);
                popImg.setImageResource(imgs.get(position - 1));
            }
        });

        closeImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_pop_img:
                myPop.dismiss();
                break;
            case R.id.item_video_close:
                finish();
                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            commonVideoView.setFullScreen();
            autoRl.setVisibility(View.GONE);
            myListView.setTouch(false);
        } else {
            commonVideoView.setNormalScreen();
            myListView.setTouch(null);
        }
    }

}
