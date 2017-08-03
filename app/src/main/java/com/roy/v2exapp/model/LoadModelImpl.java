package com.roy.v2exapp.model;

import android.util.Log;

import com.roy.v2exapp.model.loadmodels.LoadAllNodes;
import com.roy.v2exapp.model.loadmodels.LoadHotTopics;
import com.roy.v2exapp.model.loadmodels.LoadMember;
import com.roy.v2exapp.model.loadmodels.LoadNewTopics;
import com.roy.v2exapp.model.loadmodels.LoadTopicsById;
import com.roy.v2exapp.model.loadmodels.LoadTopicReplies;
import com.roy.v2exapp.model.loadmodels.LoadTopicsByNodeId;
import com.roy.v2exapp.model.loadmodels.LoadTopicsByUsername;
import com.roy.v2exapp.presenter.OnModelFinish;

/**
 * Created by roy on 17-8-1.
 */

public class LoadModelImpl implements LoadModel {

    /**
     * 获取最新主题
     *
     * @param onFinish
     */
    @Override
    public void loadNewTopics(OnModelFinish onFinish) {
        Log.i("------LoadModelImpl", "load new topics");
        new LoadNewTopics(onFinish).start();
    }

    /**
     * 获取最热主题
     *
     * @param onFinish
     */
    @Override
    public void loadHotTopics(OnModelFinish onFinish) {
        Log.i("------LoadModelImpl", "load hot topics");
        new LoadHotTopics(onFinish).start();
    }

    /**
     * 获取主题
     *
     * @param onFinish
     * @param id       主题id
     */
    @Override
    public void loadTopicById(OnModelFinish onFinish, int id) {
        Log.i("------LoadModelImpl", "load topics by id");
        new LoadTopicsById(onFinish, id).start();
    }

    /**
     * 获取主题
     *
     * @param onFinish
     * @param id       节点id
     */
    @Override
    public void loadTopicsByNodeId(OnModelFinish onFinish, int id) {
        Log.i("------LoadModelImpl", "load topics by node id");
        new LoadTopicsByNodeId(onFinish, id).start();
    }

    /**
     * 获取主题
     *
     * @param onFinish
     * @param username 用户name
     */
    @Override
    public void loadTopicsByUserName(OnModelFinish onFinish, String username) {
        Log.i("------LoadModelImpl", "load topics by username");
        new LoadTopicsByUsername(onFinish, username).start();
    }

    /**
     * 获取主题
     *
     * @param onFinish
     * @param name     节点name
     */
    @Override
    public void loadTopicsByNodesName(OnModelFinish onFinish, String name) {

    }

    /**
     * 获取用户信息
     *
     * @param onFinish
     * @param username 用户名
     */
    @Override
    public void loadMember(OnModelFinish onFinish, String username) {
        Log.i("------LoadModelImpl", "load member");
        new LoadMember(onFinish, username).start();
    }

    /**
     * 获取回复
     *
     * @param onFinish
     * @param topicId  主题id
     */
    @Override
    public void loadTopicReplies(OnModelFinish onFinish, int topicId) {
        Log.i("------LoadModelImpl", "load topic replies");
        new LoadTopicReplies(onFinish, topicId).start();
    }

    /**
     * 获取所有节点
     *
     * @param onFinish
     */
    @Override
    public void loadAllNodes(OnModelFinish onFinish) {
        Log.i("------LoadModelImpl", "load all nodes");
        new LoadAllNodes(onFinish).start();
    }

    /**
     * 获取节点
     *
     * @param onFinish
     * @param nodeId   节点id
     */
    @Override
    public void loadNodesById(OnModelFinish onFinish, int nodeId) {

    }

    /**
     * 获取节点
     *
     * @param onFinish
     * @param nodeName 节点name
     */
    @Override
    public void loadNodesByName(OnModelFinish onFinish, String nodeName) {

    }
}
