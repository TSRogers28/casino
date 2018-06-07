package io.zipcoder.casino;

import java.util.Random;

public class CardDeck {

    private Card[] deck;

    public CardDeck() {
        setDeck();
    }


    public void shuffle(){
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

    public Card[] getDeck() {
        return deck;
    }

}
