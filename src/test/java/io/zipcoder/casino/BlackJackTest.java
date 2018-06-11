package io.zipcoder.casino;


import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

import io.zipcoder.casino.allCasino.games.BlackJack;

public class BlackJackTest {

//    public static void main(String[] args) {
//        BlackJack blackJack = new BlackJack();
//        blackJack.playGame();
//    }

    @Test
    public void placeBetTest() {
        BlackJack twenty1 = new BlackJack();

        twenty1.placeBet(12);

        int expected = 24;
        int actual = twenty1.payOut();

        Assert.assertEquals(expected, actual);
    }


}