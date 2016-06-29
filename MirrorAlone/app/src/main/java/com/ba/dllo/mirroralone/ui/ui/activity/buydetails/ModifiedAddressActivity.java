package com.ba.dllo.mirroralone.ui.ui.activity.buydetails;

/**
 * Created by ${巴为焱} on 16/6/28.
 */

import android.view.View;
import android.widget.ImageView;

import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.activity.BaseActivity;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;

/**
 * 此页面是编辑收件人地址页面
 * Created by ${巴为焱} on 16/6/18.
 */
@BindContent(R.layout.activity_modifi_address)
public class ModifiedAddressActivity extends BaseActivity {
    @BindView(R.id.aty_modifiadress_returniv)
    private ImageView returnImg;


    @Override
    public void initData() {

    }


    /**
     * 此方法中是所有组件的监听事件
     */
    @Override
    public void setListener() {

        returnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
