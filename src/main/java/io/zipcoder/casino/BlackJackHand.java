package io.zipcoder.casino;

import java.util.ArrayList;

public class BlackJackHand {

    ArrayList<Card> hand;

    public BlackJackHand() {
        hand = new ArrayList<Card>();
    }

    public void add(Card c) {
        hand.add(c);
    }

    public void displayHand() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString() + "\n");
        }
    }
    public void displayHand(String message) {
        System.out.println(message);
        displayHand();
    }

    public void displayDealerHand() {
        System.out.println("This is the dealer's hand (She has one more. It's hidden!)");
        for (int i = 1; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString() + "\n");
        }
    }

    public int getTotal() {
        int total = 0;
        int aceCount = 0;
        for (Card c : hand) {
            if (c.getFace().equals(Face.JACK) || c.getFace().equals(Face.QUEEN) || c.getFace().equals(Face.KING)){
                total += 10;
            }
            else if (c.getFace().equals(Face.ACE)) {
                aceCount++;
            }
            else total += c.getFace().getValue();
        }

        if (aceCount > 0) {
            total =  tallyAces(aceCount, total);
        }
        return total;
    }

    private int tallyAces(int aceCount, int tally) {
        for(int i =1; i <= aceCount; i++) {
            if (21 - (tally + aceCount - i) >=11) {
                tally += 11;
            }
            else {
                tally += 1;
            }
        }
        return tally;
    }

}
