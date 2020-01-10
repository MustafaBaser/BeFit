package com.mustafabaser.befit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnShare;
    Intent shareIntent;
    String shareBody = "BeFit ile daha sağlıklı vücutlar! Tavsiye ederim!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.dbName);


        String welcomeToast = "BeFit ile daha sağlıklı vücutlar!";

        Toast.makeText(getApplicationContext(), welcomeToast, Toast.LENGTH_LONG).show();

        btnShare = (Button) findViewById(R.id.button4);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "Şununla paylaş: "));

            }
        });

    }

    public void antrenman(View view) {
        Intent workoutActivity = new Intent(MainActivity.this, Workout.class);
        startActivity(workoutActivity);
    }

    public void programlar(View view) {
        Intent programsActivity = new Intent(MainActivity.this, Programlar.class);
        startActivity(programsActivity);
    }

    public void bilgiler(View view) {
        Intent bilgilerActivity = new Intent(MainActivity.this, Bilgiler.class);
        startActivity(bilgilerActivity);
    }

    public void profil(View view) {
        Intent profilActivity = new Intent(MainActivity.this, Profil.class);
        startActivity(profilActivity);
    }

    public void hakkimda(View view) {
        Intent hakkimdaActivity = new Intent(MainActivity.this, Hakkimda.class);
        startActivity(hakkimdaActivity);
    }
}


