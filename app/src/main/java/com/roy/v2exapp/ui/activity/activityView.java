package com.roy.v2exapp.ui.activity;

import android.content.Context;

import com.roy.v2exapp.beans.POJO;

/**
 * Created by roy on 17-8-1.
 * view层的方法,presenter层调用
 */

public interface activityView {
    /**
     * 设置Adapter
     * @param POJOs
     * @param adapterType
     */
    void setAdapter(POJO[] POJOs, int adapterType);
    Context getContext();
    void getModel(int type);
}
