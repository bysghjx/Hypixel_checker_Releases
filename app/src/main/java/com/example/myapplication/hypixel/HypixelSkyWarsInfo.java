package com.example.myapplication.hypixel;

import androidx.annotation.NonNull;

import java.util.Objects;

public class HypixelSkyWarsInfo {
    public String uuid;
    public String name;
    public int souls;
    public String coins;
    public int skywars_experience;
    public int kills;
    public int deaths;
    public String KD;
    public int wins;
    public int losses;
    public String WL;
    public String most_kills_game;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HypixelSkyWarsInfo that = (HypixelSkyWarsInfo) o;
        return souls == that.souls && skywars_experience == that.skywars_experience && kills == that.kills && deaths == that.deaths && wins == that.wins && losses == that.losses && Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name) && Objects.equals(coins, that.coins) && Objects.equals(KD, that.KD) && Objects.equals(WL, that.WL) && Objects.equals(most_kills_game, that.most_kills_game);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (uuid == null ? 0 : uuid.hashCode());
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (coins == null ? 0 : coins.hashCode());
        result = 31 * result + (KD == null ? 0 : KD.hashCode());
        result = 31 * result + (WL == null ? 0 : WL.hashCode());
        result = 31 * result + (most_kills_game == null ? 0 : most_kills_game.hashCode());
        result = 31 * result + souls;
        result = 31 * result + skywars_experience;
        result = 31 * result + kills;
        result = 31 * result + deaths;
        result = 31 * result + wins;
        result = 31 * result + losses;
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "HypixelBedWarsInfo{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", souls='" + souls + '\'' +
                ", coins=" + coins +
                ", skywars_experience=" + skywars_experience +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", KD=" + KD +
                ", wins=" + wins +
                ", losses=" + losses +
                ", WL=" + WL +
                ", most_kills_game=" + most_kills_game +
                '}';
    }
}
