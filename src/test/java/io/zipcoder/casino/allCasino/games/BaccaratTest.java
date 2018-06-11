package io.zipcoder.casino.allCasino.games;

import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardDeck;
import io.zipcoder.casino.allCasino.interfaces.Game;
import io.zipcoder.casino.allCasino.ioMessages.Face;
import io.zipcoder.casino.allCasino.ioMessages.Suit;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaccaratTest {

    @Test
    void reset() {
        Baccarat baccarat = new Baccarat();
        baccarat.reset();

        assertTrue( baccarat.getDeck().getNumberOfCardsRemaining() == 52);
    }

    @Test
    void reset2() {
        Baccarat baccarat = new Baccarat();
        baccarat.reset();

        assertTrue(baccarat.getBankerStands() != true);
    }

    @Test
    void reset3() {
        Baccarat baccarat = new Baccarat();
        baccarat.reset();

        assertTrue(baccarat.getPlayerStands() != true);
    }

    @Test
    void reset4() {
        Baccarat baccarat = new Baccarat();
        baccarat.reset();

        assertTrue(baccarat.getBankerHand().getHandLength() == 0);
    }

    @Test
    void reset5() {
        Baccarat baccarat = new Baccarat();
        baccarat.reset();

        assertTrue(baccarat.getPlayerHand().getHandLength() == 0);
    }

    @Test
    void getWinner() {
        Baccarat baccarat = new Baccarat();
        baccarat.setWinner(Baccarat.BaccaratPlayer.player);
        baccarat.setPlayerBetOn("player");

        assertTrue(baccarat.getWinner());
    }

    @Test
    void naturalWinner() {
        Baccarat baccarat = new Baccarat();
        baccarat.setPlayerHand((new Card(Face.EIGHT,Suit.SPADES)),(new Card(Face.ACE,Suit.CLUBS)));
        baccarat.setPlayerBetOn("player");

        assertTrue(baccarat.naturalWinner());
    }

    @Test
    void placeBet() {
        Baccarat baccarat = new Baccarat();
        baccarat.placeBet(5);

        assertTrue(baccarat.getPot() == 10);
    }

    @Test
    void payOut() {
        Baccarat baccarat = new Baccarat();
        baccarat.setPot(10);

        assertTrue(baccarat.getPot() == 10);
    }

//    @Test
//    void checkKittyBucksBalance() {
//    }

    @Test
    void deal() {
        Baccarat baccarat = new Baccarat();
        baccarat.deal();

        assertTrue((baccarat.getPlayerHand().getHandLength() == 2)&&
                (baccarat.getBankerHand().getHandLength() == 2));
    }

//    @Test
//    void bankerVs2PlayerCards() {
//
//    }
//
//    @Test
//    void bankerVs3PlayerCards() {
//    }

    @Test
    void bankerHandAndStand() {
        Baccarat baccarat = new Baccarat();
        baccarat.bankerHandAndStand();

        assertTrue(baccarat.getBankerStands());
    }

    @Test
    void determineWinner() {
        Baccarat baccarat = new Baccarat();
        baccarat.setPlayerBetOn("player");
        baccarat.deal();
        baccarat.determineWinner();

        assertTrue(baccarat.getWinner());

    }
}