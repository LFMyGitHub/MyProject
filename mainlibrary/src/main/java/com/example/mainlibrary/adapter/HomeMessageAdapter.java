package com.example.mainlibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mainlibrary.R;
import com.example.mainlibrary.entity.HomeDataEntity;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeMessageAdapter extends BannerAdapter<HomeDataEntity.MessagesBean, HomeMessageAdapter.ImageHolder> {

    private Context mContext;


    public HomeMessageAdapter(Context context, List<HomeDataEntity.MessagesBean> datas) {
        super(datas);
        this.mContext = context;
    }

    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new ImageHolder(BannerUtils.getView(parent, R.layout.commlib_banner_message_item));
    }

    @Override
    public void onBindView(ImageHolder holder, HomeDataEntity.MessagesBean data, int position, int size) {
        holder.message.setText(data.getTitle());
        if (Integer.parseInt(data.getType()) == 1) {
        } else if (Integer.parseInt(data.getType()) == 2) {
        } else if (Integer.parseInt(data.getType()) == 3) {
        }
        holder.source.setText(data.getTypename());
        holder.time.setText(data.getCreate_date());
    }

    class ImageHolder extends RecyclerView.ViewHolder {
        public TextView message;
        public TextView source;
        public TextView time;

        public ImageHolder(@NonNull View view) {
            super(view);
            this.message = view.findViewById(R.id.commlib_message_tv1);
            this.source = view.findViewById(R.id.commlib_message_tv2);
            this.time = view.findViewById(R.id.commlib_message_tv3);
        }
    }
}
