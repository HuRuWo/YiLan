package com.example.administrator.yilan000;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.administrator.yilan000.ui.base.BaseActivity;
import com.example.administrator.yilan000.ui.base.TabPagerAdapter;
import com.example.administrator.yilan000.ui.news.NewsFragment;
import com.example.administrator.yilan000.ui.pictures.fragment.MeiNvFragment;

import static com.example.administrator.yilan000.R.id.viewPager;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private ViewPager mViewPager;
    private String[] mTitles;
    private Fragment[] fragments;

    private TabPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTitles = getResources().getStringArray(R.array.main_titles);

        mViewPager = (ViewPager) findViewById(viewPager);


        fragments = new Fragment[2];


            fragments[0] =  NewsFragment.newInstance();
            fragments[1] =  MeiNvFragment.newInstance();


        mAdapter = new TabPagerAdapter(getSupportFragmentManager(), fragments);
        //mAdapter.setTabTitles(mTitles);
        mViewPager.setAdapter(mAdapter);
        //设置显示模式 滚动



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action


        } else if (id == R.id.nav_gallery) {
            Toast.makeText(getApplicationContext(),
                 "还在开发中O_O", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_slideshow) {
            // Handle the camera action


        } else if (id == R.id.nav_manage) {
            Toast.makeText(getApplicationContext(),
                    "还在开发中O_O", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(getApplicationContext(),
                    "还在开发中O_O", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(getApplicationContext(),
                    "还在开发中O_O", Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
