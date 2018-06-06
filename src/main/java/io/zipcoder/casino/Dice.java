package io.zipcoder.casino;

import java.math.*;


public class Dice
{
    private int numDiceRolled;

    public Dice(int num){
        this.numDiceRolled = num;

    }

    public int Roll(){
        numDiceRolled = 5;
        int sumOfRoll = 0;
        //int roll = (int)((6 * Math.random()) + 1);

        for(int i = 0; i < numDiceRolled; i++){

            sumOfRoll += (int)((6 * Math.random()) + 1);


        }

        return sumOfRoll;
    }
}
