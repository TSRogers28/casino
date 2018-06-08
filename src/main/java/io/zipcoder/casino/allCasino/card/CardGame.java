package io.zipcoder.casino.allCasino.card;

public abstract class CardGame{

    protected CardDeck deck;

    protected abstract void deal();

    public CardGame() {
        this.deck = new CardDeck();
        deck.shuffle();
    }
}