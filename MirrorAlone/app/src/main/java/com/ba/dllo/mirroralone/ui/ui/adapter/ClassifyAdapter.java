package com.ba.dllo.mirroralone.ui.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ba.dllo.mirroralone.R;

import java.util.List;

/**
 * Created by ${巴为焱} on 16/6/25.
 */
public class ClassifyAdapter extends BaseAdapter {
    private Context context;
    private List<String> titles;
    private int pos;

    public void setPos(int pos) {
        this.pos = pos;
        Log.d("ClassifyAdapter", "pos:" + pos);
    }

    public ClassifyAdapter(Context context) {
        this.context = context;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return titles == null ? 0 : titles.size();
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lv, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.titleTv.setText(titles.get(position));
//        if (position==0){
//            holder.lineOne.setVisibility(View.VISIBLE);
//        }else if (position>0&&position ==pos)
//       {
//            Log.d("ClassifyAdapter", "pos:" + pos);
//            holder.lineOne.setVisibility(View.VISIBLE);

        holder.titleTv.setTextColor(0X25ffffff);
        holder.lineOne.setVisibility(View.GONE);

        if (pos == position) {
            holder.titleTv.setTextColor(context.getResources().getColor(R.color.white));
            holder.lineOne.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    class ViewHolder {
        TextView titleTv;
        ImageView lineOne;

        public ViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_title);
            lineOne = (ImageView) view.findViewById(R.id.item_line);
        }
    }
}
