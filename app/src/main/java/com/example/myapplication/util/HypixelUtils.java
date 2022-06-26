package com.example.myapplication.util;

import android.annotation.SuppressLint;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.myapplication.hypixel.HypixelBedWarsInfo;
import com.example.myapplication.hypixel.HypixelDuelInfo;
import com.example.myapplication.hypixel.HypixelMurderMysteryInfo;
import com.example.myapplication.hypixel.HypixelPlayerInfo;
import com.example.myapplication.hypixel.HypixelSkyWarsInfo;
import com.example.myapplication.hypixel.HypixelUHCInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class HypixelUtils {
    private static String apiKey;

    public static int getPlayer(String uuid, HypixelPlayerInfo info) {
        checkAPIKey();
        String url = String.format("https://api.hypixel.net/player?key=%s&uuid=%s", apiKey, uuid);
        HttpResult result = HttpUtils.get(url);
        if (!result.isSuccess()) {
            return -1;
        }

        if (result.responseCode == 200) {
            result.read();
            JSONObject json = JSON.parseObject(result.getContent());
            JSONObject player = json.getJSONObject("player");
            info.uuid = player.getString("uuid");
            info.name = player.getString("playername");
            info.firstLogin = new Date(player.getLongValue("firstLogin"));
            info.lastLogin = new Date(player.getLongValue("lastLogin"));
            info.language = player.getString("userLanguage");
            List<String> list = new ArrayList<>();
            JSONArray knownAliases = player.getJSONArray("knownAliases");
            for (int i = 0; i < knownAliases.size(); i++) {
                list.add(knownAliases.getString(i));
            }
            info.knownAliases = list;
            info.data = player.getJSONObject("stats");
            return 200;
        }

        result.close();
        return result.responseCode;
    }

    @SuppressLint("DefaultLocale")
    public static int getBedwars(String uuid, HypixelBedWarsInfo info) {
        checkAPIKey();
        String url = String.format("https://api.hypixel.net/player?key=%s&uuid=%s", apiKey, uuid);
        HttpResult result = HttpUtils.get(url);
        if (!result.isSuccess()) {
            return -1;
        }

        if (result.responseCode == 200) {
            result.read();

            JSONObject json = JSON.parseObject(result.getContent());
            JSONObject player = json.getJSONObject("player");
            JSONObject bw = player.getJSONObject("stats").getJSONObject("Bedwars");
            info.uuid = player.getString("uuid");
            info.name = player.getString("playername");
            info.Experience = bw.getIntValue("Experience");
            info.coins = bw.getString("coins");
            info.wins_bedwars = bw.getIntValue("wins_bedwars");
            info.final_kills_bedwars = bw.getIntValue("final_kills_bedwars");
            info.kills_bedwars = bw.getIntValue("kills_bedwars");
            info.deaths_bedwars = bw.getIntValue("deaths_bedwars");
            info.final_deaths_bedwars = bw.getIntValue("final_deaths_bedwars");

            int totalKill = info.final_kills_bedwars + info.kills_bedwars;
            int totalDeath = info.final_deaths_bedwars + info.deaths_bedwars;
            info.K_D = String.format("%.2f", (double) totalKill / (double) totalDeath);

            info.beds_lost_bedwars = bw.getIntValue("beds_lost_bedwars");
            info.beds_broken_bedwars = bw.getIntValue("beds_broken_bedwars");
            info.iron_resources_collected_bedwars = bw.getIntValue("iron_resources_collected_bedwars");
            info.gold_resources_collected_bedwars = bw.getIntValue("gold_resources_collected_bedwars");
            info.diamond_resources_collected_bedwars = bw.getIntValue("diamond_resources_collected_bedwars");
            info.emerald_resources_collected_bedwars = bw.getIntValue("emerald_resources_collected_bedwars");
            return 200;
        }

        result.close();
        return result.responseCode;
    }
    public static int getSkyWars(String uuid, HypixelSkyWarsInfo info) {
        checkAPIKey();
        String url = String.format("https://api.hypixel.net/player?key=%s&uuid=%s", apiKey, uuid);
        HttpResult result = HttpUtils.get(url);
        if (!result.isSuccess()) {
            return -1;
        }

        if (result.responseCode == 200) {
            result.read();
            JSONObject json = JSON.parseObject(result.getContent());
            JSONObject player = json.getJSONObject("player");
            JSONObject sw = player.getJSONObject("stats").getJSONObject("SkyWars");
            info.uuid = player.getString("uuid");
            info.name = player.getString("playername");
            info.souls = sw.getIntValue("souls");
            info.coins = sw.getString("coins");
            info.skywars_experience = sw.getIntValue("skywars_experience");
            info.kills = sw.getIntValue("kills");
            info.deaths = sw.getIntValue("deaths");

            info.KD = String.format("%.2f", (double) info.kills / (double) info.deaths);

            info.wins = sw.getIntValue("wins");
            info.losses = sw.getIntValue("losses");

            info.WL = String.format("%.2f",(double)info.wins / (double) info.losses);

            info.most_kills_game = sw.getString("most_kills_game");
            return 200;
        }

        result.close();
        return result.responseCode;
    }
    public static int getDuel(String uuid, HypixelDuelInfo info) {
        checkAPIKey();
        String url = String.format("https://api.hypixel.net/player?key=%s&uuid=%s", apiKey, uuid);
        HttpResult result = HttpUtils.get(url);
        if (!result.isSuccess()) {
            return -1;
        }

        if (result.responseCode == 200) {
            result.read();
            JSONObject json = JSON.parseObject(result.getContent());
            JSONObject player = json.getJSONObject("player");
            JSONObject du = player.getJSONObject("stats").getJSONObject("Duels");
            info.uuid = player.getString("uuid");
            info.name = player.getString("playername");
            info.total_wins = du.getIntValue("wins");
            info.total_losses = du.getIntValue("losses");
            info.total_kills = du.getIntValue("kills");
            info.total_deaths = du.getIntValue("deaths");
            info.coins = du.getString("coins");
            info.uhc_duel_kills = du.getIntValue("uhc_duel_kills");
            info.uhc_duel_deaths = du.getIntValue("uhc_duel_deaths");
            info.potion_duel_kills = du.getIntValue("potion_duel_kills");
            info.potion_duel_deaths = du.getIntValue("potion_duel_deaths");
            info.sumo_duel_kills = du.getIntValue("sumo_duel_kills");
            info.sumo_duel_deaths = du.getIntValue("sumo_duel_deaths");
            info.classic_duel_kills = du.getIntValue("classic_duel_kills");
            info.classic_duel_deaths = du.getIntValue("classic_duel_deaths");
            info.bow_duel_kills = du.getIntValue("bow_duel_kills");
            info.bow_duel_deaths = du.getIntValue("bow_duel_deaths");
            info.combo_duel_kills = du.getIntValue("classic_duel_kills");
            info.combo_duel_deaths = du.getIntValue("classic_duel_deaths");
            info.total_kd = String.format("%.2f", (double) info.total_kills / (double) info.total_deaths);

            return 200;
        }

        result.close();
        return result.responseCode;
    }

    public static int getMm(String uuid, HypixelMurderMysteryInfo info) {
        checkAPIKey();
        String url = String.format("https://api.hypixel.net/player?key=%s&uuid=%s", apiKey, uuid);
        HttpResult result = HttpUtils.get(url);
        if (!result.isSuccess()) {
            return -1;
        }

        if (result.responseCode == 200) {
            result.read();
            JSONObject json = JSON.parseObject(result.getContent());
            JSONObject player = json.getJSONObject("player");
            JSONObject mm = player.getJSONObject("stats").getJSONObject("MurderMystery");
            info.uuid = player.getString("uuid");
            info.name = player.getString("playername");
            info.coins = mm.getString("coins");
            info.kills = mm.getIntValue("kills");
            info.deaths = mm.getIntValue("deaths");
            info.wins = mm.getIntValue("wins");
            info.losses = mm.getIntValue("losses");
            info.detective_chance = mm.getIntValue("detective_chance");
            info.murderer_chance = mm.getIntValue("murderer_chance");
            info.trap_kills = mm.getIntValue("trap_kills");
            info.bow_kills = mm.getIntValue("bow_kills");
            info.knife_kills = mm.getIntValue("knife_kills");
            info.was_hero = mm.getIntValue("was_hero");
            info.detective_wins = mm.getIntValue("detective_wins");
            info.murderer_wins = mm.getIntValue("murderer_wins");
            info.KD =  String.format("%.2f", (double) info.kills / (double) info.deaths);

            info.WL =  String.format("%.2f", (double) info.wins / (double) info.losses);
            return 200;
        }

        result.close();
        return result.responseCode;
    }
    public static int getUHC(String uuid, HypixelUHCInfo info){
        checkAPIKey();
        String url = String.format("https://api.hypixel.net/player?key=%s&uuid=%s", apiKey, uuid);
        HttpResult result = HttpUtils.get(url);
        if (!result.isSuccess()) {
            return -1;
        }
            if (result.responseCode == 200) {
                result.read();
                JSONObject json = JSON.parseObject(result.getContent());
                JSONObject player = json.getJSONObject("player");
                JSONObject uhc = player.getJSONObject("stats").getJSONObject("UHC");
                info.uuid = player.getString("uuid");
                info.name = player.getString("playername");
                info.coins = uhc.getString("coins");
                info.kills = uhc.getIntValue("kills");
                info.deaths = uhc.getIntValue("deaths");
                info.wins = uhc.getIntValue("wins");
                info.heads_eaten = uhc.getIntValue("heads_eaten");
                info.KD = String.format("%.2f", (double) info.kills / (double) info.deaths);

                return 200;
            }
            result.close();
            return result.responseCode;
    }

    public static void setApiKey(String apiKey) {
        HypixelUtils.apiKey = apiKey;
    }

    private static void checkAPIKey() {
        if (apiKey == null) {
            throw new IllegalStateException("Api key not set.");
        }
    }

    private HypixelUtils() {
    }
}
