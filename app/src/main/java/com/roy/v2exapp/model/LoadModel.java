package com.roy.v2exapp.model;

import com.roy.v2exapp.presenter.OnModelFinish;

/**
 * Created by roy on 17-8-1.
 * Model层实现,用于获取网络数据,presenter层调用
 */

public interface LoadModel {
    /**
     * 获取最新主题
     * @param onFinish
     */
    void loadNewTopics(OnModelFinish onFinish);

    /**
     * 获取最热主题
     * @param onFinish
     */
    void loadHotTopics(OnModelFinish onFinish);

    /**
     * 获取主题
     * @param onFinish
     * @param id 主题id
     */
    void loadTopicById(OnModelFinish onFinish, int id);

    /**
     * 获取主题
     * @param onFinish
     * @param id 节点id
     */
    void loadTopicsByNodeId(OnModelFinish onFinish, int id);

    /**
     * 获取主题
     * @param onFinish
     * @param username 用户name
     */
    void loadTopicsByUserName(OnModelFinish onFinish, String username);

    /**
     * 获取主题
     * @param onFinish
     * @param name 节点name
     */
    void loadTopicsByNodesName(OnModelFinish onFinish, String name);

    /**
     * 获取用户信息
     * @param onFinish
     * @param username 用户名
     */
    void loadMember(OnModelFinish onFinish, String username);

    /**
     * 获取回复
     * @param onFinish
     * @param topicId 主题id
     */
    void loadTopicReplies(OnModelFinish onFinish, int topicId);

    /**
     * 获取所有节点
     * @param onFinish
     */
    void loadAllNodes(OnModelFinish onFinish);

    /**
     * 获取节点
     * @param onFinish
     * @param nodeId 节点id
     */
    void loadNodesById(OnModelFinish onFinish, int nodeId);

    /**
     * 获取节点
     * @param onFinish
     * @param nodeName 节点name
     */
    void loadNodesByName(OnModelFinish onFinish, String nodeName);
}
