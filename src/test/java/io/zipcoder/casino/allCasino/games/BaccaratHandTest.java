package io.zipcoder.casino.allCasino.games;

import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.ioMessages.Face;
import io.zipcoder.casino.allCasino.ioMessages.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaccaratHandTest {

    BaccaratHand test;
    @BeforeEach
    void setUp() { test = new BaccaratHand();
    }

    @Test
    void add() {
        test.add(new Card(Face.JACK, Suit.CLUBS));
        assertTrue(test.getHandLength() > 0);
    }

    @Test
    void displayHand() {
        test.add(new Card(Face.JACK, Suit.CLUBS));
        test.add(new Card(Face.TEN, Suit.SPADES));
        test.displayHand();
    }

    @Test
    void showHand() {
        test.add(new Card(Face.JACK, Suit.CLUBS));
        test.add(new Card(Face.TEN, Suit.SPADES));
        test.showHand("test hand:");
    }

    @Test
    void getHandLength() {
        test.add(new Card(Face.JACK, Suit.CLUBS));
        test.add(new Card(Face.TEN, Suit.SPADES));
        assertTrue(test.getHandLength() > 1);
    }

    @Test
    void getTotal() {
        test.add(new Card(Face.JACK, Suit.CLUBS));
        test.add(new Card(Face.FIVE, Suit.SPADES));
        int expected = 5;
        int actual = test.getTotal();
        assertEquals(expected,actual);
    }


    @Test
    void getCardValue() {
       test.add(new Card(Face.JACK, Suit.CLUBS));
       int expected = 0;
       int actual = test.getCardValue(test.getCard(0));
       assertEquals(expected,actual);
    }
}