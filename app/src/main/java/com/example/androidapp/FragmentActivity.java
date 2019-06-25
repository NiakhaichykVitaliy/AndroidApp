package com.example.androidapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class FragmentActivity extends AppCompatActivity {

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, FragmentActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_first:
                            loadFragment(new FirstFragment());
                            break;
                        case R.id.action_second:
                            loadFragment(new SecondFragment());
                            break;
                    }
                    return false;
                }
            };

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }
}