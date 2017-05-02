package com.example.administrator.yilan000.ui.news.model;

import com.example.administrator.yilan000.bean.NewsGson;
import com.example.administrator.yilan000.constant.AppConfig;
import com.example.administrator.yilan000.constant.TypeUrl;
import com.example.administrator.yilan000.retrofit.ApiService;
import com.example.administrator.yilan000.retrofit.RetrofitWrapper;
import com.example.administrator.yilan000.ui.news.contrant.NewsContract;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class NewsModel implements NewsContract.Model{

    @Override
    public void loadData( int type, final NewsContract.OnLoadFirstDataListener listener,int page) {
            ApiService apiManager = RetrofitWrapper.getInstance().create(ApiService.class);//这里采用的是Java的动态代理模式
            apiManager.getNewsData(TypeUrl.getTypeUrl(type),AppConfig.APIKEY, "10", page)
                    .subscribeOn(Schedulers.io())
                    .map(new Func1<NewsGson, List<NewsGson.NewslistBean>>() {
                        @Override
                        public List<NewsGson.NewslistBean> call(NewsGson newsgson) { //
                            List<NewsGson.NewslistBean> newsList = new ArrayList<NewsGson.NewslistBean>();
                            for (NewsGson.NewslistBean newslistBean : newsgson.getNewslist()) {
                                NewsGson.NewslistBean new1 = new NewsGson.NewslistBean();
                                new1.setTitle(newslistBean.getTitle());
                                new1.setCtime(newslistBean.getCtime());
                                new1.setDescription(newslistBean.getDescription());
                                new1.setPicUrl(newslistBean.getPicUrl().replace("_ss",""));
                                new1.setUrl(newslistBean.getUrl());
                                newsList.add(new1);
                            }
                            return newsList; // 返回类型
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<List<NewsGson.NewslistBean>>() {
                        @Override
                        public void onNext(List<NewsGson.NewslistBean> newsList) {
                            //成功  数据传出去
                              listener.onSuccess(newsList);
                        }

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });


    }
}
