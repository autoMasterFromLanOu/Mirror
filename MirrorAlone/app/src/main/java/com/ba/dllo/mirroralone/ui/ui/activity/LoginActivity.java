package com.ba.dllo.mirroralone.ui.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;


/**
 * Created by ${巴为焱} on 16/6/29.
 */
@BindContent(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.create_account_btn)
    private Button creatBtn;
    @BindView(R.id.login_exit_iv)
    private ImageView closeImg;
    @BindView(R.id.weibo_icon_iv)
    private ImageView sinaImg;
    @BindView(R.id.weixin_icon_iv)
    private ImageView qqImg;

    @Override
    public void initData() {
        ShareSDK.initSDK(this);

    }

    @Override
    public void setListener() {

        creatBtn.setOnClickListener(this);
        closeImg.setOnClickListener(this);
        sinaImg.setOnClickListener(this);
        qqImg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_account_btn:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.login_exit_iv:
                finish();
                break;
            case R.id.weibo_icon_iv:
                Platform sina = ShareSDK.getPlatform(SinaWeibo.NAME);
                sina.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                sina.authorize();
                break;
            case R.id.weixin_icon_iv:
                Platform qq = ShareSDK.getPlatform(QQ.NAME);
                qq.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                qq.authorize();
                break;
        }
    }
}
