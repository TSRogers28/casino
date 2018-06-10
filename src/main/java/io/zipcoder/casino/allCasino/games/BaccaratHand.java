package io.zipcoder.casino.allCasino.games;

import io.zipcoder.casino.allCasino.ioMessages.*;
import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardGame;
import io.zipcoder.casino.allCasino.interfaces.Game;
import io.zipcoder.casino.allCasino.player.*;
import java.util.ArrayList;

public class BaccaratHand {

    ArrayList<Card> hand;

    public BaccaratHand() {hand = new ArrayList<Card>();}

    public void add(Card c) {hand.add(c);}

    public void displayHand() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString() + "\n");
        }
    }

    public void showHand(String message) {
        System.out.println(message);
        displayHand();
    }

    public int getHandLength(){
        return hand.size();
    }

    public int getTotal() {
        int total = 0;
        int finalTotal = 0;

        for (Card c : hand) {
            if (c.getFace().equals(Face.JACK) || c.getFace().equals(Face.QUEEN) || c.getFace().equals(Face.KING) ||  c.getFace().equals(Face.TEN) ){
                total += 0;
            }
            else if (c.getFace().equals(Face.ACE)) {
                total += 1;
            }
            else total += c.getFace().getValue();
        }

        if(total >= 11) {
            finalTotal = total - 10;
        }
        else finalTotal = total;

        return finalTotal;
    }

    public Card getCard(int cardNumber) {

        return hand.get(cardNumber);
    }

    public int getCardValue(Card c) {
        int value;

            if (c.getFace().equals(Face.JACK) || c.getFace().equals(Face.QUEEN) || c.getFace().equals(Face.KING)){
                value = 0;
            }
            else if (c.getFace().equals(Face.ACE)) {
                value = 1;
            }
            else value = c.getFace().getValue();

        return value;
    }


}
