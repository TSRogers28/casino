package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;


class WarTest {

    @Test
    void dealCardsTest() {
        int expect = 52;
        War war = new War();
        war.deal();
        int actual = war.getPlayer().size() + war.getOpponent().size();
        Assert.assertEquals(expect, actual);

    }

    @Test
    void getNextCard() {
        War war = new War();
        war.deal();

        int expect = war.getPlayer().size() - 1;

        war.getNextCard(war.getPlayer());
        int actual = war.getPlayer().size();

        Assert.assertEquals(expect, actual);
    }

    @Test
    void pileTo() {
    }
}