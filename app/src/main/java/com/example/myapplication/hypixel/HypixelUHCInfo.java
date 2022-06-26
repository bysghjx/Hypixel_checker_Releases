package com.example.myapplication.hypixel;

import androidx.annotation.NonNull;

import java.util.Objects;

public class HypixelUHCInfo {
    public String uuid;
    public String name;
    public String coins;
    public String KD;
    public int kills;
    public int deaths;
    public int wins;
    public int heads_eaten;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HypixelUHCInfo that = (HypixelUHCInfo) o;
        return kills == that.kills && deaths == that.deaths && wins == that.wins && heads_eaten == that.heads_eaten && Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name) && Objects.equals(coins, that.coins) && Objects.equals(KD, that.KD);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result +(uuid == null ? 0 :uuid.hashCode());
        result = 31 * result +(name == null ? 0 :name.hashCode());
        result = 31 * result +(coins == null ? 0 :coins.hashCode());
        result = 31 * result +(KD == null ? 0 :KD.hashCode());
        result = 31 * result + kills;
        result = 31 * result + deaths;
        result = 31 * result + wins;
        result = 31 * result + heads_eaten;
        return result;
    }
    @NonNull
    @Override
    public String toString() {
        return "HypixelPlayerInfo{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", coins='" + coins + '\'' +
                ", KD=" + KD +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", wins=" + wins +
                ", heads_eaten=" + heads_eaten +
                '}';
    }
}
