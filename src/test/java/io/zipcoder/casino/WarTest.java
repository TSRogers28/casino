package io.zipcoder.casino;

//import org.junit.Test;
//import org.junit.Assert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WarTest {

    @Test
    public void dealCardsTest() {
        int expect = 52;
        War war = new War();
        war.deal();
        int actual = war.getPlayer().size() + war.getOpponent().size();
        Assertions.assertEquals(expect, actual);

    }

    @Test
    void getNextCardTest() {
        War war = new War();
        war.deal();

        int expect = war.getPlayer().size() - 1;

        war.getNextCard(war.getPlayer());
        int actual = war.getPlayer().size();

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void toToWarTest() {
        int expect = 52;
        War war = new War();
        war.deal();
        war.goToWar();

        int actual = war.getPlayer().size() + war.getOpponent().size();
        Assertions.assertEquals(expect, actual);

    }

    @Test
    void startGameTest() {
        //int expect = 52;
        War war = new War();
        war.playGame();

//        int actual = war.getPlayer().size() + war.getOpponent().size();
//        Assertions.assertEquals(expect, actual);

    }
}