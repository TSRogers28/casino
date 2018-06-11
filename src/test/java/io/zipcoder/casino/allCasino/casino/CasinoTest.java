package io.zipcoder.casino.allCasino.casino;

import io.zipcoder.casino.allCasino.games.BlackJack;
import io.zipcoder.casino.allCasino.interfaces.Game;
import org.junit.jupiter.api.Test;
import sun.util.resources.is.CalendarData_is;

import static org.junit.jupiter.api.Assertions.*;

class CasinoTest {

    //validates player name setter/getter
    @Test
    void welcome1() {
        Casino casino = new Casino();
        casino.player1.setName("billy");

        String actual = casino.player1.getName();
        String expected = "billy";

        assertEquals(expected,actual);
    }

    //validates player credits setter/getter
    @Test
    void welcome2() {
        Casino casino = new Casino();
        casino.player1.setHelloKittyFunBucks(1000);

        int actual = casino.player1.getHelloKittyFunBucks();
        int expected = 1000;

        assertEquals(expected,actual);
    }

    //validates addCredits functionality
    @Test
    void enterCasino1() {
        Casino casino = new Casino();
        casino.player1.setHelloKittyFunBucks(100);
        casino.player1.addHelloKittyFunBucks(1000);

        int actual = casino.player1.getHelloKittyFunBucks();
        int expected = 1100;

        assertEquals(expected, actual);
    }

//    @Test
//    void leaveCasino() {
//    }
//
//    @Test
//    void playGames() {
//    }

    //validates chooseGame functionality
    @Test
    void chooseGameTest() {
        Casino casino = new Casino();
        casino.chooseGame("blackjack");

        Game actual = casino.getGame();


        assertTrue(actual instanceof BlackJack);
        }
    }
