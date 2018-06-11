package io.zipcoder.casino;

import io.zipcoder.casino.allCasino.games.Threes;
import io.zipcoder.casino.allCasino.player.Player;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreesTest {


    private Player player1;

    @Test
    public void testSetSum() {
        Threes threes = new Threes();
        threes.setSum(15);

        int expected = 15;
        int actual =  threes.getSum();

        assertEquals(actual, expected);
    }

    @Test
    public void choosePlayer() {
    }

    @Test
    public void roll() {

    }

    @Test
    public void rollThreesEqualsZero() {

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