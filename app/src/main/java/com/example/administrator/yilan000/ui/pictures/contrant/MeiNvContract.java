package com.example.administrator.yilan000.ui.pictures.contrant;

import com.example.administrator.yilan000.bean.MeiNvGson;

import java.util.List;

/**
 *
 * 头条契约类
 */

public interface MeiNvContract {


    interface View{
        void returnData(List<MeiNvGson.NewslistBean> datas);
    }

    interface OnLoadFirstDataListener{
        void  onSuccess(List<MeiNvGson.NewslistBean> list);
        void  onFailure(String str, Exception e);
    }

    interface Presenter  {
        void loadData( int page);
    }

    interface Model {
        void loadData(OnLoadFirstDataListener listener, int page);
    }
}
