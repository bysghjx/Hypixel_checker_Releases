package com.example.myapplication.hypixel;

import androidx.annotation.NonNull;

import java.util.Objects;

public class HypixelBedWarsInfo {
    public String uuid;
    public String name;

    public int Experience;
    public String coins;
    public int wins_bedwars;

    public int final_kills_bedwars;
    public int kills_bedwars;
    public int deaths_bedwars;
    public int final_deaths_bedwars;
    public String K_D;
    public int beds_lost_bedwars;
    public int beds_broken_bedwars;
    public int iron_resources_collected_bedwars;
    public int gold_resources_collected_bedwars;
    public int diamond_resources_collected_bedwars;
    public int emerald_resources_collected_bedwars;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HypixelBedWarsInfo that = (HypixelBedWarsInfo) o;
        return final_kills_bedwars == that.final_kills_bedwars && kills_bedwars == that.kills_bedwars && deaths_bedwars == that.deaths_bedwars && final_deaths_bedwars == that.final_deaths_bedwars && Objects.equals(K_D, that.K_D) && beds_lost_bedwars == that.beds_lost_bedwars && beds_broken_bedwars == that.beds_broken_bedwars && iron_resources_collected_bedwars == that.iron_resources_collected_bedwars && gold_resources_collected_bedwars == that.gold_resources_collected_bedwars && diamond_resources_collected_bedwars == that.diamond_resources_collected_bedwars && emerald_resources_collected_bedwars == that.emerald_resources_collected_bedwars && Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name) && Objects.equals(Experience, that.Experience) && Objects.equals(coins, that.coins) && wins_bedwars == that.wins_bedwars;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (uuid == null ? 0 : uuid.hashCode());
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + Experience;
        result = 31 * result + (coins == null ? 0 : coins.hashCode());
        result = 31 * result + wins_bedwars;
        result = 31 * result + final_kills_bedwars;
        result = 31 * result + kills_bedwars;
        result = 31 * result + deaths_bedwars;
        result = 31 * result + final_deaths_bedwars;
        result = 31 * result + (K_D == null ? 0 : K_D.hashCode());
        result = 31 * result + beds_lost_bedwars;
        result = 31 * result + beds_broken_bedwars;
        result = 31 * result + iron_resources_collected_bedwars;
        result = 31 * result + gold_resources_collected_bedwars;
        result = 31 * result + diamond_resources_collected_bedwars;
        result = 31 * result + emerald_resources_collected_bedwars;
        return result;
    }


    @NonNull
    @Override
    public String toString() {
        return "HypixelBedWarsInfo{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", Experience='" + Experience + '\'' +
                ", coins=" + coins +
                ", wins_bedwars=" + wins_bedwars +
                ", final_kills_bedwars=" + final_kills_bedwars +
                ", kills_bedwars=" + kills_bedwars +
                ", final_deaths_bedwars=" + final_deaths_bedwars +
                ", deaths_bedwars=" + deaths_bedwars +
                ", k_D=" + K_D +
                ", beds_lost_bedwars=" + beds_lost_bedwars +
                ", beds_broken_bedwars=" + beds_broken_bedwars +
                ", iron_resources_collected_bedwars=" + iron_resources_collected_bedwars +
                ", gold_resources_collected_bedwars=" + gold_resources_collected_bedwars +
                ", diamond_resources_collected_bedwars=" + diamond_resources_collected_bedwars +
                ", emerald_resources_collected_bedwars=" + emerald_resources_collected_bedwars +
                '}';
    }
}


