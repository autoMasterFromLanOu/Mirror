package com.ba.dllo.mirroralone.ui.ui.activity.buydetails;

/**
 * Created by ${巴为焱} on 16/6/28.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.model.bean.Address;
import com.ba.dllo.mirroralone.ui.ui.MyApp;
import com.ba.dllo.mirroralone.ui.ui.activity.BaseActivity;
import com.ba.dllo.mirroralone.ui.ui.adapter.buydetails.MyAllAddressAdapter;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;
import com.ba.dllo.mirroralone.view.SwipListView;
import com.litesuits.orm.LiteOrm;

/**
 * 此页面是显示收件人所有收货地址页面
 * 此页面可以点击添加地址按钮 进入添加地址页面
 * 收货地址信息可以实现修改 删除功能
 * Created by ${巴为焱} on 16/6/18.
 */
@BindContent(R.layout.activity_myall_address)
public class MyAllAddressActivity extends BaseActivity {
    @BindView(R.id.aty_myaddress_btn)
    private Button addAddressBtn;
    @BindView(R.id.aty_myaddress_lv)
    private SwipListView addressLv;
    @BindView(R.id.aty_myaddress_returniv)
    private ImageView returnImg;
    //    private List<String> addressBeen = new ArrayList<>();
    private List<Address> addressBean;
    private Address myAddress;
    private LiteOrm liteOrm;


    @Override
    public void initData() {
        getSupportActionBar().hide();
        AddressAdapter addressAdapter = new AddressAdapter(this);
        liteOrm = LiteOrm.newCascadeInstance(MyAllAddressActivity.this, "address.db");
        addressBean = liteOrm.query(Address.class);
        addressAdapter.setAddresses(addressBean);
        addressLv.setAdapter(addressAdapter);
        addressLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sharedPreferences = getSharedPreferences("position", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("pos",position);
                editor.commit();
                finish();
                Toast.makeText(MyAllAddressActivity.this, "现在的位置是:" + position, Toast.LENGTH_SHORT).show();
            }
        });
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
                Intent intent = new Intent(MyAllAddressActivity.this, AddAddressActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //返回按钮的监听
        returnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    class AddressAdapter extends MyAllAddressAdapter {
        private List<Address> addresses;


        public AddressAdapter(Context context) {
            super(context);
        }


        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return addresses == null ? 0 : addresses.size();
        }

        @Override
        public Object getItem(int position) {
            return addresses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }

        @Override
        protected View generateLeftView(final int position) {
            LinearLayout layout = new LinearLayout(mContext);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layout.setLayoutParams(lp);

            View view = LayoutInflater.from(mContext).inflate(R.layout.item_myall_address, layout, false);
            TextView nameTv, numTv, addressTv;
            ImageView changeImg;
            nameTv = (TextView) view.findViewById(R.id.aty_myaddress_name);
            numTv = (TextView) view.findViewById(R.id.aty_myaddress_num);
            addressTv = (TextView) view.findViewById(R.id.aty_myaddress_address);
            changeImg = (ImageView) view.findViewById(R.id.address_change_img);

            nameTv.setText(addresses.get(position).getName());
            numTv.setText(addresses.get(position).getNum());
            addressTv.setText(addresses.get(position).getAddress());

            changeImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyAllAddressActivity.this, ModifiedAddressActivity.class);
                    intent.putExtra("pos", position);
                    startActivity(intent);
                    finish();
                }
            });
            return view;
        }

        @Override
        protected View generateRightView(final int position) {
            LinearLayout layout = new LinearLayout(mContext);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layout.setLayoutParams(lp);
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_delete, layout, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "删除第 " + position + "条", Toast.LENGTH_SHORT).show();
                    myAddress = liteOrm.queryById(addressBean.get(position).getId(), Address.class);
                    liteOrm.delete(myAddress);
                    addressBean.remove(position);
                    notifyDataSetChanged();
                }
            });
            return view;
        }
    }
}
