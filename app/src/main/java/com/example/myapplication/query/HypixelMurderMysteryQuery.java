package com.example.myapplication.query;

import android.os.Looper;

import com.example.myapplication.Acceptable;
import com.example.myapplication.hypixel.HypixelMurderMysteryInfo;
import com.example.myapplication.hypixel.HypixelPlayerInfo;
import com.example.myapplication.util.HypixelUtils;
import com.example.myapplication.util.MojangUtils;

import java.util.concurrent.Callable;

public class HypixelMurderMysteryQuery implements Callable<HypixelMurderMysteryInfo> {
    public final String input_name;
    private final Acceptable<String> onToast;

    public HypixelMurderMysteryQuery(String input_name, Acceptable<String> onToast) {
        this.input_name = input_name;
        this.onToast = onToast;
    }

    @Override
    public HypixelMurderMysteryInfo call() {
        Looper.prepare();
        String uuid = MojangUtils.getUUIDByName(input_name);
        if (uuid == null) {
            onToast.accept("找不到对应uuid!请检查用户名是否输入正确");
            Looper.loop();
            return null;
        }
        HypixelMurderMysteryInfo mi = new HypixelMurderMysteryInfo();
        int code = HypixelUtils.getMm(uuid, mi);
        if (code == -1) {
            onToast.accept("查询失败,请检查key和用户名是否输入正确");
            Looper.loop();
            return null;
        }

        if (code == 200) {
            return mi;
        }


        onToast.accept("Http: " + code);
        Looper.loop();
        return null;
    }
}
