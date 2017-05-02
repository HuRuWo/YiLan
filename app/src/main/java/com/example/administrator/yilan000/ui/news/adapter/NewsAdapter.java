package com.example.administrator.yilan000.ui.news.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.yilan000.bean.NewsGson;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Mr.Jude on 2016/6/7.
 */
public class NewsAdapter extends RecyclerArrayAdapter<NewsGson.NewslistBean> {
    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {

        return new NewsViewHolder(parent);
    }
}
