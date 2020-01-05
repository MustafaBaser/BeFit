package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SirtBolgesi extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sirt_bolgesi);


        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Chin-Up", "5 set, 8-10 tekrar (Ağırlık eklenebilir)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Bent Over Barbell Row", "5 set, 8-10 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "T-Bar Row with Handle", "5 set, 8-10 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Barbell Deadlift", "5 set, 8-10 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Bent Over Barbell Row", "3 set, 8-10 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "One-Arm Dumbbell Row", "4 set, 8-10 tekrar (her kol için ayrı)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "T-Bar Row with Handle", "5 set, 8-10 tekrar"));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
