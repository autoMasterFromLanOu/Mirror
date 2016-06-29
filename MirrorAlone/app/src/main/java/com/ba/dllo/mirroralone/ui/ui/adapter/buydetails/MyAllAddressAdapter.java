package com.ba.dllo.mirroralone.ui.ui.adapter.buydetails;

/**
 * Created by ${巴为焱} on 16/6/28.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;


/**
 * Created by ${巴为焱} on 16/6/21.
 */
public abstract class MyAllAddressAdapter extends BaseAdapter {
    public Context mContext;

    public MyAllAddressAdapter(Context context) {
        this.mContext = context;
    }

    protected abstract View generateLeftView(final int position);

    protected abstract View generateRightView(final int position);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout = new LinearLayout(mContext);
        convertView = layout;

        layout.addView(generateLeftView(position));
        layout.addView(generateRightView(position));
        return convertView;
    }

}
