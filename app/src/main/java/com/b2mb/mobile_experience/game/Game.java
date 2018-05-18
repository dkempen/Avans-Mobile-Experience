package com.b2mb.mobile_experience.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    private static Game instance;
    private ArrayList<Integer> sequence = new ArrayList<>();
    private int sequenceIndex = 0;
    private Timer timer;
    private Game() {
        sequence = createSequence();
        timer = new Timer();
    }

    public void start() {
        timer.scheduleAtFixedRate(getSequenceTask(),1500,1500);
    }

    private TimerTask getSequenceTask() {
        return new TimerTask() {
            @Override
            public void run() {
                play();
            }
        };
    }

    public void play() {
        if(sequenceIndex > 3)
            timer.cancel();
        else {
            System.out.println(sequence.get(sequenceIndex));
            sequenceIndex++;
        }
    }

    private ArrayList<Integer> createSequence() {
        ArrayList<Integer> tempSequenceList = new ArrayList<>();
        for(int i = 0; i < 4; i++)
            tempSequenceList.add(getRandomNumber());
        return tempSequenceList;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(4);
    }

    public ArrayList<Integer> getSequence() {
        return sequence;
    }

    public static Game getInstance(){
        if(instance == null)
            instance = new Game();
        return instance;
    }
}
