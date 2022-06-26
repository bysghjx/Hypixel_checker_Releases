package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.hypixel.HypixelBedWarsInfo;
import com.example.myapplication.hypixel.HypixelDuelInfo;
import com.example.myapplication.hypixel.HypixelMurderMysteryInfo;
import com.example.myapplication.hypixel.HypixelPlayerInfo;
import com.example.myapplication.hypixel.HypixelSkyWarsInfo;
import com.example.myapplication.hypixel.HypixelUHCInfo;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    SharedPreferences sp;
    String str;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sp = getSharedPreferences("api_data",MODE_PRIVATE);
        tv = findViewById(R.id.textView);


        switch (MainActivity7.select){
            case "player": {
                HypixelPlayerInfo pi = MainActivity7.lastQueriedPlayer;
                str = "玩家名: " + pi.name + "\n" +
                        "玩家UUID: " + pi.uuid + "\n" +
                        "玩家最后一次上线时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pi.lastLogin) + "\n" +
                        "玩家语言: " + pi.language + "\n";
                tv.setText(str);
                break;
            }
            case "bw":{
                HypixelBedWarsInfo bi = MainActivity7.lastQueriedBedwars;
                str = "玩家名: " + bi.name + "\n" +
                        "玩家UUID: " + bi.uuid + "\n" +
                        "经验值: " + bi.Experience +"\n" +
                        "Coins：" + bi.coins + "\n" +
                        "胜利数：" + bi.wins_bedwars +"\n" +
                        "最终击杀/击杀/死亡/最终死亡：" + bi.final_kills_bedwars +"/" + bi.kills_bedwars + "/" + bi.deaths_bedwars + "/" + bi.final_deaths_bedwars + "\n" +
                        "K/D：" + bi.K_D + "\n" +
                    "失去床/破坏床：" + bi.beds_lost_bedwars + "/" +bi.beds_broken_bedwars +"\n" +
                    "收集到的铁/金/钻/绿：" +bi.iron_resources_collected_bedwars +"/" +bi.gold_resources_collected_bedwars +"/" + bi.diamond_resources_collected_bedwars + "/" + bi.emerald_resources_collected_bedwars +"\n";
                tv.setText(str);
                break;
            }
            case "SkyWars" : {
                HypixelSkyWarsInfo si = MainActivity7.lastQueriedSkywars;
                str = "玩家名: " + si.name + "\n" +
                        "玩家UUID: " + si.uuid + "\n" +
                        "灵魂：" + si.souls + "\n" +
                        "Coins：" + si.coins + "\n" +
                        "经验值: " + si.skywars_experience + "\n" +
                        "击杀/死亡：" +si.kills + "/" +si.deaths + "\n" +
                        "K/D：" + si.KD + "\n" +
                        "胜利数：" + si.wins +"\n" +
                        "失败数：" +si.losses +"\n" +
                        "W/L比：" +si.WL + "\n" +
                        "最多击杀数：" +si.most_kills_game +"\n";
                tv.setText(str);
                break;
            }
            case "Duel":{
                HypixelDuelInfo di = MainActivity7.lastQueriedDuels;
                str = "玩家名: " + di.name + "\n" +
                        "玩家UUID: " + di.uuid + "\n" +
                        "总K/D：" + di.total_kd + "\n" +
                        "Coins：" + di.coins + "\n" +
                        "总胜场/败场: " + di.total_wins + "/" + di.total_losses + "\n" +
                        "总击杀/死亡：" +di.total_kills + "/" +di.total_deaths + "\n" +
                        "UHC 击杀/死亡：" + di.uhc_duel_kills + "/"+ di.uhc_duel_deaths + "\n" +
                        "UHC 击杀/死亡：" + di.uhc_duel_kills + "/"+ di.uhc_duel_deaths + "\n" +
                        "potion 击杀/死亡：" + di.potion_duel_kills + "/"+ di.potion_duel_deaths + "\n" +
                        "sumo 击杀/死亡：" + di.sumo_duel_kills + "/"+ di.sumo_duel_deaths + "\n" +
                        "classic 击杀/死亡：" + di.classic_duel_kills + "/"+ di.classic_duel_deaths + "\n" +
                        "bow 击杀/死亡：" + di.bow_duel_kills + "/"+ di.bow_duel_deaths + "\n" +
                        "combo 击杀/死亡：" + di.combo_duel_kills + "/"+ di.combo_duel_deaths + "\n";
                tv.setText(str);
                break;
            }
            case "Mm":{
                HypixelMurderMysteryInfo mi = MainActivity7.lastQueriedMm;
                str = "玩家名: " + mi.name + "\n" +
                        "玩家UUID: " + mi.uuid + "\n" +
                        "Coins：" + mi.coins + "\n" +
                        "K/D：" + mi.KD + "\n" +
                        "W/L：" + mi.WL + "\n" +
                        "总击杀/死亡：" +mi.kills + "/" +mi.deaths + "\n" +
                        "总胜场/败场: " + mi.wins + "/" + mi.losses + "\n" +
                        "侦探/杀手几率: " + mi.detective_chance + "/" + mi.murderer_chance + "\n" +
                        "陷阱/弓/刀击杀: " + mi.trap_kills + "/" + mi.bow_kills + "/" +mi.knife_kills + "\n" +
                        "成为英雄次数：" + mi.was_hero + "\n" +
                        "侦探/杀手胜场：" + mi.detective_wins + "/" + mi.murderer_wins + "\n" ;
                tv.setText(str);
                break;
            }
            case "UHC": {
                HypixelUHCInfo ui = MainActivity7.lastQueriedUHC;
                str = "玩家名: " + ui.name + "\n" +
                        "玩家UUID: " + ui.uuid + "\n" +
                        "Coins：" + ui.coins + "\n" +
                        "K/D：" + ui.KD + "\n" +
                        "总击杀/死亡：" +ui.kills + "/" +ui.deaths + "\n" +
                        "总胜场: " + ui.wins + "\n" +
                        "吃掉的头颅数量：" + ui.heads_eaten + "\n" ;
                tv.setText(str);
                break;
            }
        }


        }


    }