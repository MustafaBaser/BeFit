package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class OmuzBolgesi extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omuz_bolgesi);




        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Dumbbell Shoulder Press", "4 set, 6,6,8,10 tekrar (2 dakika dinlen)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Upright Barbell Row", "3 set, 8,8,10 tekrar (2 dakika dinlen)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Seated Bent-Over Rear Delt Raise", "3 set, 8,10,12 tekrar (1 dakika dinlen)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Side Lateral Raise", "3 set, 8,10,12 tekrar (2 dakika dinlen)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Standing Front Barbell Raise Over Head", "3 set, 8,10,12 tekrar (1 dakika dinlen)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Side Lateral Raise", "3 set, 8-12 tekrar (2 dakika dinlen)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Seated Bent-Over Rear Delt Raise", "3 set, 10-12 tekrar (60-90 saniye dinlen)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Front Cable Raise", "3 set, 10-12 tekrar (dinlenme)"));
        exampleList.add(new ExampleItem(R.drawable.ic_biceps, "Upright Cable Row", "3 set, 10-12 tekrar (60-90 saniye dinlen)"));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
