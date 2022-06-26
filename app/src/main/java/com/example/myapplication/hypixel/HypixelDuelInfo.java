package com.example.myapplication.hypixel;

import androidx.annotation.NonNull;

import java.util.Objects;

public class HypixelDuelInfo {
    public String uuid;
    public String name;
    public String total_kd;
    public String coins;
    public int total_wins;
    public int total_losses;
    public int total_kills;
    public int total_deaths;
    public int uhc_duel_kills;
    public int uhc_duel_deaths;
    public int potion_duel_kills;
    public int potion_duel_deaths;
    public int sumo_duel_kills;
    public int sumo_duel_deaths;
    public int classic_duel_kills;
    public int classic_duel_deaths;
    public int bow_duel_kills;
    public int bow_duel_deaths;
    public int combo_duel_kills;
    public int combo_duel_deaths;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HypixelDuelInfo that = (HypixelDuelInfo) o;
        return total_wins == that.total_wins && total_losses == that.total_losses && total_kills == that.total_kills && total_deaths == that.total_deaths && uhc_duel_kills == that.uhc_duel_kills && uhc_duel_deaths == that.uhc_duel_deaths && potion_duel_kills == that.potion_duel_kills && potion_duel_deaths == that.potion_duel_deaths && sumo_duel_kills == that.sumo_duel_kills && sumo_duel_deaths == that.sumo_duel_deaths && classic_duel_kills == that.classic_duel_kills && classic_duel_deaths == that.classic_duel_deaths && bow_duel_kills == that.bow_duel_kills && bow_duel_deaths == that.bow_duel_deaths && combo_duel_kills == that.combo_duel_kills && combo_duel_deaths == that.combo_duel_deaths && Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name) && Objects.equals(total_kd, that.total_kd) && Objects.equals(coins, that.coins);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (uuid == null ? 0 : uuid.hashCode());
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (coins == null ? 0 : coins.hashCode());
        result = 31 * result + (total_kd == null ? 0 : total_kd.hashCode());
        result = 31 * result + total_wins;
        result = 31 * result + total_losses;
        result = 31 * result + total_kills;
        result = 31 * result + total_deaths;
        result = 31 * result + uhc_duel_kills;
        result = 31 * result + uhc_duel_deaths;
        result = 31 * result + potion_duel_kills;
        result = 31 * result + potion_duel_deaths;
        result = 31 * result + sumo_duel_kills;
        result = 31 * result + sumo_duel_deaths;
        result = 31 * result + classic_duel_kills;
        result = 31 * result + classic_duel_deaths;
        result = 31 * result + bow_duel_kills;
        result = 31 * result + bow_duel_deaths;
        result = 31 * result + combo_duel_kills;
        result = 31 * result + combo_duel_deaths;
        return  result;
    }
    @NonNull
    @Override
    public String toString() {
        return "HypixelPlayerInfo{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", coins='" + coins + '\'' +
                ", total_kd=" + total_kd +
                ", total_wins=" + total_wins +
                ", total_losses=" + total_losses +
                ", total_kills=" + total_kills +
                ", total_deaths=" + total_deaths +
                ", uhc_duel_kills=" + uhc_duel_kills +
                ", uhc_duel_deaths=" + uhc_duel_deaths +
                ", potion_duel_kills=" + potion_duel_kills +
                ", potion_duel_deaths=" + potion_duel_deaths +
                ", sumo_duel_kills=" + sumo_duel_kills +
                ", sumo_duel_deaths=" + sumo_duel_deaths +
                ", classic_duel_kills=" + classic_duel_kills +
                ", classic_duel_deaths=" + classic_duel_deaths +
                ", bow_duel_kills=" + bow_duel_kills +
                ", bow_duel_deaths=" + bow_duel_deaths +
                ", combo_duel_kills=" + combo_duel_kills +
                ", combo_duel_deaths=" + combo_duel_deaths +
                '}';
    }
}
