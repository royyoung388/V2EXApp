package com.roy.v2exapp.ui.view.topics;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.roy.v2exapp.R;

/**
 * Created by roy on 17-7-30.
 */

public class TopicsViewHolder extends RecyclerView.ViewHolder {

    public TextView content, name, reply, title, node;
    public ImageView img;

    public TopicsViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.topics_item_name);
        title = (TextView) itemView.findViewById(R.id.topics_item_title);
        //content = (TextView) itemView.findViewById(R.id.new_topics_item_content);
        node = (TextView) itemView.findViewById(R.id.topics_item_node);
        reply = (TextView) itemView.findViewById(R.id.topics_item_reply);
        img = (ImageView) itemView.findViewById(R.id.topics_item_img);
    }
}
