package com.ba.dllo.mirroralone.ui.ui.adapter.adornimage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.ba.dllo.mirroralone.R;

import java.util.List;

/**
 * Created by ${巴为焱} on 16/6/29.
 */
public class VideoViewAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> imgs;

    public VideoViewAdapter(Context context) {
        this.context = context;
    }

    public void setImgs(List<Integer> imgs) {
        this.imgs = imgs;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return imgs == null ? 0 : imgs.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_video_view, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.myLvImg.setImageResource(imgs.get(position));
        return convertView;
    }

    class ViewHolder {
        ImageView myLvImg;

        public ViewHolder(View view) {
            myLvImg = (ImageView) view.findViewById(R.id.item_video_img);
        }
    }
}
