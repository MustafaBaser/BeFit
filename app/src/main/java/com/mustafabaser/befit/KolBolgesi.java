package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class KolBolgesi extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kol_bolgesi);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Close-Grip Barbell Bench Press", "3 set, 4-6 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Cable Rope Overhead Triceps Extension", "2 set, 8-12 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Triceps Pushdown", "2 set, 15 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Barbell Curl", "3 set, 4-6 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Dumbbell Alternate Bicep Curl", "2 set, 18 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Standing Biceps Cable Curl", "3 set, 15 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Palms-Down Wrist Curl Over A Bench", "5 set, 25 tekrar"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
