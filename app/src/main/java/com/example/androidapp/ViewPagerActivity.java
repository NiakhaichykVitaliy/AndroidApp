package com.example.androidapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, ViewPagerActivity.class);
        context.startActivity(intent);
    }

    private ViewPager pager;
    private PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());

        pager = findViewById(R.id.view_pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragmentList);

        pager.setAdapter(pagerAdapter);
    }
}
