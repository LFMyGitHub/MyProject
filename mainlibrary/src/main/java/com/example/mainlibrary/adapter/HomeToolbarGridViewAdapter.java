package com.example.mainlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.commonlibrary.utils.GlideUtils;
import com.example.commonlibrary.utils.ResUtils;
import com.example.mainlibrary.entity.HomeToolBarGridViewEntity;
import com.example.newslibrary.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class HomeToolbarGridViewAdapter extends RecyclerView.Adapter<HomeToolbarGridViewAdapter.DefaultViewHolder> {
    private Context mContext;
    private List<HomeToolBarGridViewEntity> mHomeToolBarGridViewEntities;

    public HomeToolbarGridViewAdapter(Context context, int layoutResId, @Nullable List<HomeToolBarGridViewEntity> data) {
        this.mContext = context;
        this.mHomeToolBarGridViewEntities = data;
    }

    @NonNull
    @Override
    public DefaultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HomeToolbarGridViewAdapter.DefaultViewHolder viewHolder = new HomeToolbarGridViewAdapter.DefaultViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.commlib_toolbar_grid_view_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DefaultViewHolder holder, int position) {
        ImageView imageView = holder.iv_application;
        if (position == mHomeToolBarGridViewEntities.size() + 1) {
            GlideUtils.loadImageView(mContext, R.mipmap.commlib_all_big_ico, imageView);
            holder.tv_application_name.setText("更多");
        } else {
            final HomeToolBarGridViewEntity dataBean = mHomeToolBarGridViewEntities.get(position);
            String image = dataBean.getIco();
            if (ResUtils.isImgUrl(image)) {//是图片url
                GlideUtils.loadImageView(mContext, image, imageView);
            } else {
                GlideUtils.loadImageView(mContext, ResUtils.getResource(mContext, image), imageView);
            }
            holder.tv_application_name.setText(dataBean.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        if (mHomeToolBarGridViewEntities.size() >= 15) {
            return 15;
        } else {
            return mHomeToolBarGridViewEntities.size() + 1;
        }
    }

    static class DefaultViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_application;
        TextView tv_application_name;

        public DefaultViewHolder(View itemView) {
            super(itemView);
            iv_application = itemView.findViewById(R.id.commlib_grid_view_iv_ic_scan);
            tv_application_name = itemView.findViewById(R.id.commlib_grid_view_tv_ic_scan);
        }
    }

    public void setData(ArrayList<HomeToolBarGridViewEntity> applicationDataBeanList) {
        this.mHomeToolBarGridViewEntities = applicationDataBeanList;
    }
}
