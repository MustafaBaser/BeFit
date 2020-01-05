package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mustafabaser.befit.fragments.WorkoutFragment1;

public class Workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
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
}
