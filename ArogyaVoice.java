package com.arogya.ai;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import java.util.Locale;

public class ArogyaVoice {
    private TextToSpeech tts;

    public ArogyaVoice(Context context) {
        tts = new TextToSpeech(context, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.ENGLISH);
                tts.setPitch(1.1f);
                tts.setSpeechRate(1.0f);
            }
        });
    }

    public void speak(String text) {
        if (tts != null) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    public void shutdown() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}
