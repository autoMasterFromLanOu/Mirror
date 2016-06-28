package com.ba.dllo.mirroralone.ui.ui.activity;

import android.widget.ListView;

import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;

import java.util.List;

/**
 * 第二级详情界面
 * Created by ${巴为焱} on 16/6/27.
 */

@BindContent(R.layout.activity_details)
public class DetailsActivity extends BaseActivity {
    @BindView(R.id.aty_details_below_lv)
    private ListView belowLv;
    @BindView(R.id.aty_details_up_lv)
    private ListView upLv;




    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }
}
