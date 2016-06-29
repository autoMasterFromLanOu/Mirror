package com.ba.dllo.mirroralone.ui.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.ba.dllo.mirroralone.ui.ui.utils.MyListener;
import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.adapter.MainAdapter;
import com.ba.dllo.mirroralone.ui.ui.fragment.ClassifyFragment;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;
import com.ba.dllo.mirroralone.view.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

@BindContent(R.layout.activity_main)
public class MainActivity extends BaseActivity implements MyListener {
    @BindView(R.id.aty_main_vp)
    private VerticalViewPager mainVp;
    @BindView(R.id.aty_main_login_tv)
    private TextView longinTv;
    private MainAdapter mainAdapter;
    private List<Fragment> fragments;
    private MainReceiver mainReceiver;
    private String[] titles = {"全部分类", "浏览平光镜", "浏览太阳镜", "专题分享", "我的购物车"};

    @Override
    public void initData() {

        getSupportActionBar().hide();
        mainAdapter = new MainAdapter(getSupportFragmentManager());
        initFragment();
        mainAdapter.setFragments(fragments);
        mainVp.setAdapter(mainAdapter);

        //注册一个广播
        mainReceiver = new MainReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ba.dllo.mirroralone.POSITION");
        registerReceiver(mainReceiver, intentFilter);
    }

    //销毁广播
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mainReceiver);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ClassifyFragment classifyFragment = new ClassifyFragment(titles[i]);
            classifyFragment.setMyListener(this);
            fragments.add(classifyFragment);
        }
    }

    @Override
    public void setListener() {

    }

    @Override
    public int MyListener() {
        return mainVp.getCurrentItem();
    }


    class MainReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int pos = intent.getIntExtra("position", 1);
            if (pos < 5) {
                mainVp.setCurrentItem(pos);
            }
            if (pos == 5) {
                mainVp.setCurrentItem(0);
            }
        }
    }
}
