package com.roy.v2exapp.model.loadmodels;

import android.util.Log;

import com.google.gson.Gson;
import com.roy.v2exapp.beans.NewTopicsPOJO;
import com.roy.v2exapp.presenter.OnModelFinish;
import com.roy.v2exapp.utils.Info;
import com.roy.v2exapp.utils.StreamReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by roy on 17-8-1.
 * 获取最新主题
 */

public class LoadNewTopics extends Thread{

    private OnModelFinish onFinish;

    public LoadNewTopics(OnModelFinish onFinish) {
        this.onFinish = onFinish;
    }

    @Override
    public void run() {
        try {
            URL url = new URL("https://www.v2ex.com/api/topics/latest.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(3000);
            conn.setUseCaches(false);

            String json = null;
            if (conn.getResponseCode() == 200) {
                json = StreamReader.stream2String(conn.getInputStream());
            }

            if (json == null) {
                return;
            }

            Gson gson = new Gson();
            NewTopicsPOJO newTopics[] = gson.fromJson(json, NewTopicsPOJO[].class);

            //接口回调
            if (newTopics == null) {
                onFinish.OnFailed();
            } else {
                onFinish.OnSuccess(newTopics, Info.LOAD_NEW_TOPICS);
            }
            Log.i("LoadNewTopics", "Loaded New Topics");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
