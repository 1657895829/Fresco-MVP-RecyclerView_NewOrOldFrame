package com.example.wangguo20180521.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangguo20180521.R;
import com.example.wangguo20180521.bean.User;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.internal.http.HttpHeaders;

/**
 * Created by lenovo on 2018/5/21.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private User user;

    public MyAdapter(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.sv1.setImageURI(user.getData().get(position).getProfile_image());
        holder.tv1.setText(user.getData().get(position).getName());
        holder.tv2.setText(user.getData().get(position).getPasstime());
        holder.tv3.setText(user.getData().get(position).getText());
        holder.sv2.setImageURI(user.getData().get(position).getImage1());
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        holder.sv1.getHierarchy().setRoundingParams(roundingParams);
    }

    @Override
    public int getItemCount() {
        return user.getData() == null ? 0 : user.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sv1)
        SimpleDraweeView sv1;
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.sv2)
        SimpleDraweeView sv2;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
