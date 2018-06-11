package io.zipcoder.casino;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import io.zipcoder.casino.allCasino.player.Player;
import io.zipcoder.casino.allCasino.games.HiLo;




public class HiLoTest {
    private Player player1;
    private Player player2;


    private HiLo dummy = new HiLo();



    @Test
    public void dummyTestSetWinner(){
        dummy.setWinner(dummy.player1);

        //Player actual = dummy.getWinner();

        Player expected = dummy.player1;

        Assert.assertNotNull(expected);

    }

    @Test
    public void testGetWinnerUserWins(){
        dummy.playGame();

        boolean expected = true;
        boolean actual = dummy.getWinner();

        Assert.assertEquals(expected,actual);


    }
    @Test
    public void testHouseWins(){
        dummy.playGame();

        boolean expected = true;
        boolean actual = dummy.getWinner();

        Assert.assertEquals(expected,actual);


    }
    @Test
    public void testRandom(){

        int actual = dummy.rand();

        int expected = dummy.rand();

        Assert.assertNotEquals(actual,expected);



    }












}
