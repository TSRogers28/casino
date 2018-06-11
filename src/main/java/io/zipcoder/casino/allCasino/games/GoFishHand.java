package io.zipcoder.casino.allCasino.games;

import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.ioMessages.Face;

import java.util.ArrayList;

public class GoFishHand {

    ArrayList<Card> hand;

    public GoFishHand() {
        hand = new ArrayList<Card>();
    }

    public int getHandSize() {
        return hand.size();
    }
    public void add(Card c) {
        hand.add(c);
    }


    public int checkHandForCard(Face face) {
        int count = 0;
        for (Card c : hand) {
            if (c.getFace() == face) { count++; }
        }
        return count;
    }

    public Card removeCard(Face face) {
        Card returnCard = null;
        for (Card c : hand) {
            if (c.getFace() == face) {
                returnCard = c;
                hand.remove(c);
                break;
            }
        }
        return returnCard;
    }

    public int playFourOfAKinds() {
        for (Face f : Face.values()) {
            int numberOfKind = 0;
            for (Card c : hand) {
                if (c.getFace() == f) { numberOfKind++; }
            }
            if (numberOfKind == 4) {
                removeFourOfAKind(f);
                System.out.println("You got a set of " + f + "!");
                return 1;
            }
        }
        return 0;
    }

    private void removeFourOfAKind(Face f) {
        for (int i = 0; i < 4; i++) {
            removeCard(f);
        }
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
        System.out.println("This is the dealer's hand: ");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(Card.getBackOfCard()  + "\n");
        }
        System.out.println("(She has " + hand.size() + " cards");
    }

    public Face whichCardShouldDealerFish() {
        return getMostCommonCard();
    }

    private Face getMostCommonCard() {
        int highestCount = 0;
        Face face = null;
        for (Face f : Face.values()) {
            int currCount = countThisFace(f);
            if (currCount > highestCount) {
                highestCount = currCount;
                face = f;
            }
        }
        return face;
    }

    private int countThisFace(Face f) {
        int count = 0;
        for (Card c : hand) {
            if (c.getFace() == f) { count++; }
        }
        return count;
    }

}
