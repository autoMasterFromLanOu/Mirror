package com.ba.dllo.mirroralone.ui.ui.activity.buydetails;

/**
 * Created by ${巴为焱} on 16/6/28.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.model.bean.Address;
import com.ba.dllo.mirroralone.ui.ui.activity.BaseActivity;
import com.ba.dllo.mirroralone.ui.ui.activity.DetailsActivity;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;
import com.litesuits.orm.LiteOrm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @BindView(R.id.aty_order_name_layout)
    private View nameLayout;
    @BindView(R.id.aty_order_num_layout)
    private View numLayout;
    @BindView(R.id.aty_order_address_layout)
    private View addressLayout;
    @BindView(R.id.aty_order_name)
    private TextView nameTv;
    @BindView(R.id.aty_order_num)
    private TextView numTv;
    @BindView(R.id.aty_order_address)
    private TextView addressTv;
    @BindView(R.id.aty_order_msg_layout)
    private View msgLayout;
    @BindView(R.id.aty_order_frame_tv)
    private TextView frameTv;
    private PopupWindow payPop;
    private List<Address> addresses;
    private LiteOrm liteOrm;
    private int pos;

    /**
     * 此方法用来初始化组件
     */
    @Override
    public void initData() {
        getSupportActionBar().hide();
        payPop = new PopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.orderdetails_popwindow, null);
        payPop.setContentView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("position", MODE_PRIVATE);
        int pos = sharedPreferences.getInt("pos",0);
// Map<String,String> posData=new HashMap<>();

        liteOrm = LiteOrm.newCascadeInstance(OrderDetailsActivity.this, "address.db");
        addresses = liteOrm.query(Address.class);
        if (addresses.size() > 0 && pos == 0) {
            nameLayout.setVisibility(View.VISIBLE);
            numLayout.setVisibility(View.VISIBLE);
            addressLayout.setVisibility(View.VISIBLE);
            nameTv.setText(addresses.get(0).getName());
            numTv.setText(addresses.get(0).getNum());
            addressTv.setText(addresses.get(0).getAddress());
        } else if (addresses.size() > 0 && pos > 0) {
            Log.d("哈哈", "haha");
            nameLayout.setVisibility(View.VISIBLE);
            numLayout.setVisibility(View.VISIBLE);
            addressLayout.setVisibility(View.VISIBLE);
            nameTv.setText(addresses.get(pos).getName());
            numTv.setText(addresses.get(pos).getNum());
            addressTv.setText(addresses.get(pos).getAddress());
        } else {
            frameTv.setText("请添加收件人信息");
            frameTv.setVisibility(View.VISIBLE);
        }
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
                String address = frameTv.getText().toString();
                if (address.equals("请填写收件人信息")) {
                    Toast.makeText(OrderDetailsActivity.this, "请填写地址", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });


    }


}

