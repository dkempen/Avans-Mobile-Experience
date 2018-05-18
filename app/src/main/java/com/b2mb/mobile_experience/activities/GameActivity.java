package com.b2mb.mobile_experience.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.b2mb.mobile_experience.R;
import com.b2mb.mobile_experience.game.Game;

public class GameActivity extends AppCompatActivity {


    private Button blueButton, redButton, greenButton, yellowButton;

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.start();
        game.onFullyUserInput();
        game.addSequenceInputFromUser(1);
        game.addSequenceInputFromUser(2);
        game.addSequenceInputFromUser(3);
        game.addSequenceInputFromUser(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Game game = Game.getInstance();

        blueButton.setOnClickListener((v -> game.addSequenceInputFromUser(0)));
        redButton.setOnClickListener((v -> game.addSequenceInputFromUser(1)));
        greenButton.setOnClickListener((v -> game.addSequenceInputFromUser(2)));
        yellowButton.setOnClickListener((v -> game.addSequenceInputFromUser(3)));
    }
}
