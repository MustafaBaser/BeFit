package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mustafabaser.befit.fragments.WorkoutFragment1;

public class Hakkimda extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkimda);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.share_button:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody="BeFit harika bir uygulama, kesinlikle tavsiye ederim!";
                String shareSubject ="Bunu denemelisiniz!";

                sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);

                startActivity(Intent.createChooser(sharingIntent, "Şununla paylaş: "));
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void hakkimdaGoster(View view) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        WorkoutFragment1 workoutFragment1 = new WorkoutFragment1();
        fragmentTransaction.replace(R.id.frame_layout,workoutFragment1).commit(); // Tekrar tıklandığında üst üste binmemesi için add yerine replace kullandım.
    }
}
