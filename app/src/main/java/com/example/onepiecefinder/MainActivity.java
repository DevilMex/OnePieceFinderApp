package com.example.onepiecefinder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.onepiecefinder.classes.Episode;

public class MainActivity extends AppCompatActivity {

    private Episode episode = new Episode();
    private NumberPicker numberPicker;
    private TextView episode_text;
//    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        episode_text = findViewById(R.id.choiceText);
//        createNotificationChannel();
//        notificationManager = NotificationManagerCompat.from(this);
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(578);
    }

    public void submitWatchButton(View view){
        Button link1ButtonView = findViewById(R.id.btnLink1);
        Button link2ButtonView = findViewById(R.id.btnLink2);
        episode = new Episode(numberPicker.getValue());
        link1ButtonView.setVisibility(View.VISIBLE);
        link2ButtonView.setVisibility(View.VISIBLE);
        link1ButtonView.setText("Link 1: Episodio " + numberPicker.getValue());
        link2ButtonView.setText("Link 2: Episodio " + numberPicker.getValue());
        episode_text.setText("Episodio scelto: " + numberPicker.getValue());
    }

    public void browseLinkOne(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(episode.getFirstLink())));
    }

    public void browseLinkTwo(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(episode.getSecondLink())));
    }

    /*

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


     */

}