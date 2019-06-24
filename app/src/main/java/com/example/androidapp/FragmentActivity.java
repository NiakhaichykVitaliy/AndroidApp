package com.example.androidapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FragmentActivity extends AppCompatActivity {

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, FragmentActivity.class);
        context.startActivity(intent);
    }

    private TextView textHome;
    private TextView textFavorites;
    private TextView textSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        textHome = findViewById(R.id.text_home);
        textFavorites = findViewById(R.id.text_favorites);
        textSettings = findViewById(R.id.text_settings);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                textHome.setVisibility(View.VISIBLE);
                                textFavorites.setVisibility(View.GONE);
                                textSettings.setVisibility(View.GONE);
                                break;
                            case R.id.action_favorite:
                                textHome.setVisibility(View.GONE);
                                textFavorites.setVisibility(View.VISIBLE);
                                textSettings.setVisibility(View.GONE);
                                break;
                            case R.id.action_settings:
                                textHome.setVisibility(View.GONE);
                                textFavorites.setVisibility(View.GONE);
                                textSettings.setVisibility(View.VISIBLE);
                                break;
                        }
                        return false;
                    }
                });
    }
}