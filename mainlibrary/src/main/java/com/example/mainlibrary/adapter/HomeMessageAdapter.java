package com.example.mainlibrary.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mainlibrary.R;
import com.example.mainlibrary.entity.HomeDataEntity;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeMessageAdapter extends BannerAdapter<HomeDataEntity.AdsBean, HomeMessageAdapter.ImageHolder> {

    private Context mContext;


    public HomeMessageAdapter(Context context, List<HomeDataEntity.AdsBean> datas) {
        super(datas);
        this.mContext = context;
    }

    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = (ImageView) BannerUtils.getView(parent, R.layout.commlib_banner_image);
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder  holder, HomeDataEntity.AdsBean data, int position, int size) {
//        if (ResUtils.isImgUrl(data.getCover())) {//是图片url
//            GlideUtils.loadBannerImageView(data.getCover(), holder.imageView);
//        } else {
//            GlideUtils.loadBannerImageView(ResUtils.getResource(mContext, data.getCover()), holder.imageView);
//        }
//        Glide.with(holder.imageView)
//                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586433533825&di=d90e2cbc371261cab7d26134f51b5bdc&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fwallpaper%2F1308%2F15%2Fc5%2F24496183_1376533418348.jpg")
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
//                .into(holder.imageView);

        holder.imageView.setImageResource(R.mipmap.commlib_all_big_ico);

    }

    class ImageHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ImageHolder(@NonNull View view) {
            super(view);
            this.imageView = (ImageView) view;
        }
    }
}
