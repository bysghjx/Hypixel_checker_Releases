package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.hypixel.HypixelBedWarsInfo;
import com.example.myapplication.hypixel.HypixelDuelInfo;
import com.example.myapplication.hypixel.HypixelMurderMysteryInfo;
import com.example.myapplication.hypixel.HypixelPlayerInfo;
import com.example.myapplication.hypixel.HypixelSkyWarsInfo;
import com.example.myapplication.hypixel.HypixelUHCInfo;
import com.example.myapplication.query.HypixelBedwarsQuery;
import com.example.myapplication.query.HypixelDuelQuery;
import com.example.myapplication.query.HypixelMurderMysteryQuery;
import com.example.myapplication.query.HypixelPlayerQuery;
import com.example.myapplication.query.HypixelSkyWarsQuery;
import com.example.myapplication.query.HypixelUHCQuery;
import com.example.myapplication.util.HypixelUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainActivity7 extends AppCompatActivity {



    Button query, button_se,resetkey;
    EditText editText;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    String input_name;
    String uuid;
    String api_key;
    String api;
    public static HypixelPlayerInfo lastQueriedPlayer;
    public static HypixelBedWarsInfo lastQueriedBedwars;
    public static HypixelSkyWarsInfo lastQueriedSkywars;
    public static HypixelDuelInfo lastQueriedDuels;
    public static HypixelMurderMysteryInfo lastQueriedMm;
    public static HypixelUHCInfo lastQueriedUHC;
    public static String select = "player";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> list = new ArrayList<>(Arrays.asList("1",
                "2", "3", "4"));

        setContentView(R.layout.activity_main7);



        resetkey = findViewById(R.id.btn_reset);
        button_se = findViewById(R.id.select);
        editText = findViewById(R.id.mc_name);
        query = findViewById(R.id.button6);


        sp = getSharedPreferences("api_data", MODE_PRIVATE);
        editor = sp.edit();

        uuid = sp.getString("uuid", null);
        api_key = sp.getString("api_key", null);
        api = api_key;
        HypixelUtils.setApiKey(api);

        resetkey.setOnClickListener(v ->{
            editor.remove("api_key");
            editor.commit();
            Intent intent = new Intent(MainActivity7.this,MainActivity6.class);
            startActivity(intent);
        });

        button_se.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity7.this,MainActivity3.class);
            startActivity(intent);
        });


        query.setOnClickListener(v -> {
            String name = editText.getText().toString();
            input_name = name;

            if (TextUtils.isEmpty(name)) {
                Toast.makeText(MainActivity7.this, "name不能为空", Toast.LENGTH_SHORT).show();
            } else {
                if(select == null){
                    select = "player";
                }
                switch (select){

                    case "player":
                        FutureTask<HypixelPlayerInfo> var0 = new FutureTask<>(new HypixelPlayerQuery(input_name, s ->
                                Toast.makeText(MainActivity7.this, s, Toast.LENGTH_SHORT).show()
                        ));
                        new Thread(var0).start();

                        new Thread(() -> {
                            try {
                                MainActivity7.this.runOnUiThread(() -> {
                                    //进度条
                                    query.setEnabled(false);
                                    button_se.setEnabled(false);
                                    resetkey.setEnabled(false);
                                });

                                HypixelPlayerInfo pi = var0.get();
                                MainActivity7.this.runOnUiThread(() -> {
                                    button_se.setEnabled(true);
                                    resetkey.setEnabled(true);
                                    query.setEnabled(true);
                                    Intent intent = new Intent(MainActivity7.this, MainActivity.class);
                                    lastQueriedPlayer = pi;
                                    startActivity(intent);
                                });
                            } catch (ExecutionException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }).start();
                        break;

                    case "bw":
                        FutureTask<HypixelBedWarsInfo> var1 = new FutureTask<>(new HypixelBedwarsQuery(input_name, s ->
                                Toast.makeText(MainActivity7.this, s, Toast.LENGTH_SHORT).show()
                        ));
                        new Thread(var1).start();

                        new Thread(() -> {
                            try {
                                MainActivity7.this.runOnUiThread(() -> {
                                    //进度条
                                    query.setEnabled(false);
                                    button_se.setEnabled(false);
                                    resetkey.setEnabled(false);
                                });

                                HypixelBedWarsInfo bi = var1.get();
                                Log.i("bi",bi.toString());
                                MainActivity7.this.runOnUiThread(() -> {
                                    Intent intent = new Intent(MainActivity7.this, MainActivity.class);
                                    lastQueriedBedwars = bi;
                                    startActivity(intent);
                                });
                            } catch (ExecutionException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }).start();
                        break;

                    case "SkyWars" : {
                        FutureTask<HypixelSkyWarsInfo> var2 = new FutureTask<>(new HypixelSkyWarsQuery(input_name, s ->
                                Toast.makeText(MainActivity7.this, s, Toast.LENGTH_SHORT).show()
                        ));
                        new Thread(var2).start();

                        new Thread(() -> {
                            try {
                                MainActivity7.this.runOnUiThread(() -> {
                                    //进度条
                                    query.setEnabled(false);
                                    button_se.setEnabled(false);
                                    resetkey.setEnabled(false);
                                });

                                HypixelSkyWarsInfo si = var2.get();
                                Log.i("si",si.toString());
                                MainActivity7.this.runOnUiThread(() -> {
                                    Intent intent = new Intent(MainActivity7.this, MainActivity.class);
                                    lastQueriedSkywars = si;
                                    startActivity(intent);
                                });
                            } catch (ExecutionException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }).start();
                        break;
                    }

                    case "Duel":{
                        FutureTask<HypixelDuelInfo> var3 = new FutureTask<>(new HypixelDuelQuery(input_name, s ->
                                Toast.makeText(MainActivity7.this, s, Toast.LENGTH_SHORT).show()
                        ));
                        new Thread(var3).start();

                        new Thread(() -> {
                            try {
                                MainActivity7.this.runOnUiThread(() -> {
                                    //进度条
                                    query.setEnabled(false);
                                    button_se.setEnabled(false);
                                    resetkey.setEnabled(false);
                                });

                                HypixelDuelInfo di = var3.get();
                                Log.i("di",di.toString());
                                MainActivity7.this.runOnUiThread(() -> {
                                    Intent intent = new Intent(MainActivity7.this, MainActivity.class);
                                    lastQueriedDuels = di;
                                    startActivity(intent);
                                });
                            } catch (ExecutionException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }).start();
                        break;
                    }

                    case "Mm":{
                        FutureTask<HypixelMurderMysteryInfo> var4 = new FutureTask<>(new HypixelMurderMysteryQuery(input_name, s ->
                                Toast.makeText(MainActivity7.this, s, Toast.LENGTH_SHORT).show()
                        ));
                        new Thread(var4).start();

                        new Thread(() -> {
                            try {
                                MainActivity7.this.runOnUiThread(() -> {
                                    //进度条
                                    query.setEnabled(false);
                                    button_se.setEnabled(false);
                                    resetkey.setEnabled(false);
                                });

                                HypixelMurderMysteryInfo mi = var4.get();
                                Log.i("mi",mi.toString());
                                MainActivity7.this.runOnUiThread(() -> {
                                    Intent intent = new Intent(MainActivity7.this, MainActivity.class);
                                    lastQueriedMm = mi;
                                    startActivity(intent);
                                });
                            } catch (ExecutionException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }).start();
                        break;
                    }

                    case "UHC":{
                        FutureTask<HypixelUHCInfo> var5 = new FutureTask<>(new HypixelUHCQuery(input_name, s ->
                                Toast.makeText(MainActivity7.this, s, Toast.LENGTH_SHORT).show()
                        ));
                        new Thread(var5).start();

                        new Thread(() -> {
                            try {
                                MainActivity7.this.runOnUiThread(() -> {
                                    //进度条
                                    query.setEnabled(false);
                                    button_se.setEnabled(false);
                                    resetkey.setEnabled(false);
                                });

                                HypixelUHCInfo ui = var5.get();
                                Log.i("ui",ui.toString());
                                MainActivity7.this.runOnUiThread(() -> {
                                    Intent intent = new Intent(MainActivity7.this, MainActivity.class);
                                    lastQueriedUHC = ui;
                                    startActivity(intent);
                                });
                            } catch (ExecutionException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }).start();
                        break;
                    }
                }

            }
        });

    }



}