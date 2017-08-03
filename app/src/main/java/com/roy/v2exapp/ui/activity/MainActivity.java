package com.roy.v2exapp.ui.activity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.roy.v2exapp.R;
import com.roy.v2exapp.beans.POJO;
import com.roy.v2exapp.presenter.Presenter;
import com.roy.v2exapp.ui.view.PagerAdapter;
import com.roy.v2exapp.utils.Info;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends ActivityViewAdapter {

    private Presenter presenter = new Presenter(this);

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
    public void onFailed(int type) {
        //Toast.makeText(this, "网络错误,刷新试试", Toast.LENGTH_SHORT).show();
        switch (type) {
            case Info.LOAD_ALL_NODES:
                pagerAdapter.allNodesFragment.onFailed();
                break;
            case Info.LOAD_HOT_TOPICS:
                pagerAdapter.hotTopicsFragment.onFailed();
                break;
            case Info.LOAD_NEW_TOPICS:
                pagerAdapter.newTopicsFragment.onFailed();
                break;
        }
    }

    @Override
    public void setData(POJO[] POJOs, int dataType) {
        switch (dataType) {
            case Info.LOAD_ALL_NODES:
                pagerAdapter.allNodesFragment.setAdapter(POJOs);
                break;
            case Info.LOAD_HOT_TOPICS:
                pagerAdapter.hotTopicsFragment.setAdapter(POJOs);
                break;
            case Info.LOAD_NEW_TOPICS:
                pagerAdapter.newTopicsFragment.setAdapter(POJOs);
                break;
        }
    }

    @Override
    public void getNewTopics() {
        presenter.getNewTopics();
    }

    @Override
    public void getHotTopics() {
        presenter.getHotTopics();
    }

    @Override
    public void getAllNodes() {
        presenter.getAllNodes();
    }
}
