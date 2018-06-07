package io.zipcoder.casino;

import java.util.Random;

public abstract class CardGame{

    protected CardDeck deck;

    protected abstract void deal();

    public CardGame() {
        this.deck = new CardDeck();
    }
}