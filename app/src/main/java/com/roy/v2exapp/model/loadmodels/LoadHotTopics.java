package com.roy.v2exapp.model.loadmodels;

import android.util.Log;

import com.google.gson.Gson;
import com.roy.v2exapp.beans.TopicPOJO;
import com.roy.v2exapp.presenter.OnModelFinish;
import com.roy.v2exapp.utils.Info;
import com.roy.v2exapp.utils.StreamReader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by roy on 17-8-2.
 */

public class LoadHotTopics extends Thread{

    private OnModelFinish onFinish;

    public LoadHotTopics(OnModelFinish onFinish) {
        this.onFinish = onFinish;
    }

    @Override
    public void run() {
        try {
            URL url = new URL("https://www.v2ex.com/api/topics/hot.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(3000);

            String json = null;
            if (conn.getResponseCode() == 200) {
                json = StreamReader.stream2String(conn.getInputStream());
            }

            if (json == null || json.equals("")) {
                onFinish.OnFailed(Info.LOAD_TOPIC_REPLIES);
            }

            Gson gson = new Gson();
            TopicPOJO hotTopics[] = gson.fromJson(json, TopicPOJO[].class);

            //接口回调
            if (hotTopics == null) {
                onFinish.OnFailed(Info.LOAD_TOPIC_REPLIES);
            } else {
                Log.i("LoadHotTopics", "Loaded Hot Topics");
                onFinish.OnSuccess(hotTopics, Info.LOAD_HOT_TOPICS);
            }

            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
