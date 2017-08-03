package com.roy.v2exapp.presenter;

import android.util.Log;
import android.widget.Toast;

import com.roy.v2exapp.model.LoadModel;
import com.roy.v2exapp.model.LoadModelImpl;
import com.roy.v2exapp.beans.POJO;
import com.roy.v2exapp.ui.activity.activityView;
import com.roy.v2exapp.utils.Info;

/**
 * Created by roy on 17-8-1.
 */

public class V2EXPresenter implements OnModelFinish, GetModel{

    private activityView view;
    private LoadModel loadModel;

    //持有model和view的引用
    public V2EXPresenter(activityView view) {
        this.view = view;
        loadModel = new LoadModelImpl();
    }

    @Override
    public void getNodes() {

    }

    @Override
    public void getModel(int type) {
        loadModel.LoadModel(this, type);
    }

    @Override
    public void OnSuccess(POJO[] POJOs, int loadType) {
        Log.i("PresenterOnsuccess", "success:" + loadType);
        switch (loadType) {
            case Info.LOAD_ALL_NODES:
                break;
            case Info.LOAD_HOT_NODES:
                view.setAdapter(POJOs, Info.LOAD_HOT_NODES);
                break;
            case Info.LOAD_NEW_TOPICS:
                view.setAdapter(POJOs, Info.LOAD_NEW_TOPICS);
                break;
        }
    }

    @Override
    public void OnFailed() {
        Log.i("PresenterOnFailed", "Failed");
        Toast.makeText(view.getContext(), "网络错误,刷新试试", Toast.LENGTH_SHORT).show();
    }
}
