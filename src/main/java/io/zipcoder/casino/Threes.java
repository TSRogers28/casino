package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Iterator;

public class Threes {
    int numberOfDice;
    int sumTemp;
    int rollNumber;
    Player player1 = new Player();
    Player player2 = new Player();
    int sumPlayer1;

    int ante;

    Dice dice = new Dice(numberOfDice);

    public Threes(){
        rollNumber = 0;
    }

    public int getSumTemp(){
        return sumTemp;
    }

    public void setSumTemp(int sumTemp){
        this.sumTemp = sumTemp;
    }

    public int roll(){
        ArrayList<Integer> result = dice.toss();
        Iterator<Integer>arrayIterator = result.iterator();

        while(arrayIterator.hasNext()){
            int die = result.get(arrayIterator.next());
            if(3 == die){
                result.set(die, 0);
            }
            sumTemp += die;
            System.out.print("\t" + result.get(arrayIterator.next()));
        }
        rollNumber++;


        return sumTemp;
    }

    public Player score(Player whichPlayer){
        if(whichPlayer == player1){
            sumPlayer1 = sumTemp;
            System.out.print("\t Your roll #" + rollNumber + " was " + sumPlayer1);
            sumTemp = 0;
        }

    }

    public Player compare(){



    }


}
