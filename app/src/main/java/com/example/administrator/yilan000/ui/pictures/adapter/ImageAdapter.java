package com.example.administrator.yilan000.ui.pictures.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.yilan000.bean.MeiNvGson;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Mr.Jude on 2016/6/7.
 */
public class ImageAdapter extends RecyclerArrayAdapter<MeiNvGson.NewslistBean> {
    public ImageAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(parent);
    }
}
