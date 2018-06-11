package io.zipcoder.casino;


import io.zipcoder.casino.allCasino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import io.zipcoder.casino.allCasino.card.Card;


import static org.junit.Assert.*;

import io.zipcoder.casino.allCasino.games.BlackJack;

public class BlackJackTest {

    @Test
    public void placeBetTest() {
        BlackJack twenty1 = new BlackJack();
        twenty1.placeBet(12);
        int expected = 24;
        int actual = twenty1.payOut();
        assertEquals(expected, actual);
    }

    @Test
    public void dealTest1() {
        BlackJack twenty1 = new BlackJack();
        twenty1.deal();
        int expected = 2;
        int actual = twenty1.getDealerCards().length;
        assertEquals(expected, actual);
    }
    @Test
    public void dealTest2() {
        BlackJack twenty1 = new BlackJack();
        twenty1.deal();
        int expected = 2;
        int actual = twenty1.getPlayerCards().length;
        assertEquals(expected, actual);
    }
    @Test
    public void getWinnerTest() {
        BlackJack twenty1 = new BlackJack();
        Boolean expected = false;
        Boolean actual = twenty1.getWinner();
        assertEquals(expected, actual);
    }
    @Test
    public void resetTest1() {
        BlackJack twenty1 = new BlackJack();
        twenty1.deal();
        twenty1.reset();
        Card[] expected = new Card[0];
        Card[] actual = twenty1.getPlayerCards();
        assertEquals(actual, expected);
    }
    @Test
    public void resetTest2() {
        BlackJack twenty1 = new BlackJack();
        twenty1.deal();
        twenty1.reset();
        Card[] expected = new Card[0];
        Card[] actual = twenty1.getDealerCards();
        assertEquals(actual, expected);
    }
    @Test
    public void getHelloKittyFunBucksTest() {
        BlackJack twenty1 = new BlackJack();
        Player p = new Player(100, "KittyKrusher");
        int expected = 100;
        int actual = twenty1.checkKittyBucksBalance(p);
        assertEquals(expected, actual);
    }
    @Test
    public void hitTest() {
        BlackJack twenty1 = new BlackJack();
        twenty1.deal();
        twenty1.hit();
        int expected = 3;
        int actual = twenty1.getPlayerCards().length;
        assertEquals(expected, actual);
    }
    @Test
    public void endOfTurnTest() {
        BlackJack twenty1 = new BlackJack();
        twenty1.endOfTurn(21);
        boolean actual = twenty1.getIsOver();
        assertTrue(actual);
    }
    @Test
    public void endOfTurnTest2() {
        BlackJack twenty1 = new BlackJack();
        twenty1.endOfTurn(16);
        boolean actual = twenty1.getIsOver();
        assertFalse(actual);
    }
    @Test
    public void endOfTurnTest3() {
        BlackJack twenty1 = new BlackJack();
        twenty1.endOfTurn(28);
        boolean actual = twenty1.getIsOver();
        assertTrue(actual);
    }


}