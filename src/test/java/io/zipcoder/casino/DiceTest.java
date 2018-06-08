package io.zipcoder.casino;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class DiceTest {



    @Test
    public void doesItRoll(){
        Dice dice1 = new Dice(1);
        ArrayList<Integer> test = dice1.toss();

        int  expected = 1;
        int actual = test.size();
        assertEquals(actual, expected);
    }

    @Test
    public void doesItRoll2(){
        Dice dice2 = new Dice(2);
        ArrayList<Integer> test = dice2.toss();

        int  expected = 2;
        int actual = test.size();
        assertEquals(actual, expected);
    }

    @Test
    public void doesItRoll5(){
        Dice dice5 = new Dice(5);
        ArrayList<Integer> test = dice5.toss();

        int  expected = 5;
        int actual = test.size();
        assertEquals(actual, expected);
    }



    @Test
    public void canYouGetValue1(){
        Dice diceGet = new Dice(1);
        ArrayList<Integer> test = diceGet.toss();

        int  actual = test.get(0);
        assertTrue(1<= actual && actual <= 6);
    }

    @Test
    public void canYouGetValue2(){
        Dice diceGet2 = new Dice(2);
        ArrayList<Integer> test = diceGet2.toss();

        int  actual = test.get(1);
        assertTrue(1<= actual && actual <= 6);
    }

    @Test
    public void canYouGetValue5(){
        Dice diceGet5 = new Dice(5);
        ArrayList<Integer> test = diceGet5.toss();

        int  actual = test.get(4);
        assertTrue(1<= actual && actual <= 6);
    }

    @Test
    public void tossOneDiceValue() {
        Dice diceValue1= new Dice(1);
        ArrayList<Integer> test = diceValue1.toss();

        int actual = test.get(0);

        assertTrue(1<= actual && actual <= 6);
    }

    @Test
    public void tossTwoDiceValues() {
        Dice diceValue2= new Dice(2);
        ArrayList<Integer> test = diceValue2.toss();

        for(int i: test) {

            assertTrue(1 <= i && i <= 6);
        }
    }

    @Test
    public void tossFiveDiceValues() {
        Dice diceValue5= new Dice(5);
        ArrayList<Integer> test = diceValue5.toss();

        for(int i: test) {

            assertTrue(1 <= i && i <= 6);
        }
    }
    
}