package com.ba.dllo.mirroralone.ui.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.adapter.MainAdapter;
import com.ba.dllo.mirroralone.ui.ui.fragment.ClassifyFragment;
import com.ba.dllo.mirroralone.ui.ui.fragment.ShoppingFragment;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;
import com.ba.dllo.mirroralone.view.VerticalViewPager;
import java.util.ArrayList;
import java.util.List;

@BindContent(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @BindView(R.id.aty_main_vp)
    private VerticalViewPager mainVp;
    @BindView(R.id.aty_main_login_tv)
    private TextView longinTv;
    private MainAdapter mainAdapter;
    private List<Fragment> fragments;

    @Override
    public void initData() {

        getSupportActionBar().hide();
        mainAdapter = new MainAdapter(getSupportFragmentManager());
        initFragment();
        mainAdapter.setFragments(fragments);
        mainVp.setAdapter(mainAdapter);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            fragments.add(new ClassifyFragment());
        }
        fragments.add(new ShoppingFragment());
    }

    @Override
    public void setListener() {

    }
}
