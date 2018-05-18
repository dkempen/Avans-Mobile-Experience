package com.b2mb.mobile_experience.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.b2mb.mobile_experience.R;

public class MainActivity extends AppCompatActivity {

    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        help = findViewById(R.id.startHelpButton);
        help.setOnClickListener((View) -> {
            Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
            startActivity(intent);
        });

    }
}
