package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class KarinBolgesi extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karin_bolgesi);


        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_timer, "Mekik", "En az 15-20 tekrar veya çıkabildiğin kadar"));
        exampleList.add(new ExampleItem(R.drawable.ic_timer, "Flat Bench Lying Leg Raise", "15-20 tekrar veya çıkabildiğin kadar"));
        exampleList.add(new ExampleItem(R.drawable.ic_timer, "Jackknife Sit-Up", "15-20 tekrar veya çıkabildiğin kadar"));
        exampleList.add(new ExampleItem(R.drawable.ic_timer, "Flat Bench Leg Pull-In", "15-20 tekrar veya çıkabildiğin kadar"));
        exampleList.add(new ExampleItem(R.drawable.ic_timer, "Toe Touchers", "15-20 tekrar veya çıkabildiğin kadar"));
        exampleList.add(new ExampleItem(R.drawable.ic_timer, "Crunches (Yarım mekik)", "15-20 tekrar veya çıkabildiğin kadar"));
        exampleList.add(new ExampleItem(R.drawable.ic_timer, "Reverse Crunch", "15-20 tekrar veya çıkabildiğin kadar"));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
