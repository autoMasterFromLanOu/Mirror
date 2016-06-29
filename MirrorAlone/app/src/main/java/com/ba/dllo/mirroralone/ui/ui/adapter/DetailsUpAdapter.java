package com.ba.dllo.mirroralone.ui.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ba.dllo.mirroralone.R;
import com.ba.dllo.mirroralone.ui.ui.MyApp;
import com.ba.dllo.mirroralone.ui.ui.utils.ScreenUtils;

/**
 * Created by ${巴为焱} on 16/6/27.
 */
public class DetailsUpAdapter extends BaseAdapter {
    private Context context;

    public DetailsUpAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_up_lv, parent, false);
            convertView.setMinimumHeight(ScreenUtils.getScreenHeight(MyApp.getContext()) / 3 * 2);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class ViewHolder {
        TextView nameTv, contentTv;

        public ViewHolder(View view) {
            nameTv = (TextView) view.findViewById(R.id.item_details_top_name_tv);
            contentTv = (TextView) view.findViewById(R.id.item_details_top_content_tv);
        }
    }
}
