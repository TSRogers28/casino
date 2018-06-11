package io.zipcoder.casino;

import io.zipcoder.casino.allCasino.card.Card;
import org.junit.Test;
import org.junit.Assert;
import io.zipcoder.casino.allCasino.games.War;

public class WarTest {

    @Test
    public void dealCardsTest() {
        //When
        War war = new War();
        war.deal();

        //Expect
        int expect = 52;

        //Actual
        int actual = war.getPlayer().size() + war.getOpponent().size();

        Assert.assertEquals(expect, actual);

    }

    @Test
    public void getNextCardTest() {
        //When
        War war =  new War();
        war.deal();
        war.getNextCard(war.getPlayer());

        //Expect
        int expect = 25;

        //Actual
        int actual = war.getPlayer().size();

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void resetTest(){
        //When
        War war =  new War();
        war.deal();
        war.reset();

        //Expect
        int expect = 0;

        //Actual
        int actual = war.getPlayer().size() + war.getOpponent().size();

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void isOverTest(){
        //When
        War war = new War();

        //Expect
        //boolean expect = true;
        boolean expect = war.isOver();

        //Actual
        //boolean actual = war.isOver();

        Assert.assertTrue(expect);
    }

    @Test
    public void canGoToWarTest(){
        //When
        War war = new War();
        war.deal();
        war.cardsTo(war.player, war.opponent);

        //Expect
        boolean expect = war.canGoToWar();

        Assert.assertFalse(expect);

    }

    @Test
    public void getWinnerTest(){
        //When
        War war = new War();
        war.deal();
        war.cardsTo(war.player, war.opponent);

        //Actual
        boolean actual = war.getWinner();

        Assert.assertTrue(actual);

    }

    @Test
    public void allCardsTo(){
        //When
        War war = new War();
        war.deal();
        war.cardsTo(war.player, war.opponent);

        //Expect
        int expect = 52;

        //Actual
        int actual = war.player.size();

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void roundCardsTo(){
        //When
        War war = new War();
        war.deal();

        Card playerNC = war.getNextCard(war.player);
        Card opponentNC = war.getNextCard(war.opponent);
        war.cardsTo(war.player, playerNC, opponentNC);

        //Expect
        int expect = 27;

        //Actual
        int actual = war.player.size();

        Assert.assertEquals(expect, actual);

    }






}