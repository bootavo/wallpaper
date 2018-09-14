package com.wallpaper.wallpapers.adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.wallpaper.wallpapers.R;
import com.wallpaper.wallpapers.listeners.OnItemClickListener;
import com.wallpaper.wallpapers.models.Wallpapers;
import com.wallpaper.wallpapers.utilities.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private List<Wallpapers> mList;
    private OnItemClickListener listener;
    private Context ctx;
    private int lastPosition = -1;

    public UserAdapter(Context ctx, List<Wallpapers> mList, OnItemClickListener listener) {
        this.mList = mList;
        this.listener = listener;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_wallpapers, parent, false);
        return new UserViewHolder(ctx, itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(mList.get(position), listener);
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(ctx, R.anim.anim_item_list);
            holder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull UserViewHolder holder) {
        holder.itemView.clearAnimation();
    }

    public void setfilter(List<Wallpapers> listitem) {
        mList = new ArrayList<>();
        mList.addAll(listitem);
        notifyDataSetChanged();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        private Context ctx;
        private TextView mTitle;
        private TextView mDate;
        private TextView mSize;
        private ImageView mPhoto;

        public UserViewHolder(Context ctx, View view) {
            super(view);
            this.mTitle = view.findViewById(R.id.tv_title);
            this.mSize = view.findViewById(R.id.tv_size);
            this.mDate = view.findViewById(R.id.tv_date);
            this.mPhoto = view.findViewById(R.id.iv_picture);
            this.ctx = ctx;
        }

        public void bind(final Wallpapers wallpapers, OnItemClickListener listener){
            mTitle.setText(""+wallpapers.getTitle());
            mSize.setText(""+wallpapers.getSize());
            mDate.setText(""+wallpapers.getUpload_date());
            if(wallpapers.getUrl_picture() == null || wallpapers.getUrl_picture().equals("")){
                GlideApp.with(ctx).load(R.drawable.login).into(mPhoto);
            }else{
                GlideApp.with(ctx).load(wallpapers.getUrl_picture()).into(mPhoto);
            }
            itemView.setOnClickListener(v -> {
                listener.onItemClick(wallpapers);
            });
        }

    }

}