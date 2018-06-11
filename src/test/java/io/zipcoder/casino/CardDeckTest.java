

package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;
import io.zipcoder.casino.allCasino.ioMessages.*;
import io.zipcoder.casino.allCasino.card.*;


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


        Assert.assertEquals(expected[0].toString(), actual[0].toString());
        Assert.assertEquals(expected[1].toString(), actual[1].toString());
        Assert.assertEquals(expected[2].toString(), actual[2].toString());
        Assert.assertEquals(expected[3].toString(), actual[3].toString());
        Assert.assertEquals(expected[4].toString(), actual[4].toString());
        Assert.assertEquals(expected[5].toString(), actual[5].toString());
        Assert.assertEquals(expected[6].toString(), actual[6].toString());
        Assert.assertEquals(expected[7].toString(), actual[7].toString());
        Assert.assertEquals(expected[8].toString(), actual[8].toString());
        Assert.assertEquals(expected[9].toString(), actual[9].toString());
        Assert.assertEquals(expected[10].toString(), actual[10].toString());
        Assert.assertEquals(expected[11].toString(), actual[11].toString());
        Assert.assertEquals(expected[12].toString(), actual[12].toString());
        Assert.assertEquals(expected[13].toString(), actual[13].toString());
        Assert.assertEquals(expected[14].toString(), actual[14].toString());
        Assert.assertEquals(expected[15].toString(), actual[15].toString());
        Assert.assertEquals(expected[16].toString(), actual[16].toString());
        Assert.assertEquals(expected[17].toString(), actual[17].toString());
        Assert.assertEquals(expected[18].toString(), actual[18].toString());
        Assert.assertEquals(expected[19].toString(), actual[19].toString());
        Assert.assertEquals(expected[20].toString(), actual[20].toString());
        Assert.assertEquals(expected[21].toString(), actual[21].toString());
        Assert.assertEquals(expected[22].toString(), actual[22].toString());
        Assert.assertEquals(expected[23].toString(), actual[23].toString());
        Assert.assertEquals(expected[24].toString(), actual[24].toString());
        Assert.assertEquals(expected[25].toString(), actual[25].toString());
        Assert.assertEquals(expected[26].toString(), actual[26].toString());
        Assert.assertEquals(expected[27].toString(), actual[27].toString());
        Assert.assertEquals(expected[28].toString(), actual[28].toString());
        Assert.assertEquals(expected[29].toString(), actual[29].toString());
        Assert.assertEquals(expected[30].toString(), actual[30].toString());
        Assert.assertEquals(expected[31].toString(), actual[31].toString());
        Assert.assertEquals(expected[32].toString(), actual[32].toString());
        Assert.assertEquals(expected[33].toString(), actual[33].toString());
        Assert.assertEquals(expected[34].toString(), actual[34].toString());
        Assert.assertEquals(expected[35].toString(), actual[35].toString());
        Assert.assertEquals(expected[36].toString(), actual[36].toString());
        Assert.assertEquals(expected[37].toString(), actual[37].toString());
        Assert.assertEquals(expected[38].toString(), actual[38].toString());
        Assert.assertEquals(expected[39].toString(), actual[39].toString());
        Assert.assertEquals(expected[40].toString(), actual[40].toString());
        Assert.assertEquals(expected[41].toString(), actual[41].toString());
        Assert.assertEquals(expected[42].toString(), actual[42].toString());
        Assert.assertEquals(expected[43].toString(), actual[43].toString());
        Assert.assertEquals(expected[44].toString(), actual[44].toString());
        Assert.assertEquals(expected[45].toString(), actual[45].toString());
        Assert.assertEquals(expected[46].toString(), actual[46].toString());
        Assert.assertEquals(expected[47].toString(), actual[47].toString());
        Assert.assertEquals(expected[48].toString(), actual[48].toString());
        Assert.assertEquals(expected[49].toString(), actual[49].toString());
        Assert.assertEquals(expected[50].toString(), actual[50].toString());
        Assert.assertEquals(expected[51].toString(), actual[51].toString());



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



