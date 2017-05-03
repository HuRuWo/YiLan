package com.example.administrator.yilan000.ui.news.presenter;


import android.content.Context;

import com.example.administrator.yilan000.bean.NewsGson;
import com.example.administrator.yilan000.ui.news.contrant.NewsContract;
import com.example.administrator.yilan000.ui.news.model.NewsModel;
import com.example.administrator.yilan000.util.NetWorkUtil;

import java.util.List;

/**
 * Created by llf on 2017/3/15.
 * 新闻Presenter
 */

public class NewsPresenter implements NewsContract.Presenter, NewsContract.OnLoadFirstDataListener {
    private NewsContract.View view;
    private NewsContract.Model model;
    private Context context;

    public NewsPresenter(NewsContract.View view,Context context) {
        this.view = view;
        this.model = new NewsModel();
        this.context=context;
    }



    @Override
    public void loadData(int type, int page) {
        model.loadData(type,this,page);
    }




    @Override
    public void onSuccess(List<NewsGson.NewslistBean> list) {
           view.returnData(list);
    }

    @Override
    public void onFailure(String str, Throwable e) {
        NetWorkUtil.checkNetworkState(context);
    }

}
