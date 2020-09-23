package com.example.onepiecefinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.mirror1button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText episodeView = findViewById(R.id.episodeNumber);
                CharSequence episodeCharSeq = episodeView.getText();
                if(!episodeCharSeq.toString().equals("")){
                    int episode = Integer.parseInt(episodeCharSeq.toString());
                    if(episode == 0) {
                        sendNotification();
                    } else {
                        Log.i("Riconoscimento valore", "creazione della pagina");
                        //Mettere webView in app
                    }
                } else {
                    sendNotification();
                }
            }
        });
    }

    void sendNotification(){
        Log.w("Input Error","Errore nell'input. Creazione notifica");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                .setSmallIcon(R.drawable.ic_alert)
                .setContentTitle("Message")
                .setContentText("Text text")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }

}