package com.example.administrator.yilan000.ui.news.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yilan000.R;
import com.example.administrator.yilan000.bean.NewsGson;
import com.example.administrator.yilan000.util.PictureUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by zhuchenxi on 16/6/2.
 */

public class NewsViewHolder extends BaseViewHolder<NewsGson.NewslistBean> {


    private TextView mTv_name;
    private ImageView mImg_face;
    private TextView mTv_sign;

    public NewsViewHolder(ViewGroup parent) {
        super(parent,R.layout.news_recycler_item);
        mTv_name = $(R.id.person_name);
        mTv_sign = $(R.id.person_sign);
        mImg_face = $(R.id.person_face);    }

    @Override
    public void setData(final NewsGson.NewslistBean data) {
        mTv_name.setText(data.getTitle());
        mTv_sign.setText(data.getCtime());
        PictureUtil.showImage(mImg_face,getContext(),data.getPicUrl());
    }

}
