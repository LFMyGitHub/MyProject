package com.example.mainlibrary.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import com.example.commonlibrary.utils.GlideUtils;
import com.example.commonlibrary.utils.ResUtils;
import com.example.mainlibrary.R;
import com.example.mainlibrary.entity.HomeDataEntity;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdAdapter extends BannerAdapter<HomeDataEntity.AdsBean, HomeAdAdapter.ImageHolder> {

    private Context mContext;


    public HomeAdAdapter(Context context, List<HomeDataEntity.AdsBean> datas) {
        super(datas);
        this.mContext = context;
    }

    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = (ImageView) BannerUtils.getView(parent, R.layout.commlib_banner_item_ad);
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder  holder, HomeDataEntity.AdsBean data, int position, int size) {
        if (ResUtils.isImgUrl(data.getCover())) {//是图片url
            GlideUtils.loadBannerImageView(data.getCover(), holder.imageView);
        } else {
            GlideUtils.loadBannerImageView(ResUtils.getResource(mContext, data.getCover()), holder.imageView);
        }
    }

    class ImageHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ImageHolder(@NonNull View view) {
            super(view);
            this.imageView = (ImageView) view;
        }
    }
}
