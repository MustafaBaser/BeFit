package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Profil extends AppCompatActivity {

    ListView listView;
    ArrayList<String> nameArray;
    ArrayList<Integer> idArray;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        listView = findViewById(R.id.listView);
        nameArray = new ArrayList<>();
        idArray = new ArrayList<>();

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nameArray);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(Profil.this,ProfiliGuncelle.class);
                intent.putExtra("id", idArray.get(i));
                intent.putExtra("info", "old");
                startActivity(intent);

            }
        });

        getData();

    }

    public void getData() {

        try {
            SQLiteDatabase database = this.openOrCreateDatabase("KisiselBilgiler", MODE_PRIVATE, null);
            Cursor cursor = database.rawQuery("SELECT * FROM kisiselbilgiler", null);
            int nameIndex = cursor.getColumnIndex("name");
            int idIndex = cursor.getColumnIndex("id");

            while (cursor.moveToNext()) {
                nameArray.add(cursor.getString(nameIndex));
                idArray.add(cursor.getInt(idIndex));
            }
            arrayAdapter.notifyDataSetChanged();
            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_information, menu);
        menuInflater.inflate(R.menu.main_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.add_information_to_db) {
            Intent intent = new Intent(Profil.this, ProfiliGuncelle.class);
            intent.putExtra("info", "new");
            startActivity(intent);
        }

        switch (item.getItemId()) {

            case R.id.share_button:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Bu harika antrenman programını seninle paylaşıyorum: ";
                String shareSubject = "BeFit, iyi ki!";

                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);

                startActivity(Intent.createChooser(sharingIntent, "Şununla paylaş: "));
                break;
        }

            return super.onOptionsItemSelected(item);
    }
}
