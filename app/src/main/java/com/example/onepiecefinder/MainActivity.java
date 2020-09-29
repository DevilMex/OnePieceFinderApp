package com.example.onepiecefinder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.onepiecefinder.classes.Episode;

public class MainActivity extends AppCompatActivity {

    private Episode episode = new Episode();
    private NumberPicker numberPicker;
    private NotificationManagerCompat notificationManager;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        notificationManager = NotificationManagerCompat.from(this);
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(578);


    }

    public void submitWatchButton(View view){
        Button link1ButtonView = findViewById(R.id.btnLink1);
        Button link2ButtonView = findViewById(R.id.btnLink2);
        episode = new Episode(numberPicker.getValue());
        if(episode.getNumber() <= 0 || episode.getNumber() > 578) {
            link1ButtonView.setVisibility(View.INVISIBLE);
            link2ButtonView.setVisibility(View.INVISIBLE);
            sendNotification("Valore non previsto", "L'episodio " + episode.getNumber() + " risulta inesistente!");
        } else {
            Log.i("Valore accettato!", "Creazione dei links...");
            link1ButtonView.setVisibility(View.VISIBLE);
            link2ButtonView.setVisibility(View.VISIBLE);
        }
    }

    public void browseLinkOne(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(episode.getFirstLink())));
    }

    public void browseLinkTwo(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(episode.getSecondLink())));
    }

    void sendNotification(String title, String msg){
        Log.w("Input Error","Errore nell'input. Creazione notifica...");
        Notification notification = new NotificationCompat.Builder(this, "channel")
                .setSmallIcon(R.drawable.ic_alert)
                .setContentTitle(title)
                .setContentText(msg)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_ERROR)
                .build();
        notificationManager.notify(1, notification);
    }

    void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "channel",
                    "channel_name",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("channel_description");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

}