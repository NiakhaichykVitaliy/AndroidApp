package com.example.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button OpenFragmentsActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OpenFragmentsActivityButton = findViewById(R.id.button);
        OpenFragmentsActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragmentsActivity();
            }
        });
    }

    public void openFragmentsActivity() {
        FragmentActivity.openActivity(this);
    }
}