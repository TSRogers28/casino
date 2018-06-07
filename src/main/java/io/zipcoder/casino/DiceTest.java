package io.zipcoder.casino;

import java.util.ArrayList;

import static  org.junit.jupiter.api.Assertions.*;

class DiceTest {
    int numOfDice;

    public Dice(int numOfDice){
        this.numOfDice = numOfDice;

    }

    @org.junit.jupiter.api.Test
    public void testTossOneDice() {
        Dice dice = new Dice(1);
        ArrayList<Integer> actual = dice.toss();


    assertEquals(actual.get(0));
    }

    @Test doesItRoll(){
        Dice dice = new Dice(1);
        ArrayList<Integer> test = dice.toss();

       int  expected = 1;
       int actual = test.size();
        assertEquals(actual, expected);
    }
    public void



    @org.junit.Test
    public void toss() {
    }
}