

package io.zipcoder.casino;

import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardDeck;
import io.zipcoder.casino.allCasino.ioMessages.Face;
import io.zipcoder.casino.allCasino.ioMessages.Suit;
import org.junit.Assert;
import org.junit.Test;


public class CardDeckTest {

    @Test
    public void setDeckTest() {
        CardDeck cd = new CardDeck();
        Card[] actual = cd.getDeck();
        Assert.assertEquals(new Card(Face.TWO,Suit.SPADES).toString(), actual[0].toString());
        Assert.assertEquals(new Card(Face.ACE,Suit.CLUBS).toString(), actual[51].toString());
        Assert.assertEquals(52, actual.length);
    }
    @Test
    public void testShuffleDeck() {
        CardDeck cd = new CardDeck();

        Card preShuffle = cd.getDeck()[0];
        Card preShuffle2 = cd.getDeck()[51];

        cd.shuffle();

        Card postShuffle = cd.getDeck()[0];
        Card postShuffle2 = cd.getDeck()[51];

        boolean firstEqual = preShuffle.toString().equals(postShuffle.toString());
        boolean lastEqual = preShuffle2.toString().equals(postShuffle2.toString());
        Assert.assertFalse(firstEqual && lastEqual);
    }
    @Test
    public void drawCardTest() {
        CardDeck cd = new CardDeck();
        cd.drawCard();
        cd.drawCard();
        cd.drawCard();
        int expected = 49;
        int actual = cd.getNumberOfCardsRemaining();
        Assert.assertEquals(expected, actual);
    }

}



