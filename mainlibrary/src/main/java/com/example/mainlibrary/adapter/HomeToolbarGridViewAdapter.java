package com.example.mainlibrary.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.commonlibrary.utils.GlideUtils;
import com.example.commonlibrary.utils.ResUtils;
import com.example.mainlibrary.entity.HomeToolBarGridViewEntity;
import com.example.newslibrary.R;

import java.util.List;

import androidx.annotation.Nullable;

public class HomeToolbarGridViewAdapter extends BaseQuickAdapter<HomeToolBarGridViewEntity, BaseViewHolder> {
    private Context mContext;
    private List<HomeToolBarGridViewEntity> mHomeToolBarGridViewEntities;

    public HomeToolbarGridViewAdapter(Context context, int layoutResId, @Nullable List<HomeToolBarGridViewEntity> data) {
        super(layoutResId, data);
        this.mContext = context;
        this.mHomeToolBarGridViewEntities = data;
    }

    @Override
    public int getItemCount() {
        if (mHomeToolBarGridViewEntities.size() >= 15) {
            return 15;
        } else {
            return mHomeToolBarGridViewEntities.size() + 1;
        }
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, HomeToolBarGridViewEntity homeToolBarGridViewEntity) {
        ImageView imageView = baseViewHolder.getView(R.id.commlib_grid_view_iv_ic_scan);
        if(baseViewHolder.getLayoutPosition() >= 14){
            GlideUtils.loadImageView(mContext, R.mipmap.commlib_all_big_ico, imageView);
            baseViewHolder.setText(R.id.commlib_grid_view_tv_ic_scan, "更多");
        }else {
            if (homeToolBarGridViewEntity == null) return;
            if (ResUtils.isImgUrl(homeToolBarGridViewEntity.getIco())) {//是图片url
                GlideUtils.loadImageView(mContext, homeToolBarGridViewEntity.getIco(), imageView);
            } else {
                GlideUtils.loadImageView(mContext, ResUtils.getResource(mContext, homeToolBarGridViewEntity.getIco()), imageView);
            }
            baseViewHolder.setText(R.id.commlib_grid_view_tv_ic_scan, homeToolBarGridViewEntity.getTitle());
        }
    }
}
