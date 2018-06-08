package io.zipcoder.casino.allCasino.games;


import java.util.Scanner;

import io.zipcoder.casino.allCasino.ioMessages.*;
import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardGame;
import io.zipcoder.casino.allCasino.interfaces.*;
import io.zipcoder.casino.allCasino.player.*;

public class BlackJack extends CardGame implements Game, Gamble{

    enum BlackJackPlayer {player, computer};
    private BlackJackPlayer winner;
    private boolean isOver;
    private boolean playerStands;
    private BlackJackHand playerHand;
    private BlackJackHand dealerHand;

    private int pot;

    public BlackJack(){
        super();
        isOver = false;
        playerStands = false;
        playerHand = new BlackJackHand();
        dealerHand = new BlackJackHand();
    }
    public void playGame() {
        deal();

        while(!playerStands) {
            nextTurn();
        }
        if (!isOver) {
            System.out.println("These are your cards!");
            playerHand.displayHand();
            System.out.println("Now it's the dealer's turn. Your score to beat is " + playerHand.getTotal());
            dealerTurn();
        }
    }

    public Player getWinner() {
        return null;
    }


    public void placeBet(int helloKittyFunBucks) {
        pot = helloKittyFunBucks*2;
    }
    public int payOut() {
        return pot;
    }
    public int checkKittyBucksBalance(Player p) {
        return p.getHelloKittyFunBucks();
    }

    protected void deal(){
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
    }

    private void nextTurn() {
        playerHand.displayHand("This is your hand!");
        dealerHand.displayDealerHand();
        if (hit()) {
            playerHand.add(deck.drawCard());
        }
        else {
            playerStands = true;
        }
        printEndOfTurn();
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

    private void printEndOfTurn() {
        int total = playerHand.getTotal();
        if (total == 21) {
            playerHand.displayHand("Woo Black Jack! You win!");
            playerStands = true;
            isOver = true;
            winner = BlackJackPlayer.player;
        } else if (total > 21) {
            playerHand.displayHand("You Busted! Game over.");
            playerStands = true;
            isOver = true;
            winner = BlackJackPlayer.computer;
        }
    }
    private void dealerTurn() {
        int total = dealerHand.getTotal();
        while (total <= 16) {
            dealerHand.add(deck.drawCard());
            dealerHand.displayDealerHand();
            total = dealerHand.getTotal();
        }
        System.out.println("Dealer stands!");
        System.out.println("This is the dealer's hand (including super secret mystery card!)");
        dealerHand.displayHand();

        if (total > 21) {
            System.out.println("Dealer busted! You win!");
            winner = BlackJackPlayer.player;
        }
        else if (total == 21 || total > playerHand.getTotal()) {
            System.out.println("Womp womp. Dealer's score was " + total + ". Dealer Wins.");
            winner = BlackJackPlayer.computer;
        }
        else {
            System.out.println("Woo! Dealer's score was " + total + ", but yours was " + playerHand.getTotal() + "!");
            System.out.println("You win!");
            winner = BlackJackPlayer.player;
        }
    }
}