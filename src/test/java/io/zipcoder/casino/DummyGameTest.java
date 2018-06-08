package io.zipcoder.casino;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.zipcoder.casino.allCasino.player.Player;
import io.zipcoder.casino.allCasino.games.DummyGame;




public class DummyGameTest {
    private Player player1;
    private Player player2;


    private DummyGame dummy = new DummyGame();



    @Test
    public void dummyTestWinner(){
        dummy.setWinner(dummy.player1);

        Player actual = dummy.getWinner();

        Player expected = dummy.player1;

        Assertions.assertEquals(actual,expected);

    }
    @Test
    public void testRandom(){

        int actual = dummy.rand();

        int expected = dummy.rand();

        Assertions.assertEquals(actual,expected);


    }

    @Test
    public void testScore(){

        int actual = dummy.rand();

        int expected = dummy.rand();

        Assertions.assertNotEquals(actual,expected);


    }








}
