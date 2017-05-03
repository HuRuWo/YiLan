package com.example.administrator.yilan000.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yilan000.R;
import com.example.administrator.yilan000.ui.base.BaseFragent;
import com.example.administrator.yilan000.ui.base.TabPagerAdapter;
import com.example.administrator.yilan000.ui.news.fragment.NewsClassFragment;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/5/2.
 */

public class NewsFragment extends BaseFragent implements ViewPager.OnPageChangeListener{

    private Toolbar toolbar;
    private TabLayout mTabs;
    private ViewPager mViewPager;
    private FloatingActionButton fab;

    private String[] mTitles ;
    private NewsClassFragment[] mFragments;
    private TabPagerAdapter mAdapter;
    private int currentPosition = 0;


    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mTabs = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        mTitles = getResources().getStringArray(R.array.main_titles);

        mFragments = new NewsClassFragment[mTitles.length];
        for(int i=0;i<mFragments.length;i++){
            mFragments[i]=NewsClassFragment.newInstance(i);
        }

        mTabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        mAdapter = new TabPagerAdapter(getChildFragmentManager(), mFragments);
        mAdapter.setTabTitles(mTitles);
        mViewPager.setAdapter(mAdapter);
        mTabs.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(this);

        return view;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }




    @Override
    public void onResume() {
        super.onResume();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
