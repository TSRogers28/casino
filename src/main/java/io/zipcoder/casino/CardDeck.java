package io.zipcoder.casino;

import java.util.Random;

public class CardDeck {

    private Card[] deck;
    private int currIndex;

    public CardDeck() {
        setDeck();
        currIndex = 0;
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
        currIndex = 0;
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
        currIndex = 0;
    }

    public Card drawCard() {
        Card drawnCard = deck[currIndex];
        currIndex++;
        return drawnCard;
    }

    public Card[] getDeck() {
        return deck;
    }

}
