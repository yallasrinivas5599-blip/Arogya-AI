package com.arogya.ai;

import android.content.Context;
import android.content.SharedPreferences;

public class ArogyaMemory {
    private SharedPreferences memory;

    public ArogyaMemory(Context ctx) {
        memory = ctx.getSharedPreferences("ArogyaMemory", Context.MODE_PRIVATE);
    }

    public void save(String key, String value) {
        memory.edit().putString(key, value).apply();
    }

    public String recall(String key) {
        return memory.getString(key, "none");
    }
}
