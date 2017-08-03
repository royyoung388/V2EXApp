package com.roy.v2exapp.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.roy.v2exapp.R;
import com.roy.v2exapp.beans.NewTopicsPOJO;
import com.roy.v2exapp.beans.POJO;
import com.roy.v2exapp.ui.activity.MainActivity;
import com.roy.v2exapp.ui.view.topics.TopicsAdapter;
import com.roy.v2exapp.utils.Info;

/**
 * Created by roy on 17-8-2.
 */

public class NewTopicsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, setAdapter {

    private View view;
    private SwipeRefreshLayout swipe;
    private RecyclerView recycler;
    private TopicsAdapter adapter = new TopicsAdapter(this, new NewTopicsPOJO[]{});

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    swipe.setRefreshing(false);
                    adapter.notifyDataSetChanged();
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_topice, container, false);
        initRecycler();
        initSwipe();
        //刷新一次,获取数据
        onRefresh();
        return view;
    }

    private void initRecycler() {
        recycler = (RecyclerView) view.findViewById(R.id.topics_item_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);

        //用于监听滑动
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Log.i("HotFragment", "Recycler Scroll SCROLL_STATE_IDLE");
                    Glide.with(NewTopicsFragment.this).resumeRequests();
                } else {
                    Log.i("HotFragment", "Recycler Scroll Resume");
                    Glide.with(NewTopicsFragment.this).pauseRequests();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void initSwipe() {
        swipe = (SwipeRefreshLayout) view.findViewById(R.id.topics_item_swipe);
        //下拉刷新
        swipe.setOnRefreshListener(this);
        //小圈圈的颜色。转一圈换一种颜色，每一圈耗时1s。
        swipe.setColorSchemeResources(R.color.red, R.color.green, R.color.blue, R.color.orange);
        swipe.setDistanceToTriggerSync(200);
        swipe.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getActivity(), R.color.white));
        swipe.setSize(SwipeRefreshLayout.DEFAULT);
    }

    @Override
    public void onRefresh() {
        swipe.setRefreshing(true);
        MainActivity activity = (MainActivity) getActivity();
        activity.getModel(Info.LOAD_NEW_TOPICS);
    }

    @Override
    public void setAdapter(POJO[] POJOs) {
        adapter.update(POJOs);
        handler.sendEmptyMessage(0);
    }
}
