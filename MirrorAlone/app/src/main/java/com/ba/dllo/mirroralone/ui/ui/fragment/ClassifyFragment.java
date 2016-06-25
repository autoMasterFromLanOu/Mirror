package com.ba.dllo.mirroralone.ui.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ba.dllo.mirroralone.ui.ui.adapter.ClassifyRvAdapter;
import com.ba.dllo.mirroralone.ui.ui.utils.MyListener;
import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.adapter.ClassifyAdapter;
import com.ba.dllo.mirroralone.ui.ui.utils.BindContent;
import com.ba.dllo.mirroralone.ui.ui.utils.BindView;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个是复用的fragment
 * Created by ${巴为焱} on 16/6/24.
 */
@BindContent(R.layout.fragment_classify)
public class ClassifyFragment extends BaseFragment {

    @BindView(R.id.fragment_classify_list)
    private View listLayout;
    @BindView(R.id.fragment_classify_titles_tv)
    private TextView titleTv;
    @BindView(R.id.fragment_classify_lv)
    private ListView titlesLv;
    @BindView(R.id.fragment_classify_rv)
    private RecyclerView classifyRv;
    @BindView(R.id.item)
    private View item;
    @BindView(R.id.fragment_classify_null_layout)
    private View nullLayout;
    private ClassifyAdapter classifyAdapter;
    private List<String> titles;
    private String title;
    private MyListener myListener;

    private ClassifyRvAdapter classifyRvAdapter;
    private List<Integer> imgs;

    public void setMyListener(MyListener myListener) {
        this.myListener = myListener;
    }

    public ClassifyFragment(String title) {
        this.title = title;
    }

    @Override
    public void initData() {
        titleTv.setText(title);
        if (title.equals("我的购物车")) {
            titlesLv.setVisibility(View.GONE);
            classifyRv.setVisibility(View.GONE);
            listLayout.setVisibility(View.VISIBLE);
            nullLayout.setVisibility(View.VISIBLE);
        }

        titles = new ArrayList<>();
        titles.add("浏览所有分类");
        titles.add("浏览平光镜");
        titles.add("浏览太阳镜");
        titles.add("专题分享");
        titles.add("我的购物车");
        titles.add("返回首页");
        titles.add("退出");
        classifyAdapter = new ClassifyAdapter(context);
        classifyAdapter.setTitles(titles);
        titlesLv.setAdapter(classifyAdapter);

        listLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = myListener.MyListener();
                classifyAdapter.setPos(num);
                titlesLv.setVisibility(View.VISIBLE);
                listLayout.setVisibility(View.GONE);
                classifyRv.setVisibility(View.GONE);
            }
        });

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titlesLv.setVisibility(View.GONE);
                nullLayout.setVisibility(View.GONE);
                listLayout.setVisibility(View.VISIBLE);
                classifyRv.setVisibility(View.VISIBLE);

            }
        });

        titlesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent("com.ba.dllo.mirroralone.POSITION");
                intent.putExtra("position", position);
                classifyAdapter.setPos(position);

                if (0 <= position && position < 4) {
                    titlesLv.setVisibility(View.GONE);
                    classifyRv.setVisibility(View.VISIBLE);
                    listLayout.setVisibility(View.VISIBLE);

                }
                if (position == 4) {
                    nullLayout.setVisibility(View.VISIBLE);
                    titlesLv.setVisibility(View.GONE);
                    listLayout.setVisibility(View.VISIBLE);
                    classifyRv.setVisibility(View.GONE);

                }
                if (position == 5) {
                    titlesLv.setVisibility(View.GONE);
                    listLayout.setVisibility(View.VISIBLE);
                    classifyRv.setVisibility(View.VISIBLE);
                }
                if (position == 6) {
                    Toast.makeText(context, "是否退出", Toast.LENGTH_SHORT).show();
                }
                context.sendBroadcast(intent);
            }
        });

        /**
         * 横向的recycleview
         */
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        classifyRv.setLayoutManager(manager);
        classifyRvAdapter = new ClassifyRvAdapter(context);
        imgs = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            imgs.add(R.mipmap.ic_han);
        }
        classifyRvAdapter.setImgs(imgs);
        classifyRv.setAdapter(classifyRvAdapter);
    }


}
