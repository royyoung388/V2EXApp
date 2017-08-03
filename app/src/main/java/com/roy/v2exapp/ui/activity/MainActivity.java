package com.roy.v2exapp.ui.activity;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.roy.v2exapp.R;
import com.roy.v2exapp.beans.POJO;
import com.roy.v2exapp.presenter.V2EXPresenter;
import com.roy.v2exapp.ui.view.PagerAdapter;
import com.roy.v2exapp.utils.Info;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends AppCompatActivity implements activityView {

    private V2EXPresenter presenter = new V2EXPresenter(this);

    private ViewPager mViewPager;
    private TabPageIndicator indicator;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        initViewPager();
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.main_pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        indicator = (TabPageIndicator) findViewById(R.id.main_indicator);
        indicator.setViewPager(mViewPager);
    }

    private void initToolBar() {
        Toolbar toolBar = (Toolbar) findViewById(R.id.main_toobar);
        setSupportActionBar(toolBar);
        toolBar.setTitle("V2EX");
    }

    @Override
    public void setAdapter(POJO[] POJOs, int adapterType) {
        switch (adapterType) {
            case Info.LOAD_ALL_NODES:
                break;
            case Info.LOAD_HOT_NODES:
                pagerAdapter.hotTopicsFragment.setAdapter(POJOs);
                break;
            case Info.LOAD_NEW_TOPICS:
                pagerAdapter.newTopicsFragment.setAdapter(POJOs);
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void getModel(int type) {
        //加载数据
        presenter.getModel(type);
    }
}
