package com.mustafabaser.befit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnShare;
    Intent shareIntent;
    String shareBody = "This is a great app, you should try it out!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        String welcomeToast = "BeFit ile daha sağlıklı vücutlar!";

        Toast.makeText(getApplicationContext(), welcomeToast , Toast.LENGTH_LONG).show();

        btnShare = (Button) findViewById(R.id.button4);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/pain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "Şununla paylaş: "));

            }
        });

    }


    public void programlar(View view) {
        Intent programsActivity = new Intent(MainActivity.this, Programlar.class);
        startActivity(programsActivity);
    }

    public void ayarlar(View view) {
        Intent ayarlarActivity = new Intent(MainActivity.this, Ayarlar.class);
        startActivity(ayarlarActivity);
    }

    public void antrenman(View view) {
        Intent antrenmanActivity = new Intent(MainActivity.this, Antrenman.class);
        startActivity(antrenmanActivity);
    }

    public void bilgiler(View view) {
        Intent bilgilerActivity = new Intent(MainActivity.this, Bilgiler.class);
        startActivity(bilgilerActivity);
    }

}


