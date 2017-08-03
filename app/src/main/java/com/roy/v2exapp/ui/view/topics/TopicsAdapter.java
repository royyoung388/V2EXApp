package com.roy.v2exapp.ui.view.topics;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.roy.v2exapp.R;
import com.roy.v2exapp.beans.TopicPOJO;
import com.roy.v2exapp.beans.POJO;
import com.roy.v2exapp.ui.view.Adapter;
import com.roy.v2exapp.utils.TimeUtil;

/**
 * Created by roy on 17-7-30.
 */

public class TopicsAdapter extends RecyclerView.Adapter<TopicsViewHolder> implements Adapter {

    private TopicPOJO[] newTopics;
    private Fragment fragment;
    private Context context;

    private OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onTitleClick(int topicId);
        void onNodeClick(int nodeId);
        void onMemberClick(String username);
        void onNameClick(String username);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public TopicsAdapter(Fragment fragment, TopicPOJO[] newTopics) {
        this.fragment = fragment;
        this.newTopics = newTopics;
    }

    public TopicsAdapter(Context context, TopicPOJO[] newTopics) {
        this.context = context;
        this.newTopics = newTopics;
    }

    @Override
    public TopicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topics_item, parent, false);
        TopicsViewHolder holder = new TopicsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TopicsViewHolder holder, final int position) {
        holder.name.setText(newTopics[position].getMemberPOJO().getUsername());
        holder.title.setText(newTopics[position].getTitle());
        //holder.content.setText(newTopics[position].getContent());
        holder.node.setText(newTopics[position].getNodePOJO().getTitle());
        holder.reply.setText(TimeUtil.getTimeDifference(newTopics[position].getLastTouched()));

        Glide.with(fragment == null ? context : fragment.getActivity())
                //.with(context)
                .load(newTopics[position].getMemberPOJO().getAvatarNormal())
                .into(holder.img);

        if (clickListener == null)
            return;

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onTitleClick(newTopics[position].getId());
            }
        });
        holder.node.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onNodeClick(newTopics[position].getNodePOJO().getId());

            }
        });
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onMemberClick(newTopics[position].getMemberPOJO().getUsername());
            }
        });
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onNameClick(newTopics[position].getMemberPOJO().getUsername());
            }
        });
    }

    @Override
    public int getItemCount() {
        return newTopics.length;
    }

    @Override
    public void update(POJO[] pojos) {
        this.newTopics = (TopicPOJO[]) pojos;
    }

}
