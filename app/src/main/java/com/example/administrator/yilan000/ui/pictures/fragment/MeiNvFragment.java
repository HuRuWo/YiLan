package com.example.administrator.yilan000.ui.pictures.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.yilan000.R;
import com.example.administrator.yilan000.bean.MeiNv;
import com.example.administrator.yilan000.bean.MeiNvGson;
import com.example.administrator.yilan000.constant.AppConfig;
import com.example.administrator.yilan000.retrofit.ApiService;
import com.example.administrator.yilan000.ui.base.BaseFragent;
import com.example.administrator.yilan000.ui.pictures.PictureDescribeActivity;
import com.example.administrator.yilan000.ui.pictures.adapter.ImageAdapter;
import com.example.administrator.yilan000.util.PixUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/10/24.
 */

public class MeiNvFragment extends BaseFragent {
    private ImageAdapter adapter;
    private int page = 0;


    public static MeiNvFragment newInstance() {
        MeiNvFragment fragment = new MeiNvFragment();
        return fragment;
    }
    @BindView(R.id.recyclerView)
    EasyRecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.meizi_fragment, container, false);

        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter = new ImageAdapter(getActivity()));
        //添加边框
        SpaceDecoration itemDecoration = new SpaceDecoration((int) PixUtil.convertDpToPixel(10, getContext()));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);


        //更多加载
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                addData();
            }

            @Override
            public void onMoreClick() {

            }
        });

        //写刷新事件
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page=0;
                        adapter.clear();
                        addData();
                    }
                }, 1000);
            }
        });

        //点击事件
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ArrayList<String> data = new ArrayList<String>();
                data.add(adapter.getAllData().get(position).getPicUrl());
                data.add(adapter.getAllData().get(position).getUrl());
                Intent intent = new Intent(getActivity(), PictureDescribeActivity.class);
                //用Bundle携带数据
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("data", data);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        addData();


        return view;
    }

    private void addData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com/")
                .addConverterFactory(GsonConverterFactory.create())//添加 json 转换器
                //    compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加 RxJava 适配器
                .build();
        ApiService apiManager = retrofit.create(ApiService.class);//这里采用的是Java的动态代理模式
        apiManager.getPictureData(AppConfig.APIKEY, "10", page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<MeiNvGson, List<MeiNv>>() {
                    @Override
                    public List<MeiNv> call(MeiNvGson newsgson) { //
                        List<MeiNv> meiNvList = new ArrayList<MeiNv>();
                        for (MeiNvGson.NewslistBean newslistBean : newsgson.getNewslist()) {
                            MeiNv m1 = new MeiNv();
                            m1.setTitle(newslistBean.getTitle());
                            m1.setCtime(newslistBean.getCtime());
                            m1.setDescription(newslistBean.getDescription());
                            m1.setPicUrl(newslistBean.getPicUrl());
                            m1.setUrl(newslistBean.getUrl());
                            meiNvList.add(m1);
                        }
                        return meiNvList; // 返回类型
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<MeiNv>>() {
                    @Override
                    public void onNext(List<MeiNv> meiNvList) {
                        adapter.addAll(meiNvList);
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getContext(),
                                "网络连接失败", Toast.LENGTH_LONG).show();
                    }
                });
        page=page+1;
    }


}
