package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack extends CardGame implements Game{

    enum BlackJackPlayer {player, computer};
    private BlackJackPlayer winner;
    private boolean isOver;
    private boolean playerStands;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;

    public BlackJack(){
        super();
        isOver = false;
        playerStands = false;
        playerHand = new ArrayList<Card>();
        dealerHand = new ArrayList<Card>();
    }

    public void playGame() {
        deal();
       // displayHand(playerHand, "This is your hand!");
       // displayHandOneHidden(dealerHand);

        while(!playerStands) {
            nextTurn();
        }

        if (!isOver) {
            System.out.println("These are your cards!");
            displayHand(playerHand);
            System.out.println("Now it's the dealer's turn. Your score to beat is " + getTotal(playerHand));
            dealerTurn();
        }

    }

    public Player getWinner() {
        return null;
    }

    protected void deal(){
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
    }

    private void nextTurn() {
        displayHand(playerHand, "This is your hand!");
        displayHandOneHidden(dealerHand);
        if (hit()) {
            playerHand.add(deck.drawCard());
        }
        else {
            playerStands = true;
        }
        printEndOfTurn();
    }

    void displayHand(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString());
        }

    }
    void displayHand(ArrayList<Card> hand, String message) {
        System.out.println(message);
        displayHand(hand);
    }
    private void displayHandOneHidden(ArrayList<Card> hand) {
        System.out.println("This is the dealer's hand (She has one more. It's hidden!)");
        for (int i = 1; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString());
        }
    }
    private boolean hit() {
        Scanner s = new Scanner(System.in);
        System.out.println("Do you want a card? y/n ");
        String yesNo = s.nextLine();
        if (yesNo.equals("y")) {
            return true;
        }
        else return false;
    }

    private int getTotal(ArrayList<Card> hand) {
        int total = 0;
        for (Card c : hand) {
            total += c.getFace().getValue();
        }
        return total;
    }
    private void printEndOfTurn() {
        int total = getTotal(playerHand);
        if (total == 21) {
            displayHand(playerHand, "Woo Black Jack! You win!");
            playerStands = true;
            isOver = true;
            winner = BlackJackPlayer.player;
        } else if (total > 21) {
            displayHand(playerHand, "You Busted! Game over.");
            playerStands = true;
            isOver = true;
            winner = BlackJackPlayer.computer;
        }
    }
    private void dealerTurn() {
        int total = getTotal(dealerHand);
        while (total <= 16) {
            dealerHand.add(deck.drawCard());
            displayHandOneHidden(dealerHand);
            total = getTotal(dealerHand);
        }
        System.out.println("Dealer stands!");
        System.out.println("This is the dealer's hand (including super secret mystery card!");
        displayHand(dealerHand);

        if (total > 21) {
            System.out.println("Dealer busted! You win!");
            winner = BlackJackPlayer.player;
        }
        else if (total == 21 || total > getTotal(playerHand)) {
            System.out.println("Womp womp. Dealer's score was " + total + ". Dealer Wins.");
            winner = BlackJackPlayer.computer;
        }
        else {
            System.out.println("Woo! Dealer's score was " + total + ", but yours was " + getTotal(playerHand) + "!");
            System.out.println("You win!");
            winner = BlackJackPlayer.player;
        }
    }
}