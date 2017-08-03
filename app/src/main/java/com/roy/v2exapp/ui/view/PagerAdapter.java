package com.roy.v2exapp.ui.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.roy.v2exapp.ui.fragment.HotTopicsFragment;
import com.roy.v2exapp.ui.fragment.NewTopicsFragment;

/**
 * Created by roy on 17-8-2.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    //public static final String[] TITLE = new String[]{"最新主题", "最热主题", "所有节点"};
    public static final String[] TITLE = new String[]{"最新主题", "最热主题"};

    public NewTopicsFragment newTopicsFragment;
    public HotTopicsFragment hotTopicsFragment;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (newTopicsFragment == null)
                    newTopicsFragment = new NewTopicsFragment();
                return newTopicsFragment;
            case 1:
                if (hotTopicsFragment == null)
                    hotTopicsFragment = new HotTopicsFragment();
                return hotTopicsFragment;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int positon) {
        return TITLE[positon % TITLE.length];
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }
}
