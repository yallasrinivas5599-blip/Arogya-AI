package com.arogya.ai;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import java.util.Locale;

public class MainActivity extends Activity {

    private ArogyaBrain brain;
    private ArogyaVoice voice;
    private EditText userInput;
    private TextView chatDisplay;
    private Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatDisplay = findViewById(R.id.chatDisplay);
        userInput = findViewById(R.id.userInput);
        sendBtn = findViewById(R.id.sendBtn);

        brain = new ArogyaBrain(this);
        voice = new ArogyaVoice(this);

        sendBtn.setOnClickListener(v -> {
            String text = userInput.getText().toString().trim();
            if (!text.isEmpty()) {
                chatDisplay.append("You: " + text + "\n");
                String reply = brain.getReply(text);
                chatDisplay.append("Arogya: " + reply + "\n");
                voice.speak(reply);
                userInput.setText("");
            }
        });
    }
}
