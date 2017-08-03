package com.roy.v2exapp.model;

import com.roy.v2exapp.presenter.OnModelFinish;

/**
 * Created by roy on 17-8-1.
 * Model层实现,用于获取网络数据,presenter层调用
 */

public interface LoadModel {
    /**
     * 获取所有节点信息
     */
    void LoadModel(OnModelFinish onFinish, int loadType);
}
