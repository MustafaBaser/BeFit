package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BacakBolgesi extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacak_bolgesi);


        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Barbell Squat", "4 set, 4-6 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Dumbbell Lunges", "2 set, 8-12 tekrar (her bacak için ayrı 8-12 tekrar)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Leg Press", "3 set, 12-15 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Lying Leg Curls", "3 set, 12 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Leg Extensions", "3 set, 20 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Standing Calf Raises", "4 set, 12 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Barbell Deadlift", "4 set, 4-6 tekrar"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Dumbbell Rear Lunge", "4 set, 15 tekrar"));



        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
