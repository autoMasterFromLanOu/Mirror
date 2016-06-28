package com.ba.dllo.mirroralone.ui.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ba.dllo.mirroralone.R;

import java.util.List;

/**
 * Created by ${巴为焱} on 16/6/27.
 */
public class DetailsBelowAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> belowDatas;

    public DetailsBelowAdapter(Context context) {
        this.context = context;
    }

    public void setBelowDatas(List<Integer> belowDatas) {
        this.belowDatas = belowDatas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return belowDatas == null ? 0 : belowDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_below_lv, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class ViewHolder {
        ImageView belowImg;

        public ViewHolder(View view) {
            belowImg = (ImageView) view.findViewById(R.id.item_below_img);
        }
    }
}
