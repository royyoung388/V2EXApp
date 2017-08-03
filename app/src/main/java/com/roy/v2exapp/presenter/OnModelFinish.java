package com.roy.v2exapp.presenter;

import com.roy.v2exapp.beans.NodePOJO;
import com.roy.v2exapp.beans.POJO;

/**
 * Created by roy on 17-8-1.
 * 在presenter层实现,用于model层回调,修改view层数据,解耦view和model
 */

public interface OnModelFinish {
    /**
     * 成功时回调
     * @param POJOs
     * @param loadType
     */
    void OnSuccess(POJO[] POJOs, int loadType);

    /**
     * 失败时回调
     * @param type
     */
    void OnFailed(int type);
}
