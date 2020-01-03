package com.mustafabaser.befit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProfiliGuncelle extends AppCompatActivity {

    Bitmap selectedImage;
    ImageView imageView;
    EditText name, age, gender, height, weight;
    Button button;

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profili_guncelle);

        imageView = findViewById(R.id.imageView);
        name = findViewById(R.id.dbName);
        age = findViewById(R.id.dbAge);
        gender = findViewById(R.id.dbGender);
        height = findViewById(R.id.dbHeight);
        weight = findViewById(R.id.dbWeight);
        button = findViewById(R.id.buttonSave);

        database = this.openOrCreateDatabase("KisiselBilgiler", MODE_PRIVATE, null);


        Intent intent = getIntent();
        String info = intent.getStringExtra("info");

        if(info.matches("new")){

            name.setText("");
            age.setText("");
            gender.setText("");
            height.setText("");
            weight.setText("");
            button.setVisibility(View.VISIBLE);

        }else{
            int personId = intent.getIntExtra("id", 1);
            button.setVisibility(View.INVISIBLE);


            try{

                Cursor cursor = database.rawQuery("SELECT * FROM kisiselbilgiler WHERE id = ?", new String[] {String.valueOf(personId)});

                int nameIndex = cursor.getColumnIndex("name");
                int ageIndex = cursor.getColumnIndex("age");
                int genderIndex = cursor.getColumnIndex("gender");
                int heightIndex = cursor.getColumnIndex("height");
                int weightIndex = cursor.getColumnIndex("weight");
                int imageIndex = cursor.getColumnIndex("image");

                while (cursor.moveToNext()){
                    name.setText(cursor.getString(nameIndex));
                    age.setText(cursor.getString(ageIndex));
                    gender.setText(cursor.getString(genderIndex));
                    height.setText(cursor.getString(heightIndex));
                    weight.setText(cursor.getString(weightIndex));
                    byte[] bytes = cursor.getBlob(imageIndex);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    imageView.setImageBitmap(bitmap);
                }
                cursor.close();


        }catch (Exception e){

            }

        }
    }

    public void selectImage(View view) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        } else {
            Intent intentToGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intentToGallery, 2);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intentToGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentToGallery, 2);
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            Uri imageData = data.getData();


            try {

                if (Build.VERSION.SDK_INT >= 28) {

                    ImageDecoder.Source source = ImageDecoder.createSource(this.getContentResolver(), imageData);
                    selectedImage = ImageDecoder.decodeBitmap(source);
                    imageView.setImageBitmap(selectedImage);

                } else {

                    selectedImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageData);
                    imageView.setImageBitmap(selectedImage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void dbSave(View view) {

        String dbName = name.getText().toString();
        String dbAge = age.getText().toString();
        String dbGender = gender.getText().toString();
        String dbHeight = height.getText().toString();
        String dbWeight = weight.getText().toString();

        Bitmap smallImage = makeSmallerImage(selectedImage, 300);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        smallImage.compress(Bitmap.CompressFormat.PNG, 50, outputStream);
        byte[] byteArray = outputStream.toByteArray();

        try {
            database = this.openOrCreateDatabase("KisiselBilgiler", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS kisiselbilgiler (id INTEGER PRIMARY KEY, name VARCHAR, age VARCHAR, gender VARCHAR, height VARCHAR, weight VARCHAR, image BLOB)");

            String sqlString = "INSERT INTO kisiselbilgiler (name, age, gender, height, weight, image) VALUES (?, ?, ?, ?, ?, ?)";
            SQLiteStatement sqLiteStatement = database.compileStatement(sqlString);
            sqLiteStatement.bindString(1, dbName);
            sqLiteStatement.bindString(2, dbAge);
            sqLiteStatement.bindString(3, dbGender);
            sqLiteStatement.bindString(4, dbHeight);
            sqLiteStatement.bindString(5, dbWeight);
            sqLiteStatement.bindBlob(6, byteArray);
            sqLiteStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent geriDon = new Intent(this, Profil.class);
        geriDon.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(geriDon);
    }

    public Bitmap makeSmallerImage(Bitmap image, int maximumSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;

        if (bitmapRatio > 1) {
            width = maximumSize;
            height = (int) (width / bitmapRatio);

        } else {
            height = maximumSize;
            width = (int) (height * bitmapRatio);
        }

        return Bitmap.createScaledBitmap(image, width, height, true);
    }
}
