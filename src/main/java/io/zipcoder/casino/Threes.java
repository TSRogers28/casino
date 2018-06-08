package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Iterator;

public class Threes {
    int numberOfDice;
    int sum;
    int rollNumber;

    int ante;

    Dice dice = new Dice(5);

    public Threes(){
        rollNumber = 0;
    }

    public int roll(){
        ArrayList<Integer> result = dice.toss();
        Iterator<Integer>arrayIterator = result.iterator();

        while(arrayIterator.hasNext()){
            int die = result.get(arrayIterator.next());
            if(3 == die){
                result.set(die, 0);
            }
            sum += die;
            System.out.print("\t" + result.get(arrayIterator.next()));
        }
        rollNumber++;
        System.out.print("\t Your  roll #" + rollNumber + " was " + sum);

        return sum;
    }


}
