package com.roy.v2exapp.ui.view.topics;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.roy.v2exapp.R;
import com.roy.v2exapp.beans.NewTopicsPOJO;
import com.roy.v2exapp.beans.POJO;
import com.roy.v2exapp.ui.view.Adapter;
import com.roy.v2exapp.utils.TimeUtil;

/**
 * Created by roy on 17-7-30.
 */

public class TopicsAdapter extends RecyclerView.Adapter<TopicsViewHolder> implements Adapter {

    private NewTopicsPOJO[] newTopics;
    private Fragment fragment;

    public TopicsAdapter(Fragment fragment, NewTopicsPOJO[] newTopics) {
        this.fragment = fragment;
        this.newTopics = newTopics;
    }

    @Override
    public TopicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topics_item, parent, false);
        TopicsViewHolder holder = new TopicsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TopicsViewHolder holder, int position) {
        holder.name.setText(newTopics[position].getMemberPOJO().getUsername());
        holder.title.setText(newTopics[position].getTitle());
        //holder.content.setText(newTopics[position].getContent());
        holder.node.setText(newTopics[position].getNodePOJO().getTitle());
        holder.reply.setText(TimeUtil.getTimeDifference(newTopics[position].getLastTouched()));
        Glide.with(fragment)
                .load(newTopics[position].getMemberPOJO()
                .getAvatarNormal())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return newTopics.length;
    }

    @Override
    public void update(POJO[] pojos) {
        this.newTopics = (NewTopicsPOJO[]) pojos;
    }

}
