package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CardDeckTest {

    @Test
    public void setDeckTest() {
        Card[] expected = { new Card(Face.TWO,Suit.SPADES), new Card(Face.THREE,Suit.SPADES) ,
                            new Card(Face.FOUR,Suit.SPADES), new Card(Face.FIVE,Suit.SPADES),
                            new Card(Face.SIX,Suit.SPADES), new Card(Face.SEVEN,Suit.SPADES),
                            new Card(Face.EIGHT,Suit.SPADES), new Card(Face.NINE,Suit.SPADES),
                            new Card(Face.TEN,Suit.SPADES), new Card(Face.JACK,Suit.SPADES),
                            new Card(Face.QUEEN,Suit.SPADES), new Card(Face.KING,Suit.SPADES),
                            new Card(Face.ACE,Suit.SPADES),
                            new Card(Face.TWO,Suit.HEARTS), new Card(Face.THREE,Suit.HEARTS) ,
                            new Card(Face.FOUR,Suit.HEARTS), new Card(Face.FIVE,Suit.HEARTS),
                            new Card(Face.SIX,Suit.HEARTS), new Card(Face.SEVEN,Suit.HEARTS),
                            new Card(Face.EIGHT,Suit.HEARTS), new Card(Face.NINE,Suit.HEARTS),
                            new Card(Face.TEN,Suit.HEARTS), new Card(Face.JACK,Suit.HEARTS),
                            new Card(Face.QUEEN,Suit.HEARTS), new Card(Face.KING,Suit.HEARTS),
                            new Card(Face.ACE,Suit.HEARTS),
                            new Card(Face.TWO,Suit.DIAMONDS), new Card(Face.THREE,Suit.DIAMONDS) ,
                            new Card(Face.FOUR,Suit.DIAMONDS), new Card(Face.FIVE,Suit.DIAMONDS),
                            new Card(Face.SIX,Suit.DIAMONDS), new Card(Face.SEVEN,Suit.DIAMONDS),
                            new Card(Face.EIGHT,Suit.DIAMONDS), new Card(Face.NINE,Suit.DIAMONDS),
                            new Card(Face.TEN,Suit.DIAMONDS), new Card(Face.JACK,Suit.DIAMONDS),
                            new Card(Face.QUEEN,Suit.DIAMONDS), new Card(Face.KING,Suit.DIAMONDS),
                            new Card(Face.ACE,Suit.DIAMONDS),
                            new Card(Face.TWO,Suit.CLUBS), new Card(Face.THREE,Suit.CLUBS) ,
                            new Card(Face.FOUR,Suit.CLUBS), new Card(Face.FIVE,Suit.CLUBS),
                            new Card(Face.SIX,Suit.CLUBS), new Card(Face.SEVEN,Suit.CLUBS),
                            new Card(Face.EIGHT,Suit.CLUBS), new Card(Face.NINE,Suit.CLUBS),
                            new Card(Face.TEN,Suit.CLUBS), new Card(Face.JACK,Suit.CLUBS),
                            new Card(Face.QUEEN,Suit.CLUBS), new Card(Face.KING,Suit.CLUBS),
                            new Card(Face.ACE,Suit.CLUBS) };

        CardDeck cd = new CardDeck();
        Card[] actual = cd.getDeck();

        Assert.assertEquals(expected[32].toString(), actual[32].toString());


    }
    @Test
    public void testPrintShuffleDeck() {
        CardDeck cd = new CardDeck();

        Card preShuffle = cd.getDeck()[0];
        cd.shuffle();
        Card postShuffle = cd.getDeck()[0];

        Assert.assertNotEquals(preShuffle.toString(), postShuffle.toString());

    }

}

