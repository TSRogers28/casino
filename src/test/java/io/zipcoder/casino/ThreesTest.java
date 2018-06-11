package io.zipcoder.casino;

import io.zipcoder.casino.allCasino.games.Threes;
import io.zipcoder.casino.allCasino.player.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreesTest {


    @Test

    public void testSetWinnerPlayer1() {
        Threes threes = new Threes();
        Player player1 = new Player(500, "You");;

        threes.setWinner(threes.getPlayer1());

        boolean actual = threes.getWinner();

        assertTrue(actual);
    }

    @Test
    public void testSetWinnerPlayer2() {
        Threes test = new Threes();
        Player player2 = new Player(100_000,"House");

        test.setWinner(test.getPlayer2());

        boolean actual = test.getWinner();

        assertFalse(actual);
    }



    @Test
    public void testPlaceBet(){
        Threes threes = new Threes();

        threes.placeBet(500);

        int expected = 1000;
        int actual = threes.payOut();

        assertEquals(actual, expected);
    }

    @Test
    public void testCheckKittyBucksBalance(){
        Threes threes = new Threes();
        Player player1 = new Player(500, "You");

        int expected = 500;
        int actual = threes.checkKittyBucksBalance(player1);

        assertEquals(actual, expected);
    }

    @Test
    public void testSetSumPlayer1(){
        Threes threes = new Threes();
        threes.setSumPlayer1(30);

        int expected = 30;
        int actual = threes.getSumPlayer1();

        assertEquals(actual, expected);
    }

    @Test
    public void testSetSumPlayer2(){
        Threes threes = new Threes();
        threes.setSumPlayer2(10);

        int expected = 10;
        int actual = threes.getSumPlayer2();

        assertEquals(actual, expected);
    }

    @Test
    public void testSetRollNumber(){
        Threes threes = new Threes();
        threes.setRollNumber(5);

        int expected = 5;
        int actual = threes.getRollNumber();

        assertEquals(actual, expected);

    }


    @Test
    public void sumAndDisplayThreesEqualsZero() {
        Threes tester2 = new Threes();
        ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(3, 3, 3, 3, 3));

        int expected = 0;
        int actual = tester2.displayDiceAndSum(result);

        assertEquals(actual, expected);
    }

    @Test
    public void sumAndDisplayCorrectSum() {
        Threes tester = new Threes();
        ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(5, 6, 3, 4, 1));

        int expected = 16;
        int actual = tester.displayDiceAndSum(result);

        assertEquals(actual, expected);
    }


    @Test
    public void compareForWinnerPlayerOne() {
        Threes tester = new Threes();
        int sumPlayer1 = 15;
        int sumPlayer2 = 20;

        Player player1 = new Player(500, "You");

        String expected = player1.getName();
        Player actual = tester.compareForWinner(sumPlayer1, sumPlayer2);
        assertEquals(actual.getName(), expected);

    }
    @Test
    public void compareForWinnerPlayerTwo() {
        Threes tester2 = new Threes();
        int sumPlayer1 = 25;
        int sumPlayer2 = 10;

        Player player2 = new Player(100_000,"House");

        String expected = player2.getName();
        Player actual = tester2.compareForWinner(sumPlayer1, sumPlayer2);
        assertEquals(actual.getName(), expected);

    }






}