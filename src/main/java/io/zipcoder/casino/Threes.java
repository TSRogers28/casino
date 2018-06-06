package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Iterator;

public class Threes {
    int number;
    int sum;
    int rollNumber;

    int ante;

    Dice dice = new Dice(5);

    public Threes(){
        
    }

    public int sumDice(){
        ArrayList<Integer> result = dice.toss();
        Iterator<Integer>arrayIterator = result.iterator();

        while(arrayIterator.hasNext()){
            if(3 == result.get(arrayIterator.next())){
                result.set(arrayIterator.next(), 0);
            }
            sum += result.get(arrayIterator.next());
            System.out.print("\t" + arrayIterator.next());
        }
        System.out.print("\t Your roll was " + sum);

        return sum;
    }


}
