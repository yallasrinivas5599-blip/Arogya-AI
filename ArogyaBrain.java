package com.arogya.ai;

import android.content.Context;
import java.util.Random;

public class ArogyaBrain {

    private Context context;
    private ArogyaEmotion emotion;
    private ArogyaMemory memory;

    public ArogyaBrain(Context ctx) {
        this.context = ctx;
        this.emotion = new ArogyaEmotion();
        this.memory = new ArogyaMemory(ctx);
    }

    public String getReply(String input) {
        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi")) {
            emotion.updateMood("happy");
            return "Hey there! I’m feeling great today 🌞 How are you?";
        } else if (input.contains("sad") || input.contains("bad")) {
            emotion.updateMood("empathetic");
            return "I'm sorry you're feeling that way 💔. Let's talk about it.";
        } else if (input.contains("medicine") || input.contains("remedy")) {
            return "Make sure to take your medicine on time 💊 and drink enough water.";
        } else if (input.contains("who are you")) {
            return "I’m Arogya AI 🤖, your caring health companion with emotions and logic.";
        } else {
            return getSmartResponse(input);
        }
    }

    private String getSmartResponse(String input) {
        String[] replies = {
            "Interesting... Tell me more 🧠",
            "Hmm, I see. That’s quite thoughtful.",
            "Your feelings matter. I'm here for you ❤️",
            "Let's make today healthy and bright ☀️"
        };
        return replies[new Random().nextInt(replies.length)];
    }
}
