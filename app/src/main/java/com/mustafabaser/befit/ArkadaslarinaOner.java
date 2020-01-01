package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ArkadaslarinaOner extends AppCompatActivity {

    EditText mesaj;
    Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arkadaslarina_oner);

        mesaj = findViewById(R.id.editText_Message);
        btSend = findViewById(R.id.bt_send);

        btSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("Şununla paylaş: " + mesaj.getText().toString()));
                intent.putExtra(Intent.EXTRA_TEXT,mesaj.getText().toString());
                startActivity(intent);
            }

    });
    }

}