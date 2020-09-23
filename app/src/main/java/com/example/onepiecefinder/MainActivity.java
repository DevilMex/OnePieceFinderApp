package com.example.onepiecefinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.onepiecefinder.classes.Episode;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText episodeNumber = findViewById(R.id.episodeNumber);
//        episodeNumber.set("");

        Button button = findViewById(R.id.mirror1button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView episodeFieldView = findViewById(R.id.episodeField);
                EditText episodeNumberView = findViewById(R.id.episodeNumber);
                CharSequence episodeCharSeq = episodeNumberView.getText();
                if(!episodeCharSeq.toString().equals("")){
                    Episode episode = new Episode(Integer.parseInt(episodeCharSeq.toString()));
                    if(episode.getNumber() <= 0) {
                        sendNotification("Valore non previsto", "L'episodio " + episode.getNumber() + " risulta inesistente!");
                        episodeFieldView.setText("Valore non previsto! L'episodio " + episode.getNumber() + " risulta inesistente!");
                    } else {
                        Log.i("Valore accettato!", "Creazione dei links...");
                        episodeFieldView.setMovementMethod(LinkMovementMethod.getInstance());
                        episodeFieldView.setText(Html.fromHtml("" +
                                "<h1><a href=\"" + episode.getFirstLink() + "\">Link 1</a></h1>" +
                                "<h1><a href=\"" + episode.getSecondLink() + "\">Link 2</a></h1>"
                        ));
                    }
                } else {
                    sendNotification("Contenuto nullo!", "Non c'è nulla");
                    episodeFieldView.setText("Contenuto nullo! il campo è vuoto!");
                }
            }
        });
    }

    void sendNotification(String title, String msg){
        Log.w("Input Error","Errore nell'input. Creazione notifica...");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                .setSmallIcon(R.drawable.ic_alert)
                .setContentTitle(title)
                .setContentText(msg)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }

}