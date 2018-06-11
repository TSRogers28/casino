package io.zipcoder.casino.allCasino.games;


import java.util.ArrayList;
import java.util.Scanner;

import io.zipcoder.casino.allCasino.card.CardDeck;
import io.zipcoder.casino.allCasino.ioMessages.*;
import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardGame;
import io.zipcoder.casino.allCasino.interfaces.*;
import io.zipcoder.casino.allCasino.player.*;

public class BlackJack extends CardGame implements Game, Gamble{

    private Boolean playerIsWinner;
    private boolean isOver;
    private boolean playerStands;
    private BlackJackHand playerHand;
    private BlackJackHand dealerHand;
    private GameConsole gameConsole = new GameConsole();
    private int pot;

    public BlackJack(){
        super();
        gameConsole = new GameConsole();
        isOver = false;
        playerStands = false;
        playerIsWinner = false;
        playerHand = new BlackJackHand();
        dealerHand = new BlackJackHand();
    }

    public boolean getWinner() {
        return playerIsWinner;
    }
    public Card[] getPlayerCards() {
        return playerHand.getCards();
    }
    public Card[] getDealerCards() {
        return playerHand.getCards();
    }
    public boolean getIsOver() { return isOver; }

    public void reset() {
        deck = new CardDeck();
        playerHand = new BlackJackHand();
        dealerHand = new BlackJackHand();
        playerStands = false;
        isOver = false;
    }
    public void deal(){
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
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

    public void hit() {
        playerHand.add(deck.drawCard());
    }

    public void playGame() {
        deal();
        while (!playerStands) {
            nextTurn();
        }
        if (!isOver) {
            gameConsole.println("These are your cards!");
            playerHand.displayHand();
            gameConsole.println("Now it's the dealer's turn. Your score to beat is " + playerHand.getTotal());
            dealerTurn();
        }
    }

    private void nextTurn() {
        playerHand.displayHand("This is your hand!");
        dealerHand.displayDealerHand();
        String yesNo = gameConsole.stringScan("Do you want a card? y/n ");
        if (yesNo.equalsIgnoreCase("y")) {
            hit();
        }
        else {
            playerStands = true;
        }
        endOfTurn(playerHand.getTotal());
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
            gameConsole.println("Dealer busted! You win!");
            playerIsWinner = true;
        }
        else if (total == 21 || total > playerHand.getTotal()) {
            gameConsole.println("Womp womp. Dealer's score was " + total + ". Dealer Wins.");
            playerIsWinner = false;
        }
        else {
            System.out.println("Woo! Dealer's score was " + total + ", but yours was " + playerHand.getTotal() + "!");
            System.out.println("You win!");
            playerIsWinner = true;
        }
    }
    public void endOfTurn(int total) {
        if (total == 21) {
            playerHand.displayHand("Woo Black Jack! You win!");
            playerStands = true;
            isOver = true;
            playerIsWinner = true;
        } else if (total > 21) {
            playerHand.displayHand("You Busted! Game over.");
            playerStands = true;
            isOver = true;
            playerIsWinner = false;
        }
    }
}

