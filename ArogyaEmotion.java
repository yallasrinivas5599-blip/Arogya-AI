package com.arogya.ai;

import java.util.HashMap;

public class ArogyaEmotion {
    private String currentMood = "neutral";
    private HashMap<String, String> moodMap = new HashMap<>();

    public ArogyaEmotion() {
        moodMap.put("happy", "😊");
        moodMap.put("empathetic", "💞");
        moodMap.put("neutral", "🤖");
        moodMap.put("sad", "😔");
    }

    public void updateMood(String mood) {
        currentMood = moodMap.containsKey(mood) ? mood : "neutral";
    }

    public String getMood() {
        return moodMap.getOrDefault(currentMood, "🤖");
    }
}
