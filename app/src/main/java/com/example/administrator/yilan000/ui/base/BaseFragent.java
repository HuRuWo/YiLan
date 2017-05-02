package com.example.administrator.yilan000.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/10/24.
 */

public  class BaseFragent extends Fragment {



        @Override
        public void onAttach(Activity activity) {
            // TODO Auto-generated method stub
            Log.e("HJJ", "ArrayListFragment **** onAttach...");
            super.onAttach(activity);
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            Log.e("HJJ", "ArrayListFragment **** onCreate...");
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            Log.e("HJJ", "ArrayListFragment **** onCreateView...");
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.e("HJJ", "ArrayListFragment **** onActivityCreated...");
        }

        @Override
        public void onStart() {
            // TODO Auto-generated method stub
            Log.e("HJJ", "ArrayListFragment **** onStart...");
            super.onStart();
        }

        @Override
        public void onResume() {
            Log.e("HJJ", "ArrayListFragment **** onResume...");
            // TODO Auto-generated method stub
            super.onResume();
        }

        @Override
        public void onPause() {
            Log.e("HJJ", "ArrayListFragment **** onPause...");
            // TODO Auto-generated method stub
            super.onPause();
        }

        @Override
        public void onStop() {
            Log.e("HJJ", "ArrayListFragment **** onStop...");
            // TODO Auto-generated method stub
            super.onStop();
        }

        @Override
        public void onDestroyView() {
            Log.e("HJJ", "ArrayListFragment **** onDestroyView...");
            // TODO Auto-generated method stub
            super.onDestroyView();
        }

        @Override
        public void onDestroy() {
            // TODO Auto-generated method stub
            Log.e("HJJ", "ArrayListFragment **** onDestroy...");
            super.onDestroy();
        }

        @Override
        public void onDetach() {
            Log.e("HJJ", "ArrayListFragment **** onDetach...");
            // TODO Auto-generated method stub
            super.onDetach();
        }

}
