package com.roy.v2exapp.model;

import com.roy.v2exapp.model.loadmodels.LoadHotTopics;
import com.roy.v2exapp.model.loadmodels.LoadNewTopics;
import com.roy.v2exapp.presenter.OnModelFinish;
import com.roy.v2exapp.utils.Info;

/**
 * Created by roy on 17-8-1.
 */

public class LoadModelImpl implements LoadModel {
    @Override
    public void LoadModel(OnModelFinish onFinish, int loadType) {
        switch (loadType) {
            case Info.LOAD_HOT_NODES:
                //最热主题
                new LoadHotTopics(onFinish).start();
                break;
            case Info.LOAD_NEW_TOPICS:
                //最新主题
                new LoadNewTopics(onFinish).start();
                break;
            case Info.LOAD_ALL_NODES:
                break;
        }
    }
}
