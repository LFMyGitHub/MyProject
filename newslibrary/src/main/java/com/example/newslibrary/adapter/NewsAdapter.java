package com.example.newslibrary.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.newslibrary.R;
import com.example.newslibrary.entity.NewsEntity;

import java.util.List;

public class NewsAdapter extends BaseQuickAdapter<NewsEntity.ResultBean, BaseViewHolder> {

    public NewsAdapter(int layoutResId, @Nullable List<NewsEntity.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsEntity.ResultBean item) {
        if (item == null) return;
        helper.setText(R.id.new_lib_news_item_content, item.getContent());
        helper.setText(R.id.new_lib_news_item_time, item.getUpdatetime());
    }
}
