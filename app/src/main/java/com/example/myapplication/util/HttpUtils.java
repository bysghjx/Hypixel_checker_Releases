package com.example.myapplication.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

public final class HttpUtils {
    public static HttpResult get(String url) {
        try {
            URL u = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) u.openConnection();
            conn.addRequestProperty("User-Agent", "Mozilla/4.0");
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);

            int code = conn.getResponseCode();
            if (code == 200) {
                 return new HttpResult(conn.getResponseCode(), new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)));
            }

            if (code >= 400) {
                return new HttpResult(conn.getResponseCode(), new BufferedReader(new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8)));
            }

            return new HttpResult(conn.getResponseCode(), null);
        } catch (IOException ex) {
            HttpResult result = new HttpResult(-1, null);
            result.setContent(ex.getMessage());
            return result;
        }
    }

    private HttpUtils() {
    }
}
