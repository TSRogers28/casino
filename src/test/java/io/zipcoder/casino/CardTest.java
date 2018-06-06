package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void cardConstructorTest() {
        Face expected = Face.ACE;
        Suit expected2 = Suit.CLUBS;

        Card c = new Card(Face.ACE, Suit.CLUBS);

        Face actual = c.getFace();
        Suit actual2 = c.getSuit();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }
    @Test
    public void toStringTest() {
        String expected = "ACE of CLUBS";
        Card c = new Card(Face.ACE, Suit.CLUBS);
        String actual = c.toString();
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void compareToTest() {
        Card c = new Card(Face.ACE, Suit.CLUBS);
        Card c2 = new Card(Face.SIX, Suit.DIAMONDS);
        int actual = c.compareTo(c2);
        Assert.assertTrue(actual > 0);
    }
    @Test
    public void compareToTest2() {
        Card c = new Card(Face.JACK, Suit.CLUBS);
        Card c2 = new Card(Face.QUEEN, Suit.DIAMONDS);
        int actual = c.compareTo(c2);
        Assert.assertTrue(actual < 0);
    }
    @Test
    public void compareToTest3() {
        Card c = new Card(Face.JACK, Suit.CLUBS);
        Card c2 = new Card(Face.JACK, Suit.DIAMONDS);
        int actual = c.compareTo(c2);
        Assert.assertTrue(actual == 0);
    }

}