package io.zipcoder.casino;

import java.util.Random;

public abstract class CardGame{

    private Card[] deck;
    Player[] players;

    public abstract Card[] deal();

    public CardGame(Player[] players) {
        this.players = players;
        setDeck();
    }

    public Card draw() {
        Card firstCard = deck[0];
        for (int i = 0; i < deck.length - 1; i++) {
            deck[i] = deck[i+1];
        }
        deck[deck.length] = null;
        return firstCard;
    }
    public Card[] draw(int numberOfCards) {
        Card[] drawnCards = new Card[numberOfCards];
        for (int i = 0; i < drawnCards.length; i++) {
            drawnCards[i] = draw();
        }
        return drawnCards;
    }

    private void shuffle(){
        Card[] shuffled = new Card[deck.length];
        for (Card c : deck) {
            while (true) {
                Random r = new Random();
                int newIndex = r.nextInt(deck.length);
                if (shuffled[newIndex] == null) {
                    shuffled[newIndex] = c;
                    break;
                }
            }
        }
        deck = shuffled;
    }

    private void setDeck() {
        deck = new Card[52];
        int cardIndex = 0;
        for (Suit s : Suit.values()){
            for (Face f : Face.values()) {
                deck[cardIndex] = new Card(f, s);
                cardIndex++;
            }
        }
    }



}