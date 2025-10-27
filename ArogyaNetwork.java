package com.arogya.ai;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ArogyaNetwork {

    public interface ResponseListener {
        void onResponse(String data);
    }

    public void fetchData(String urlString, ResponseListener listener) {
        new AsyncTask<String, Void, String>() {
            protected String doInBackground(String... urls) {
                try {
                    URL url = new URL(urls[0]);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    reader.close();
                    return builder.toString();
                } catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }

            protected void onPostExecute(String result) {
                listener.onResponse(result);
            }
        }.execute(urlString);
    }
}
