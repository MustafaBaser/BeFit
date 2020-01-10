package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mustafabaser.befit.fragments.WorkoutFragment1;

public class Workout extends AppCompatActivity {

    ImageView btNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        btNotification = findViewById(R.id.kasBeFit);

        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "BeFit ile daha mutlu vücutlar!";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Workout.this)
                        .setSmallIcon(R.drawable.ic_biceps)
                        .setContentTitle("Yeni Bildirim")
                        .setContentText(message)
                        .setAutoCancel(true);

                Intent intent = new Intent(Workout.this,Bildirim.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message",message);

                PendingIntent pendingIntent = PendingIntent.getActivity(Workout.this,
                        0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());
            }
        });
    }

    public void bacagaGit(View view) {

        Intent bacakBolgesi = new Intent(Workout.this, BacakBolgesi.class);
        startActivity(bacakBolgesi);

    }

    public void kollaraGit(View view) {

        Intent kolBolgesi = new Intent(Workout.this, KolBolgesi.class);
        startActivity(kolBolgesi);

    }

    public void sirtaGit(View view) {

        Intent sirtBolgesi = new Intent(Workout.this, SirtBolgesi.class);
        startActivity(sirtBolgesi);
    }

    public void goguseGit(View view) {

        Intent gogusBolgesi = new Intent(Workout.this, GogusBolgesi.class);
        startActivity(gogusBolgesi);
    }

    public void karinaGit(View view) {

        Intent karinBolgesi = new Intent(Workout.this, KarinBolgesi.class);
        startActivity(karinBolgesi);
    }

    public void omuzaGit(View view) {

        Intent omuzBolgesi = new Intent(Workout.this, OmuzBolgesi.class);
        startActivity(omuzBolgesi);
    }

    public void bildirimGonder(View view) {
    }
}
