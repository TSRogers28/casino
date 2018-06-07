package io.zipcoder.casino;

import java.util.Random;

public abstract class CardGame{

    private CardDeck deck;
    Player[] players;

    public abstract void deal();

    public CardGame(Player[] players) {
        this.players = players;
        this.deck = new CardDeck();
    }
}