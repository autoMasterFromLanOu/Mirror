package com.ba.dllo.mirroralone.ui.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ba.dllo.mirroralone.R;

import java.util.List;

/**
 * Created by ${巴为焱} on 16/6/25.
 */
public class ClassifyRvAdapter extends RecyclerView.Adapter<ClassifyRvAdapter.ClassifyRvViewHolder> {
    private Context context;
    private List<Integer> imgs;


    public ClassifyRvAdapter(Context context) {
        this.context = context;
    }

    public void setImgs(List<Integer> imgs) {
        this.imgs = imgs;
        notifyDataSetChanged();
    }

    @Override
    public ClassifyRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_classify_rv, parent, false);
        ClassifyRvViewHolder holder = new ClassifyRvViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ClassifyRvViewHolder holder, int position) {
        holder.img.setImageResource(imgs.get(position));
    }

    @Override
    public int getItemCount() {
        return imgs == null ? 0 : imgs.size();
    }

    class ClassifyRvViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public ClassifyRvViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_rv_img);
        }
    }
}
