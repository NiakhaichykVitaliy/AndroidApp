package com.example.androidapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
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

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationListner);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.action_favorite:
                            selectedFragment = new FavoritesFragment();
                            break;
                        case R.id.action_settings:
                            selectedFragment = new SettingsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment,
                            selectedFragment).commit();
                    return true;
                }
            };
}