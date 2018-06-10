package io.zipcoder.casino.allCasino.games;


import java.util.Scanner;

import io.zipcoder.casino.allCasino.ioMessages.*;
import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardGame;
import io.zipcoder.casino.allCasino.interfaces.*;
import io.zipcoder.casino.allCasino.player.*;

public class Baccarat extends CardGame implements Game, Gamble {

    enum BaccaratPlayer {player, computer}

    ;
    private BaccaratPlayer winner;
    private boolean isOver;
    private boolean playerStands;
    private boolean bankerStands;
    private BaccaratHand playerHand;
    private BaccaratHand bankerHand;
    private int pot;

    public Baccarat() {
        super();
        isOver = false;
        playerStands = false;
        bankerStands = false;
        playerHand = new BaccaratHand();
        bankerHand = new BaccaratHand();
    }

    public static void main(String[] args) {
        Game game = new Baccarat();
        game.playGame();
    }

    public void playGame() {
        deal();
        playerHand.displayHand("Player Hand!\n");
        bankerHand.displayHand("Banker Hand!\n");

        if (playerHand.getTotal() > 7) {
            winner = BaccaratPlayer.player;
            playerStands = true;
            bankerStands = true;
            System.out.println("Player Wins!");
            getWinner();
        } else if (bankerHand.getTotal() > 7) {
            winner = BaccaratPlayer.computer;
            playerStands = true;
            playerStands = true;
            System.out.println("Banker Wins!");
            getWinner();
        } else {
            while (!playerStands && !bankerStands) {
                playerTurn();
                playerStands = true;
                bankerTurn();
                bankerStands = true;
            }
            determineWinner();
            getWinner();
        }
    }

    public boolean getWinner() {
        if (winner == BaccaratPlayer.player) {
            return true;
        } else return false;
    }

    public void placeBet(int helloKittyFunBucks) {
        pot = helloKittyFunBucks * 2;
    }

    public int payOut() {
        return pot;
    }

    public int checkKittyBucksBalance(Player p) {
        return p.getHelloKittyFunBucks();
    }

    protected void deal() {
        playerHand.add(deck.drawCard());
        bankerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        bankerHand.add(deck.drawCard());
    }

    private void playerTurn() {
        if (playerHand.getTotal() < 6) {
            playerHand.add(deck.drawCard());
            playerHand.displayHand("Player Has:\n");
            playerStands = true;
        } else if (playerHand.getTotal() > 6) {
            playerHand.displayHand("Player Has:\n");
            playerStands = true;
        }
    }


    private void bankerTurn() {
        if ((playerHand.getHandLength() == 2) && (bankerHand.getTotal() < 6)) {
            if (bankerHand.getTotal() < 6) {
                bankerHand.add(deck.drawCard());
                bankerHand.displayHand("Banker Has: \n");
                bankerStands = true;
            } else if ((playerHand.getHandLength() == 2) && (bankerHand.getTotal() < 8)) {
                bankerHand.displayHand("Banker Has: \n");
                bankerStands = true;
            }
        } else if (playerHand.getHandLength() == 3) {
            if (playerHand.getCardValue(playerHand.getCard(2)) > 8 ||
                    playerHand.getCardValue(playerHand.getCard(2)) < 1) {
                if (bankerHand.getTotal() < 4) {
                    bankerHand.add(deck.drawCard());
                    bankerHand.displayHand("Banker Has: \n");
                    bankerStands = true;
                } else if (bankerHand.getTotal() > 3 && bankerHand.getTotal() < 8) {
                    bankerHand.displayHand("Banker Has: \n");
                    bankerStands = true;
                }
            } else if (playerHand.getCardValue(playerHand.getCard(2)) == 8) {
                if (bankerHand.getTotal() < 3) {
                    bankerHand.add(deck.drawCard());
                    bankerHand.displayHand("Banker Has: \n");
                    bankerStands = true;
                } else if (bankerHand.getTotal() > 2 && bankerHand.getTotal() < 8) {
                    bankerHand.displayHand("Banker Has: \n");
                    bankerStands = true;
                }
            } else if ((playerHand.getCardValue(playerHand.getCard(2)) < 8) &&
                    (playerHand.getCardValue(playerHand.getCard(2)) > 5)) {
                if (bankerHand.getTotal() < 7) {
                    bankerHand.add(deck.drawCard());
                    bankerHand.displayHand("Banker Has: \n");
                    bankerStands = true;
                } else if (bankerHand.getTotal() > 6) {
                    bankerHand.displayHand("Banker Has: \n");
                    bankerStands = true;
                }
            } else if ((playerHand.getCardValue(playerHand.getCard(2)) < 6) &&
                    (playerHand.getCardValue(playerHand.getCard(2)) > 3)) {
                if (bankerHand.getTotal() < 6) {
                    bankerHand.add(deck.drawCard());
                    bankerHand.displayHand("Banker Has: \n");
                    bankerStands = true;
                } else if (bankerHand.getTotal() > 5) {
                    bankerHand.displayHand("Banker Has: \n");
                    bankerStands = true;
                }
            } else if ((playerHand.getCardValue(playerHand.getCard(2)) < 4) &&
                    (playerHand.getCardValue(playerHand.getCard(2)) > 1)) {
                if (bankerHand.getTotal() < 5) {
                    bankerHand.add(deck.drawCard());
                    bankerHand.displayHand("Banker Has: \n");
                    bankerStands = true;
                } else if (bankerHand.getTotal() > 4) {
                    bankerHand.displayHand("Banker Has: \n");
                    bankerStands = true;
                }
            }
        }
    }

    public void determineWinner() {

        if (playerHand.getTotal() - 9 < bankerHand.getTotal() - 9) {
            winner = BaccaratPlayer.player;
            playerHand.displayHand("Final Player Hand: \n");
            bankerHand.displayHand("Final Banker Hand: \n");
            System.out.println("Player Wins!");
        } else if (bankerHand.getTotal() - 9 < playerHand.getTotal() - 9) {
            winner = BaccaratPlayer.computer;
            playerHand.displayHand("Final Player Hand: \n");
            bankerHand.displayHand("Final Banker Hand: \n");
            System.out.println("Banker Wins!");
        } else {
            winner = null;
            System.out.println("Tie! Return All Bets!");
            playerHand.displayHand("Final Player Hand: \n");
            bankerHand.displayHand("Final Banker Hand: \n");
        }
    }
}

