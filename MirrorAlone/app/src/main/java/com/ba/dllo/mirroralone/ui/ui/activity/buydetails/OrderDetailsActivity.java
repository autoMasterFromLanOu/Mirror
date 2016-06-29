package com.ba.dllo.mirroralone.ui.ui.activity.buydetails;

/**
 * Created by ${巴为焱} on 16/6/28.
 */

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.activity.BaseActivity;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;

/**
 * 此页是购买详情页
 * 有 显示收件人地址 购买物品 等信息
 * 有 添加收件人地址 确认下单 等功能
 * Created by ${巴为焱} on 16/6/18.
 */
@BindContent(R.layout.activity_order_details)
public class OrderDetailsActivity extends BaseActivity {

    @BindView(R.id.aty_order_addressbtn)
    private Button addAddressBtn;
    @BindView(R.id.aty_order_orderbtn)
    private Button orderBtn;
    @BindView(R.id.aty_order_returniv)
    private ImageView returnImg;
    @BindView(R.id.aty_order_msgtv)
    private TextView addressTv;
    private PopupWindow payPop;


    /**
     * 此方法用来初始化组件
     */
    @Override
    public void initData() {
        payPop = new PopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.orderdetails_popwindow, null);
        payPop.setContentView(view);
    }

    /**
     * 此方法中是各个组件的监听事件
     */
    @Override
    public void setListener() {

        //添加地址按钮的监听
        addAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderDetailsActivity.this, MyAllAddressActivity.class);
                startActivity(intent);
            }
        });
        //返回按钮的监听
        returnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //确认下单的监听
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = addressTv.getText().toString();
                if (address.equals("请填写收件人信息")) {
                    Toast.makeText(OrderDetailsActivity.this, "请填写地址", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });


    }


}

