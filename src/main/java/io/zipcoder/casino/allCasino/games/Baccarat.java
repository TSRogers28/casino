package io.zipcoder.casino.allCasino.games;


import java.util.Scanner;

import io.zipcoder.casino.allCasino.card.CardDeck;
import io.zipcoder.casino.allCasino.ioMessages.*;
import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardGame;
import io.zipcoder.casino.allCasino.interfaces.*;
import io.zipcoder.casino.allCasino.player.*;

public class  Baccarat extends CardGame implements Game, Gamble {

    enum BaccaratPlayer {player, computer}

    GameConsole console = new GameConsole();
    private BaccaratPlayer winner;
    private boolean playerStands;
    private boolean bankerStands;
    private BaccaratHand playerHand;
    private BaccaratHand bankerHand;
    private boolean playing = true;
    private int pot;
    private String playerBetOn;
    private boolean natWin = false;

    public Baccarat() {
        super();
        playerStands = false;
        bankerStands = false;
        playerHand = new BaccaratHand();
        bankerHand = new BaccaratHand();
    }

    public void playGame() {
        deal();
        playerHand.showHand("Player Hand!\n");
        console.println("Player Has: " + playerHand.getTotal());
        bankerHand.showHand("Banker Hand!\n");
        console.println("Banker Has: " + bankerHand.getTotal());

        naturalWinner();

        if (natWin == false) {
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

    public void reset() {
        deck = new CardDeck();
        playerHand = new BaccaratHand();
        bankerHand = new BaccaratHand();
        playerStands = false;
        bankerStands = false;
    }

    public boolean getWinner() {
        if ((winner == BaccaratPlayer.player) && (playerBetOn.equalsIgnoreCase("player"))) {
            return true;
        }else if ((winner == BaccaratPlayer.computer) && (playerBetOn.equalsIgnoreCase("banker"))){
            return true;
        } else return false;
    }

    public boolean naturalWinner() {
        if ((playerHand.getTotal() > 7 && playerHand.getTotal() < 10) && (playerHand.getTotal() != bankerHand.getTotal())) {
            winner = BaccaratPlayer.player;
            playerStands = true;
            bankerStands = true;
            console.println("Player Has A Natural Win!");
            getWinner();
            return true;
        } else if ((bankerHand.getTotal() > 7 && playerHand.getTotal() < 10) && (bankerHand.getTotal() != bankerHand.getTotal())) {
            winner = BaccaratPlayer.computer;
            playerStands = true;
            playerStands = true;
            console.println("Banker Has A Natural Win!");
            getWinner();
            return true;
        } else if (playerHand.getTotal() > 7 && (playerHand.getTotal() == bankerHand.getTotal())) {
            winner = null;
            console.println("Tie! Return All Bets!");
            return true;
        } else {return false;}
    }

    public void placeBet(int helloKittyFunBucks) {
        pot = helloKittyFunBucks * 2;
        betOnWho();
    }

    public void betOnWho(){
        String betOn;
        betOn = console.stringScan("Are You Betting On Player or Banker?");
        do{
            if(betOn.equalsIgnoreCase("Player")){
                playerBetOn = betOn;
            }
            else if(betOn.equalsIgnoreCase("Banker")){
                playerBetOn = betOn;
            }
            else {
                console.println("Please Choose Player of Banker");
            }
        } while(playerBetOn == null);

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
            playerHand.showHand("Player Has:\n");
            playerStands = true;
        } else if (playerHand.getTotal() > 6) {
            playerHand.showHand("Player Has:\n");
            playerStands = true;
        }
    }


    private void bankerTurn() {
        if (playerHand.getHandLength() == 2) {
            bankerVs2PlayerCards();
            }
        else if (playerHand.getHandLength() == 3) {
            bankerVs3PlayerCards();
            }
        }


    public void bankerVs2PlayerCards() {
        if (bankerHand.getTotal() < 6) {
                bankerHand.add(deck.drawCard());
                bankerHandAndStand();
            }
            else if (bankerHand.getTotal() < 8) {
                bankerHandAndStand();
            }
        }
    public void bankerVs3PlayerCards(){
        if (playerHand.getCardValue(playerHand.getCard(2)) > 8 ||
                playerHand.getCardValue(playerHand.getCard(2)) < 1) {
            if (bankerHand.getTotal() < 4) {
                bankerHand.add(deck.drawCard());
                bankerHandAndStand();
            } else if (bankerHand.getTotal() > 3 && bankerHand.getTotal() < 8) {
                bankerHandAndStand();
            }
        } else if (playerHand.getCardValue(playerHand.getCard(2)) == 8) {
            if (bankerHand.getTotal() < 3) {
                bankerHand.add(deck.drawCard());
                bankerHandAndStand();
            } else if (bankerHand.getTotal() > 2 && bankerHand.getTotal() < 8) {
                bankerHandAndStand();
            }
        } else if ((playerHand.getCardValue(playerHand.getCard(2)) < 8) &&
                (playerHand.getCardValue(playerHand.getCard(2)) > 5)) {
            if (bankerHand.getTotal() < 7) {
                bankerHand.add(deck.drawCard());
                bankerHandAndStand();
            } else if (bankerHand.getTotal() > 6) {
                bankerHandAndStand();
            }
        } else if ((playerHand.getCardValue(playerHand.getCard(2)) < 6) &&
                (playerHand.getCardValue(playerHand.getCard(2)) > 3)) {
            if (bankerHand.getTotal() < 6) {
                bankerHand.add(deck.drawCard());
                bankerHandAndStand();
            } else if (bankerHand.getTotal() > 5) {
                bankerHandAndStand();
            }
        } else if ((playerHand.getCardValue(playerHand.getCard(2)) < 4) &&
                (playerHand.getCardValue(playerHand.getCard(2)) > 1)) {
            if (bankerHand.getTotal() < 5) {
                bankerHand.add(deck.drawCard());
                bankerHandAndStand();
            } else if (bankerHand.getTotal() > 4) {
                bankerHandAndStand();
            }
        }

    }
    
    public void bankerHandAndStand() {
        bankerHand.showHand("Banker Has: \n");
        bankerStands = true;
    }

    public void determineWinner() {

        if (Math.abs(9 - playerHand.getTotal()) < Math.abs(9 - bankerHand.getTotal())) {
            winner = BaccaratPlayer.player;
            playerHand.showHand("Final Player Hand: \n");
            console.println("Player Has: " + playerHand.getTotal());
            bankerHand.showHand("Final Banker Hand: \n");
            console.println("Banker Has: " + bankerHand.getTotal());
            console .println("Player Wins!");
        } else if (Math.abs(9 - bankerHand.getTotal()) < Math.abs(9 - playerHand.getTotal())) {
            winner = BaccaratPlayer.computer;
            playerHand.showHand("Final Player Hand: \n");
            bankerHand.showHand("Final Banker Hand: \n");
            console.println("Banker Wins!");
        } else {
            winner = null;
            console.println("Tie! Return All Bets!");
            playerHand.showHand("Final Player Hand: \n");
            bankerHand.showHand("Final Banker Hand: \n");
        }
    }

    //methods below are solely for unit testing purposes
    public CardDeck getDeck(){
        return this.deck;
    }

    public boolean getPlayerStands(){ return playerStands;}
    public boolean getBankerStands(){ return bankerStands;}

    public BaccaratHand getPlayerHand() {
        return playerHand;
    }

    public BaccaratHand getBankerHand() {
        return bankerHand;
    }

    public void setWinner(BaccaratPlayer winner) {
        this.winner = winner;
    }

    public void setPlayerHand(Card c1, Card c2) {
        this.playerHand.add(c1);
        this.playerHand.add(c2);
    }

    public void setPlayerBetOn(String playerBetOn) {
        this.playerBetOn = playerBetOn;
    }
    public String getPlayerBetOn() {
        return playerBetOn;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

}

