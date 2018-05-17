package com.b2mb.mobile_experience;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
