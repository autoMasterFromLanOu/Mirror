package com.ba.dllo.mirroralone.ui.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;

import java.lang.reflect.Field;

/**
 * activity基类
 * Created by ${巴为焱} on 16/6/24.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentInject();
        viewInject();
        initData();
        setListener();
    }


    //绑定布局
    public void contentInject() {
        Class myClass = this.getClass();
        if (myClass.isAnnotationPresent(BindContent.class)) {
            BindContent bindContent = (BindContent) myClass.getAnnotation(BindContent.class);
            int id = bindContent.value();
            if (id > 0) {
                setContentView(id);
            }
        }
    }

    //初始化组件
    public void viewInject() {
        Class myClass = this.getClass();
        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(BindView.class)) {
                BindView bindView = field.getAnnotation(BindView.class);
                int id = bindView.value();
                if (id > 0) {
                    field.setAccessible(true);
                    try {
                        field.set(this, this.findViewById(id));
                    } catch (IllegalAccessException e) {

                    }
                }
            }
        }

    }


    //初始化数据
    public abstract void initData();

    //初始化监听
    public abstract void setListener();


}
