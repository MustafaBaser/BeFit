package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class Bilgiler extends AppCompatActivity {

    CoordinatorLayout bilgiler_Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgiler);

        bilgiler_Layout = findViewById(R.id.bilgiler_Layout);

    }

    public void nedirbu(View v) {

        Snackbar.make(bilgiler_Layout, "Bu sorular, vücut geliştirmede cevabı en çok merak edilen sorulardır!", Snackbar.LENGTH_LONG)
                .setAction("close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorAccent))
                .show();


    }
}