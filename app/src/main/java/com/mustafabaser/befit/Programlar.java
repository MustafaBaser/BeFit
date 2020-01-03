package com.mustafabaser.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.FrameMetrics;
import android.view.WindowManager;

import com.mustafabaser.befit.fragments.PageFragment1;
import com.mustafabaser.befit.fragments.PageFragment2;
import com.mustafabaser.befit.fragments.PageFragment3;
import com.mustafabaser.befit.fragments.PageFragment4;
import com.mustafabaser.befit.fragments.PageFragment5;

import java.util.ArrayList;
import java.util.List;

public class Programlar extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_programlar);

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());
        list.add(new PageFragment5());
        list.add(new PageFragment4());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SliderPagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);

    }
}
