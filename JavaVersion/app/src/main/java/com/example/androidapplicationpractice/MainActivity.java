package com.example.androidapplicationpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private ViewpagerFragmentStatAdapter viewpagerFragmentStatAdapter;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> pagetitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments=new ArrayList<>();
        pagetitles=new ArrayList<>();

        pagetitles.add("First");
        pagetitles.add("Second");
        pagetitles.add("Third");

        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());

        viewPager2=findViewById(R.id.id_viewpager2);
        tabLayout=findViewById(R.id.id_tablayout2);

        viewpagerFragmentStatAdapter=new ViewpagerFragmentStatAdapter(this,fragments);
        viewPager2.setAdapter(viewpagerFragmentStatAdapter);

        new TabLayoutMediator(tabLayout,viewPager2,
                (tab, position) -> tab.setText(pagetitles.get(position)))
                .attach();
    }
}