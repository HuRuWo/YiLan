package com.example.administrator.yilan000.ui.pictures.presenter;


import android.content.Context;

import com.example.administrator.yilan000.bean.MeiNvGson;
import com.example.administrator.yilan000.ui.pictures.contrant.MeiNvContract;
import com.example.administrator.yilan000.ui.pictures.model.MeiNvModel;
import com.example.administrator.yilan000.util.NetWorkUtil;

import java.util.List;

/**
 * Created by llf on 2017/3/15.
 * 新闻Presenter
 */

public class MeiNvPresenter implements MeiNvContract.Presenter, MeiNvContract.OnLoadFirstDataListener {
    private MeiNvContract.View view;
    private MeiNvContract.Model model;
    private Context context;

    public MeiNvPresenter(MeiNvContract.View view, Context context) {
       this.view = view;
        this.model = new MeiNvModel();
    }



    @Override
    public void loadData(int page) {
        model.loadData(this,page);
    }


    @Override
    public void onSuccess(List<MeiNvGson.NewslistBean> list) {

           view.returnData(list);
    }

    @Override
    public void onFailure(String str, Exception e) {
    }


}
