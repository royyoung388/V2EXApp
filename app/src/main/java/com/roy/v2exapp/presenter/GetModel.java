package com.roy.v2exapp.presenter;

/**
 * Created by roy on 17-8-1.
 * presenter层实现,用于调用model层的接口方法
 */

public interface GetModel {
    /**
     * 获取节点信息
     */
    void getNodes();
    void getModel(int type);
}
