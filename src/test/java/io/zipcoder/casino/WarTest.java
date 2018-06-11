package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;
import io.zipcoder.casino.allCasino.games.War;




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
    public void getNextCardTest() {
        War war = new War();
        war.deal();

        int expect = war.getPlayer().size() - 1;

        war.getNextCard(war.getPlayer());
        int actual = war.getPlayer().size();

        Assert.assertEquals(expect, actual);
    }

}