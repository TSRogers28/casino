package io.zipcoder.casino.allCasino.games;

import io.zipcoder.casino.allCasino.ioMessages.*;
import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardGame;
import io.zipcoder.casino.allCasino.interfaces.*;
import io.zipcoder.casino.allCasino.player.*;

public class GoFish extends CardGame implements Game{

    private boolean playerIsWinner;
    private boolean isOver;

    private GoFishHand playerHand;
    private GoFishHand computerHand;




    @Override
    public void playGame() {

    }
    @Override
    protected void deal(){

    }
    @Override
    public boolean getWinner() {
        return false;
    }
}
