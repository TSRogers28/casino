package io.zipcoder.casino;

import org.junit.Test;

import static org.junit.Assert.*;
import io.zipcoder.casino.allCasino.player.*;
import io.zipcoder.casino.allCasino.dice.*;
import io.zipcoder.casino.allCasino.games.Threes;
import io.zipcoder.casino.allCasino.interfaces.*;


public class ThreesTest {


    private Player player1;



    @Test
    public void setSumTemp() {
    }

    @Test
    public void choosePlayer() {
    }

    @Test
    public void roll() {
    }

    @Test
    public void score() {
    }

    @Test
    public void compareForWinner() {
        Threes tester = new Threes();
        int sumPlayer1 = 15;
        int sumPlayer2 = 20;

        Player expected = player1;
        Player actual = tester.compareForWinner(sumPlayer1, sumPlayer2);
        assertEquals(actual, expected);
        
    }

}