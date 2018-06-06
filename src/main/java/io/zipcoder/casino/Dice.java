package io.zipcoder.casino;

public class Dice {

    private int numOfDice;

    public Dice(int numOfDice){
        this.numOfDice = numOfDice;

    }


    public int tossAndSum(){
        int landedOn = 0;
        for(int x = 0; x < numOfDice; x++){
            landedOn = (int) (6*Math.random() +1);

        }
        return landedOn;
    }
}
