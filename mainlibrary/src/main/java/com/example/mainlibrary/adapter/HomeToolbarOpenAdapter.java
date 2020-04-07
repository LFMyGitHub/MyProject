package com.example.mainlibrary.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.commonlibrary.utils.GlideUtils;
import com.example.commonlibrary.utils.ResUtils;
import com.example.mainlibrary.entity.HomeToolbarEntity;
import com.example.newslibrary.R;

import java.util.List;

import androidx.annotation.Nullable;

public class HomeToolbarOpenAdapter extends BaseQuickAdapter<HomeToolbarEntity.ResultBean, BaseViewHolder> {
    private Context mContext;

    public HomeToolbarOpenAdapter(Context context, int layoutResId, @Nullable List<HomeToolbarEntity.ResultBean> data) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeToolbarEntity.ResultBean item) {
        if (item == null) return;
        ImageView imageView = helper.getView(R.id.commlib_iv_ic_scan);
        if (ResUtils.isImgUrl(item.getIcon())) {//是图片url
            GlideUtils.loadImageView(mContext, item.getIcon(), imageView);
        } else {
            GlideUtils.loadImageView(mContext, ResUtils.getResource(mContext, item.getIcon()), imageView);
        }
        helper.setText(R.id.commlib_tv_ic_scan, item.getTitle());
    }
}
