package io.zipcoder.casino;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class DiceTest {



    @Test
    public void doesItRoll(){
        Dice dice = new Dice(1);
        ArrayList<Integer> test = dice.toss();

        int  expected = 1;
        int actual = test.size();
        assertEquals(actual, expected);
    }

    @Test
    public void tossOneDice() {
        Dice dice = new Dice(1);
        ArrayList<Integer> actual = dice.toss();


        //assertEquals(actual.get(0));
    }

    @Test
    public void toss() {
    }








}