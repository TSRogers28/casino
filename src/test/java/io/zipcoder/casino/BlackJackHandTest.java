package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackHandTest {

    BlackJackHand bjh;

    @Before
    public void setup() {
        bjh = new BlackJackHand();
    }
    @Test
    public void displayHandTest() {
        bjh.add(new Card(Face.JACK, Suit.CLUBS));
        bjh.add(new Card(Face.QUEEN, Suit.HEARTS));
        bjh.displayHand();

    }
    @Test
    public void displayDealerHandTest() {
        bjh.add(new Card(Face.SIX, Suit.CLUBS));
        bjh.add(new Card(Face.EIGHT, Suit.CLUBS));
        bjh.displayDealerHand();
    }
    @Test
    public void tallyTest() {
        bjh.add(new Card(Face.ACE, Suit.SPADES));
        bjh.add(new Card(Face.ACE, Suit.HEARTS));
        bjh.add(new Card(Face.ACE, Suit.DIAMONDS));
        bjh.add(new Card(Face.ACE, Suit.CLUBS));

        int expected = 14;
        int actual = bjh.getTotal();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void tallyTest2() {
        bjh.add(new Card(Face.ACE, Suit.SPADES));
        bjh.add(new Card(Face.ACE, Suit.HEARTS));
        bjh.add(new Card(Face.QUEEN, Suit.DIAMONDS));
        bjh.add(new Card(Face.NINE, Suit.CLUBS));
        int expected = 21;
        int actual = bjh.getTotal();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void tallyTest3() {
        bjh.add(new Card(Face.EIGHT, Suit.SPADES));
        bjh.add(new Card(Face.ACE, Suit.HEARTS));
        bjh.add(new Card(Face.QUEEN, Suit.DIAMONDS));
        bjh.add(new Card(Face.NINE, Suit.CLUBS));
        int expected = 28;
        int actual = bjh.getTotal();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void tallyTest4() {
        bjh.add(new Card(Face.SEVEN, Suit.SPADES));
        bjh.add(new Card(Face.THREE, Suit.HEARTS));
        bjh.add(new Card(Face.FOUR, Suit.DIAMONDS));
        bjh.add(new Card(Face.TWO, Suit.CLUBS));
        int expected = 16;
        int actual = bjh.getTotal();
        Assert.assertEquals(expected, actual);
    }



}