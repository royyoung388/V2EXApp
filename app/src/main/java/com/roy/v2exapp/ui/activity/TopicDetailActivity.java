package com.roy.v2exapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.roy.v2exapp.R;
import com.roy.v2exapp.beans.POJO;
import com.roy.v2exapp.beans.ReplyPOJO;
import com.roy.v2exapp.beans.TopicPOJO;
import com.roy.v2exapp.presenter.Presenter;
import com.roy.v2exapp.ui.view.replies.RepliesAdapter;
import com.roy.v2exapp.utils.Info;
import com.roy.v2exapp.utils.TimeUtil;
import com.zzhoujay.richtext.RichText;

import java.util.Arrays;

/**
 * Created by roy on 17-8-2.
 */

public class TopicDetailActivity extends ActivityViewAdapter {

    private Presenter presenter = new Presenter(this);

    private TextView title, name, reply, create, content;
    private RecyclerView recycler;
    private NestedScrollView scrollView;
    private RepliesAdapter adapter = new RepliesAdapter(this, new ReplyPOJO[]{});

    private ReplyPOJO[] replies;
    private int scrollPage = 1;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch ( msg.what) {
                case 0:
                    //设置主题信息
                    setTopicView((TopicPOJO) msg.obj);
                    break;
                case 1:
                    //设置回复信息
                    //刷新recyclerview
                    Log.i("--TopicDetailActivity", "adapter notify item inserted");
                    if (replies.length == 0 || replies == null) {
                        adapter.notifyItemInserted(0);
                        break;
                    }
                    adapter.notifyItemRangeInserted((scrollPage - 1) * 10,
                            scrollPage * 10 > replies.length ? replies.length % 10 : 10);
                    //adapter.notifyDataSetChanged();
                    break;
                case 2:
                    //onFailed
                    Toast.makeText(TopicDetailActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_detail);

        initView();
        initRecycler();

        int id = getIntent().getIntExtra("topic_id", 0);
        Log.i("--TopicDetailActivity", "get topic id " + id);
        getTopicsById(id);
        getTopicReplies(id);
    }

    @Override
    public void getTopicReplies(int topicId) {
        Log.i("--TopicDetailActivity", "get replies: id " + topicId);
        presenter.getTopicReplies(topicId);
    }

    @Override
    public void getTopicsById(int id) {
        Log.i("--TopicDetailActivity", "get topics by id" + id);
        presenter.getTopicsById(id);
    }

    private void initRecycler() {
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
        //解决嵌套scrollview滚动冲突
        recycler.setNestedScrollingEnabled(false);

        adapter.setOnReplyClickListener(new RepliesAdapter.OnReplyClickListener() {
            @Override
            public void OnImgClick(String username) {
                Intent intent = new Intent(TopicDetailActivity.this, MemberActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }

            @Override
            public void OnNameClick(String username) {
                Intent intent = new Intent(TopicDetailActivity.this, MemberActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setData(POJO[] POJOs, int dataType) {
        Log.i("--TopicDetailActivity", "Onsuccess:" + dataType);

        switch (dataType) {
            case Info.LOAD_TOPIC_By_Id:
                Message msg = new Message();
                msg.obj = (TopicPOJO) POJOs[0];
                msg.what = 0;
                handler.sendMessage(msg);
                break;
            case Info.LOAD_TOPIC_REPLIES:
                replies = (ReplyPOJO[]) POJOs;
                Log.i("----TopicDetailActivity", "get replies success, lenth " + replies.length);
                if (replies.length == 0 || replies == null || replies[0] == null) {
                    adapter.update(new ReplyPOJO[]{null});
                } else {
                    adapter.update(Arrays.copyOfRange(POJOs, 0, 10 * scrollPage >= replies.length ? replies.length : 10 * scrollPage));
                }

                handler.sendEmptyMessage(1);
                break;
        }
    }

    @Override
    public void onFailed(int type) {
        //Toast.makeText(this, "网络错误,刷新试试", Toast.LENGTH_SHORT).show();
        handler.sendEmptyMessage(2);
    }

    private void initView() {
        title = myFindView(R.id.topic_detail_title);
        name = myFindView(R.id.topic_detail_name);
        reply = myFindView(R.id.topic_detail_reply);
        create = myFindView(R.id.topic_detail_create);
        content = myFindView(R.id.topic_detail_content);
        recycler = myFindView(R.id.topic_detail_recycler);
        scrollView = myFindView(R.id.topic_detail_scroll);

        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    // 向下滑动
                }

                if (scrollY < oldScrollY) {
                    // 向上滑动
                }

                if (scrollY == 0) {
                    // 顶部
                }

                if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    // 底部
                    Log.i("--TopicDetailActivity", "current scroll page " + scrollPage);
                    if (scrollPage * 10 >= replies.length)
                        return;
                    scrollPage++;
                    adapter.update(Arrays.copyOfRange(replies, 0, 10 * scrollPage >= replies.length ? replies.length : 10 * scrollPage));
                    handler.sendEmptyMessage(1);
                }
            }
        });
//
//        scrollView.setScrollBottomListener(new BottomScrollView.ScrollBottomListener() {
//            @Override
//            public void scrollBottom() {
//                Log.i("------TopicDetailActivity", "current scroll page " + scrollPage);
//                if (scrollPage *10 > replies.length)
//                    return;
//                scrollPage++;
//                adapter.update(Arrays.copyOfRange(replies, 0, 10 * scrollPage >= replies.length ? replies.length : 10 * scrollPage));
//                handler.sendEmptyMessage(1);
//            }
//        });
    }

    public void setTopicView(TopicPOJO topic) {
        title.setText(topic.getTitle());
        name.setText(topic.getMemberPOJO().getUsername());
        reply.setText(topic.getReplies() + "条回复");
        create.setText("发表于" + TimeUtil.getTimeDifference(topic.getLastModified()));
        RichText.fromMarkdown(topic.getContent()).into(content);
    }
}
