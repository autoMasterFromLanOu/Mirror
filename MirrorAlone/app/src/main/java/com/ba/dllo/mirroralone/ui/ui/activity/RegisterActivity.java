package com.ba.dllo.mirroralone.ui.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;


/**
 * 注册页面
 * Created by ${巴为焱} on 16/6/29.
 */
@BindContent(R.layout.activity_register)
public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.create_exit_iv)
    private ImageView closeImg;


    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        closeImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_exit_iv:
                finish();
                break;
        }
    }
}
