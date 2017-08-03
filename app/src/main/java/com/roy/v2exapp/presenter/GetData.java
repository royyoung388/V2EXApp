package com.roy.v2exapp.presenter;

/**
 * Created by roy on 17-8-1.
 * presenter层实现,用于调用model层的接口方法
 */

public interface GetData {

    /**
     * 获取最新主题
     */
    void getNewTopics();

    /**
     * 获取最热主题
     */
    void getHotTopics();

    /**
     * 获取主题
     * @param id 主题id
     */
    void getTopicsById(int id);

    /**
     * 获取主题
     * @param id 节点id
     */
    void getTopicsByNodeId(int id);

    /**
     * 获取主题
     * @param username 用户name
     */
    void getTopicsByUserName(String username);

    /**
     * 获取主题
     * @param name 节点name
     */
    void getTopicsByNodeName(String name);

    /**
     * 获取用户信息
     * @param username 用户名
     */
    void getMember(String username);

    /**
     * 获取回复
     * @param topicId 主题id
     *
     */
    void getTopicReplies(int topicId);

    /**
     * 获取所有节点
     */
    void getAllNodes();

    /**
     * 获取节点
     * @param nodeId 节点id
     */
    void getNodesById(int nodeId);

    /**
     * 获取节点
     * @param nodeName 节点name
     */
    void getNodesByName(String nodeName);
}
