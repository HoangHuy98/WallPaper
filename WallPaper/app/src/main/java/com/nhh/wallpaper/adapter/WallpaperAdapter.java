package com.nhh.wallpaper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nhh.wallpaper.R;
import com.nhh.wallpaper.listener.ItemClick;
import com.nhh.wallpaper.model.Month;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.ViewHolder> {
    private List<Month> arrMonth;
    private Context context;
    private ItemClick itemClick;

    public WallpaperAdapter(List<Month> arrMonth, Context context) {
        this.arrMonth = arrMonth;
        this.context = context;
    }

    public WallpaperAdapter(List<Month> arrMonth, Context context, ItemClick itemClick) {
        this.arrMonth = arrMonth;
        this.context = context;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Month month = arrMonth.get(position);

        Glide.with(context).load(month.getImgMonth()).into(viewHolder.imgMonth);

        viewHolder.tvMonth.setText(month.getMonthName());
        viewHolder.tvAuthor.setText(month.getAuthor());
        viewHolder.flWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(position,v);            }
        });

    }

    @Override
    public int getItemCount() {
        return arrMonth.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMonth;
        TextView tvMonth, tvAuthor;
        FrameLayout flWallpaper;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMonth = itemView.findViewById(R.id.img_wallpaper);
            tvMonth = itemView.findViewById(R.id.tv_month);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            flWallpaper = itemView.findViewById(R.id.fl_wallpaper);

        }
    }
}
