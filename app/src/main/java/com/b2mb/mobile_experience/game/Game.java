package com.b2mb.mobile_experience.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The game class represents the simon says game that will be played at the end of the user's journey.
 * This class is a singleton.
 */
public class Game {
    /**
     * Test main for the sequence.
     * @param args not important.e
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    /**
     * The instance Attribute represents a instance of this class.
     * This is needed for a singleton so that the the attribute instance has always the same reference.
     */
    private static Game instance;

    /**
     * The sequence attribute is the list with the upcoming sequences of the game.
     * After playing one sequence this list need to be cleared.
     */
    private ArrayList<Integer> sequence = new ArrayList<>();

    /**
     * The sequenceIndex which place the game is in the sequence list.
     * This attribute must be cleared after the sequence is finished.
     */
    private int sequenceIndex = 0;

    /**
     * The timer attribute regulates the time a light is played.
     */
    private Timer timer;

    /**
     * The game constructor creates the first sequence and initialize the timer attribute.
     */
    private Game() {
        sequence = createSequence();
        timer = new Timer();
    }

    /**
     * The start method starts a timer that will play the lights on the light display.
     */
    public void start() {
        timer.scheduleAtFixedRate(getSequenceTask(),5000,5000);
    }

    /**
     * The getSequenceTask method creates a TimerTask object which play the s
     * @return a TimerTask object which contains the sequence that will be played.
     */
    private TimerTask getSequenceTask() {
        return new TimerTask() {
            @Override
            public void run() {
                play();
            }
        };
    }

    /**
     * The play method plays the sequence. This method may only be called in a TimerTask class.
     */
    private void play() {
        if(sequenceIndex > 3)
            timer.cancel();
        else {
            System.out.println(sequence.get(sequenceIndex));
            sequenceIndex++;
        }
    }

    /**
     * The createSequence method creates a list of Integers which represent the sequence.
     * @return a ArrayList of Integers which represents the sequence.
     */
    private ArrayList<Integer> createSequence() {
        ArrayList<Integer> tempSequenceList = new ArrayList<>();
        for(int i = 0; i < 4; i++)
            tempSequenceList.add(getRandomNumber());
        return tempSequenceList;
    }

    /**
     * The getRandomNumber method generates a random number between 0 and 3.
     * @return an int between 0 and 3.
     */
    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(4);
    }

    /**
     * The getSequence method gets the sequence attribute.
     * @return an ArrayList of Integers representing the sequence attribute.
     */
    public ArrayList<Integer> getSequence() {
        return sequence;
    }

    /**
     * The getInstance method created an instance if the instance attribute is even to null and returns instance.
     * If the instance object already exist, the instance object will be returned.
     * @return the one and only instance of this class.
     */
    public static Game getInstance(){
        if(instance == null)
            instance = new Game();
        return instance;
    }
}
