package io.zipcoder.casino;


import io.zipcoder.casino.allCasino.games.BlackJack;
import org.junit.Assert;
import org.junit.Test;

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