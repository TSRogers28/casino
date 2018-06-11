package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;



public class WarTest {

    @Test
    public void dealCardsTest() {
        int expect = 52;
        War war = new War();
        war.deal();
        int actual = war.getPlayer().size() + war.getOpponent().size();
        Assert.assertEquals(expect, actual);

    }

    @Test
    void getNextCardTest() {//cle
        War war = new War();
        war.deal();

        int expect = war.getPlayer().size() - 1;

        war.getNextCard(war.getPlayer());
        int actual = war.getPlayer().size();

        Assert.assertEquals(expect, actual);
    }

    @Test
    void toToWarTest() {
        int expect = 52;
        War war = new War();
        war.deal();
        war.goToWar();

        int actual = war.getPlayer().size() + war.getOpponent().size();
        Assert.assertEquals(expect, actual);
    }

//    @Test
//    void startGameTest() {
//        War war = new War();
//        war.playGame();
//    }
}