package com.example.myapplication.hypixel;

import androidx.annotation.NonNull;

import java.util.Objects;

public class HypixelMurderMysteryInfo {
    public String uuid;
    public String name;
    public String coins;
    public String KD;
    public String WL;
    public int kills;
    public int deaths;
    public int wins;
    public int losses;
    public int detective_chance;
    public int murderer_chance;
    public int trap_kills;
    public int bow_kills;
    public int knife_kills;
    public int was_hero;
    public int detective_wins;
    public int murderer_wins;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HypixelMurderMysteryInfo that = (HypixelMurderMysteryInfo) o;
        return kills == that.kills && deaths == that.deaths && wins == that.wins && losses == that.losses && detective_chance == that.detective_chance && murderer_chance == that.murderer_chance && trap_kills == that.trap_kills && bow_kills == that.bow_kills && knife_kills == that.knife_kills && was_hero == that.was_hero && detective_wins == that.detective_wins && murderer_wins == that.murderer_wins && Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name) && Objects.equals(coins, that.coins) && Objects.equals(KD, that.KD) && Objects.equals(WL, that.WL);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result +(uuid == null ? 0 : uuid.hashCode());
        result = 31 * result +(name == null ? 0 : name.hashCode());
        result = 31 * result +(coins == null ? 0 : coins.hashCode());
        result = 31 * result +(KD == null ? 0 : KD.hashCode());
        result = 31 * result +(WL == null ? 0 : WL.hashCode());
        result = 31 * result + kills;
        result = 31 * result + deaths;
        result = 31 * result + wins;
        result = 31 * result + losses;
        result = 31 * result + detective_chance;
        result = 31 * result + murderer_chance;
        result = 31 * result + trap_kills;
        result = 31 * result + bow_kills;
        result = 31 * result + knife_kills;
        result = 31 * result + was_hero;
        result = 31 * result + detective_wins;
        result = 31 * result + murderer_wins;
        return result;
    }
    @NonNull
    @Override
    public String toString() {
        return "HypixelBedWarsInfo{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", coins='" + coins + '\'' +
                ", KD=" + KD +
                ", WL=" + WL +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", wins=" + wins +
                ", losses=" + losses +
                ", detective_chance=" + detective_chance +
                ", murderer_chance=" + murderer_chance +
                ", trap_kills=" + trap_kills +
                ", bow_kills=" + bow_kills +
                ", knife_kills=" + knife_kills +
                ", was_hero=" + was_hero +
                ", detective_wins=" + detective_wins +
                ", murderer_wins=" + murderer_wins +
                '}';
    }
}
