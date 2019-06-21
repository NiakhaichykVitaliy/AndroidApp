package com.example.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button openFragmentsActivityButton;
    private Button openViewPagerActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openFragmentsActivityButton = findViewById(R.id.fragments_activity_button);
        openFragmentsActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragmentsActivity();
            }
        });

        openViewPagerActivity = findViewById(R.id.view_pager_activity_button);
        openViewPagerActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewPagerActivity();
            }
        });
    }

    public void openFragmentsActivity() {
        FragmentActivity.openActivity(this);
    }

    public void openViewPagerActivity() {
        ViewPagerActivity.openActivity(this);
    }
}