package io.zipcoder.casino.allCasino.dice;

import java.util.ArrayList;


public class Dice {

    private int numOfDice;

    public  Dice(int numOfDice){
        this.numOfDice = numOfDice;

    }


    public ArrayList<Integer> toss(){
        int landedOn = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int x = 0; x < numOfDice; x++){
            landedOn = (int) (6*Math.random() +1);
            result.add(landedOn);
        }
        return result;

    }
}
