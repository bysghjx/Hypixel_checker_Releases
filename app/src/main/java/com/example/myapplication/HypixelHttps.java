package com.example.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HypixelHttps extends Thread{
    String uuid;
    String api_key;
    String hyp_check;
    String P_data;
    String error;


    public HypixelHttps(String uuid, String api_key) {
        this.uuid = uuid;
        this.api_key = api_key;
    }

    public String getHyp_check(){
        hyp_check = String.format("https://api.hypixel.net/player?key=%s&uuid=%s",api_key,uuid);
        return hyp_check;
    }


    public String getP_data(){
        getHyp_check();


        try {
            URL url = new URL(hyp_check);
            HttpsURLConnection hyp = (HttpsURLConnection) url.openConnection();
            hyp.addRequestProperty("User-Agent", "Mozilla/4.0");
            hyp.setRequestMethod("GET");
            hyp.setReadTimeout(5000);

            if (hyp.getResponseCode() == 403){
                error = "访问被禁止，使用了无效的 API 密钥.";
                return error;
            }
            if (hyp.getResponseCode() == 400){
                error = "缺少某些数据，这通常是一个字段.";
                return error;
            }
            if(hyp.getResponseCode() == 429){
                error = "已达到请求限制，这通常是由于达到的密钥的限制，但也可能由全局限制触发。";
                return error;
            }

            if (hyp.getResponseCode() == 200){
                InputStream inputStream = hyp.getInputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(hyp.getInputStream()));
                String inputLine;
                StringBuilder sb = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    sb.append(inputLine);
                }
                in.close();
                P_data = JSON.parseObject(String.valueOf(sb)).getString("player");

                if(P_data == null){
                    error = "这人连hypixel都没进过!";
                    return error;
                }else {
                    Log.e("hyphttps","suss");
                    return P_data;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return P_data;
    }


    @Override
    public void run() {
        super.run();
        getP_data();

    }
}
