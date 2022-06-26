/*
package com.example.myapplication;

import static com.alibaba.fastjson.JSON.parseObject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

import javax.net.ssl.HttpsURLConnection;

public class MojangHttps implements Callable<Void> {

    Activity activity;
    String name;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    private Consumer<MojangHttps> onOver;


    public MojangHttps(Activity activity, String name, Consumer<MojangHttps> onOver) {
        this.activity = activity;
        this.name = name;
        this.onOver = onOver;
    }

    public String GetName() {

        String input_name = name;
        name = String.format("https://api.mojang.com/users/profiles/minecraft/%s", input_name);
        return name;

    }


    @Override
    public Void call() {
        GetName();
        sp = activity.getSharedPreferences("api_data", 0);
        editor = sp.edit();

        BufferedReader in = null;
        HttpsURLConnection mojang = null;

        try {
            URL url = new URL(name);
            mojang = (HttpsURLConnection) url.openConnection();
            mojang.addRequestProperty("User-Agent", "Mozilla/4.0");
            mojang.setRequestMethod("GET");
            mojang.setReadTimeout(5000);

            if (mojang.getResponseCode() == 200) {
                InputStream inputStream = mojang.getInputStream();

                in = new BufferedReader(new InputStreamReader(inputStream));
                String inputLine;
                StringBuilder sb = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    sb.append(inputLine).append("\n");
                }

                String uuid = JSON.parseObject(String.valueOf(sb)).getString("id");
                editor.putString("uuid",uuid);
                editor.commit();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, "查找uuid成功!正在查询Hypixel api", Toast.LENGTH_SHORT).show();
                    }
                });
                onOver.accept(this);
                return null;
            }if(mojang.getResponseCode() == 204) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, "找不到对应uuid!请检查用户名是否输入正确", Toast.LENGTH_SHORT).show();
                    }
                });
                return null;
            }if (mojang.getResponseCode() == 400){
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, "出现错误请重试", Toast.LENGTH_SHORT).show();
                    }
                });
                return null;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ignored) {
                }
            }
            if (mojang != null) {
                mojang.disconnect();
            }
        }
    }
}
*/