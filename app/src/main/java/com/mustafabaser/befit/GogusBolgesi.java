package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GogusBolgesi extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gogus_bolgesi);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Barbell Incline Bench Press Medium-Grip", "3 set, 4-6 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Incline Dumbbell Press", "4 set, 8 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Incline Dumbbell Flyes", "4 set, 8-12 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Şınav", "3 set, 12 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Barbell Incline Bench Press Medium-Grip", "3 set, 4-6 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Incline Dumbbell Press", "3 set, 8 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Dumbbell Flyes", "3 set, 8-12 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Decline Barbell Bench Press", "3 set, 4-6 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Decline Barbell Bench Press", "3 set, 8 tekrar"));



        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
