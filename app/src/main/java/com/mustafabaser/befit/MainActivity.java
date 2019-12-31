package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }
        public void programlar(View view){
            Intent programsActivity = new Intent(MainActivity.this, Programlar.class);
            startActivity(programsActivity);
        }
        public void ayarlar(View view){
            Intent ayarlarActivity = new Intent(MainActivity.this,Ayarlar.class);
            startActivity(ayarlarActivity);
        }

        public void antrenman(View view){
            Intent antrenmanActivity = new Intent(MainActivity.this,Antrenman.class);
            startActivity(antrenmanActivity);
        }
    }

