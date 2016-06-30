package com.ba.dllo.mirroralone.ui.ui.activity.buydetails;

/**
 * Created by ${巴为焱} on 16/6/28.
 */

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.model.bean.Address;
import com.ba.dllo.mirroralone.ui.ui.activity.BaseActivity;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;
import com.litesuits.orm.LiteOrm;

import java.util.List;

/**
 * 此页面是编辑收件人地址页面
 * Created by ${巴为焱} on 16/6/18.
 */
@BindContent(R.layout.activity_modifi_address)
public class ModifiedAddressActivity extends BaseActivity {
    @BindView(R.id.aty_modifiadress_returniv)
    private ImageView returnImg;
    private LiteOrm liteOrm;
    private int pos;
    private List<Address> addresses;
    @BindView(R.id.aty_modifiadress_nameet)
    private EditText nameEt;
    @BindView(R.id.aty_modifiadress_numet)
    private EditText numEt;
    @BindView(R.id.aty_modifiadress_adresset)
    private EditText addressEt;
    @BindView(R.id.aty_modifiadress_presentbtn)
    private Button presentBtn;
    private String name, num, address;

    @Override
    public void initData() {
        getSupportActionBar().hide();
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

        presentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEt.getText().toString();
                num = numEt.getText().toString();
                address = addressEt.getText().toString();

                if (name.length() == 0 || num.length() == 0 || address.length() == 0) {
                    Toast.makeText(ModifiedAddressActivity.this, "请填写信息", Toast.LENGTH_SHORT).show();
                }
                if (name.length() != 0 && num.length() != 0 && address.length() != 0) {
                    Intent orderIntent = getIntent();
                    pos = orderIntent.getIntExtra("pos", 0);
                    liteOrm = LiteOrm.newCascadeInstance(ModifiedAddressActivity.this, "address.db");
                    addresses = liteOrm.query(Address.class);
                    addresses.get(pos).setName(name);
                    addresses.get(pos).setAddress(address);
                    addresses.get(pos).setNum(num);
                    liteOrm.update(addresses.get(pos));

                    Intent intent = new Intent(ModifiedAddressActivity.this, MyAllAddressActivity.class);
                    startActivity(intent);
                    Toast.makeText(ModifiedAddressActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

    }

}
