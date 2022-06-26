package com.example.myapplication.hypixel;

import androidx.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class HypixelPlayerInfo {
    public String uuid;
    public String name;
    public String language;
    public List<String> knownAliases;
    public Date firstLogin;
    public Date lastLogin;
    public JSONObject data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HypixelPlayerInfo that = (HypixelPlayerInfo) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name) && Objects.equals(language, that.language) && Objects.equals(knownAliases, that.knownAliases) && Objects.equals(firstLogin, that.firstLogin) && Objects.equals(lastLogin, that.lastLogin) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (uuid == null ? 0 : uuid.hashCode());
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (language == null ? 0 : language.hashCode());
        result = 31 * result + (knownAliases == null ? 0 : knownAliases.hashCode());
        result = 31 * result + (firstLogin == null ? 0 : firstLogin.hashCode());
        result = 31 * result + (lastLogin == null ? 0 : lastLogin.hashCode());
        result = 31 * result + (data == null ? 0 : data.hashCode());
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "HypixelPlayerInfo{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", knownAliases=" + knownAliases +
                ", firstLogin=" + firstLogin +
                ", lastLogin=" + lastLogin +
                ", data=" + data +
                '}';
    }
}
