package com.example.wangguo20180521.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wangguo20180521.R;
import com.example.wangguo20180521.bean.User;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by lenovo on 2018/5/21.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private Context context;
    private User user;

    public VideoAdapter(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.video_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.sv3.setImageURI(user.getData().get(position).getProfile_image());
        holder.tv4.setText(user.getData().get(position).getName());
        holder.tv5.setText(user.getData().get(position).getPasstime());
        holder.tv6.setText(user.getData().get(position).getText());
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        holder.sv3.getHierarchy().setRoundingParams(roundingParams);
        holder.videoplayer.setUp(user.getData().get(position).getVideouri(),JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
        Glide.with(context).load(user.getData().get(position).getImage1()) .into(holder.videoplayer.thumbImageView);
    }
    @Override
    public int getItemCount() {
        return user.getData() == null ? 0 : user.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sv3)
        SimpleDraweeView sv3;
        @BindView(R.id.tv4)
        TextView tv4;
        @BindView(R.id.tv5)
        TextView tv5;
        @BindView(R.id.tv6)
        TextView tv6;
        @BindView(R.id.videoplayer)
        JZVideoPlayerStandard videoplayer;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
