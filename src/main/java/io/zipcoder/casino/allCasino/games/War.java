package io.zipcoder.casino.allCasino.games;

import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardDeck;
import io.zipcoder.casino.allCasino.card.CardGame;
import io.zipcoder.casino.allCasino.interfaces.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class War extends CardGame implements Game {

    ArrayList<Card> player = new ArrayList<Card>();
    ArrayList<Card> opponent = new ArrayList<Card>();

    ArrayList<Card> pile = new ArrayList<Card>();


    public War(){

    }

  /*  public static void main(String[] args){
        War war = new War();
        war.playGame();
    }*/

    public static String getInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void playGame() {
        deal();

        while(!isOver()){

            System.out.println("Players = " +this.player.size() + " \nOpponent = " + this.opponent.size());
            System.out.println("Press Enter to Draw a Card: ");

            Card playerNC   = getNextCard(this.player);
            Card opponentNC = getNextCard(this.opponent);


            System.out.println("-----------------------------------");
            System.out.println(opponentNC.toString());
            getInput(" ");
            System.out.println(playerNC.toString());
            System.out.println("-----------------------------------");

            if(playerNC.compareTo(opponentNC) == 0){
                this.pile.add(playerNC);
                this.pile.add(opponentNC);
                if(this.canGoToWarAndResult()){
                    this.goToWar();
                }
            } else if(playerNC.compareTo(opponentNC) > 0){
                System.out.println("You win this round!");
                System.out.println("");
                this.player.add(playerNC);
                this.player.add(opponentNC);
            } else {
                System.out.println("You lose this round!");
                this.opponent.add(playerNC);
                this.opponent.add(opponentNC);
            }

            Collections.shuffle(this.opponent);
            Collections.shuffle(this.player);

        }


        System.out.println("Players = " +this.player.size() + " \nOpponent = " + this.opponent.size());

        if(isWinner()){
            System.out.println("You Win");
        } else {
            System.out.println("You lose");
        }

    }

    public Card getNextCard(ArrayList<Card> cards){
        Card toReturn = cards.get(0);
        cards.remove(0);
        return toReturn;
    }

    public void goToWar(){

        System.out.println("War!!");

        for(int i = 1; i <= 3; i++){
            this.pile.add(getNextCard(this.player));
        }

        for(int i = 1; i <= 3; i++){
            this.pile.add(getNextCard(this.opponent));
        }

        Card playerNC  = getNextCard(this.player);
        Card opponentNC = getNextCard(this.opponent);

        System.out.println("Pile size -  " + this.pile.size());
        System.out.println("Press Enter to Draw a Card: ");

        System.out.println("-----------------------------------");
        System.out.println(opponentNC.toString());
        getInput("");
        System.out.println(playerNC.toString());
        System.out.println("-----------------------------------");

        if(playerNC.compareTo(opponentNC) == 0){
            this.pile.add(playerNC);
            this.pile.add(opponentNC);
            if(this.canGoToWarAndResult()){
                this.goToWar();
            }
        } else if (playerNC.compareTo(opponentNC) > 0){
            System.out.println("You win this War!");
            this.player.add(playerNC);
            this.player.add(opponentNC);
            this.pileTo(this.player);
        } else {
            System.out.println("You lose this War!");
            this.opponent.add(playerNC);
            this.opponent.add(opponentNC);
            this.pileTo(this.opponent);
        }

    }

    public boolean canGoToWarAndResult(){
        boolean canWar;
        if(this.player.size() >=  4 && this.opponent.size() >= 4){
            canWar = true;
        } else {
            canWar = false;
            if(this.player.size() > 4){
                System.out.println("The opponent doesn't have enough cards to go to war");
                this.pileTo(this.player);
                this.cardsTo(this.player,this.opponent);
            } else {
                System.out.println("The Player doesn't have enough cards to go to war");
                this.pileTo(this.opponent);
                this.cardsTo(this.opponent,this.player);
            }
        }
        return canWar;
    }

    public void deal() {
        CardDeck deck = new CardDeck();
        deck.shuffle();
        for(int i = 0; i < deck.getDeck().length; i+=2){
            this.player.add(deck.getDeck()[i]);
            this.opponent.add(deck.getDeck()[i+1]);
        }
    }

    public void cardsTo(ArrayList<Card> to, ArrayList<Card> from){
        for(int i = 0; i < from.size(); i++){
            to.add(getNextCard(from));
        }
        from.clear();
    }

    public void pileTo(ArrayList<Card> player){
        for(int i = 0; i < this.pile.size(); i++){
            player.add(this.pile.get(i));
        }
        this.pile.clear();
    }

    public boolean isOver(){
        return this.player.size() == 0 || this.opponent.size() == 0 ? true : false;
    }

    public boolean isWinner(){
        boolean isWin = false;
        if(this.player.size() > this.opponent.size()){
            isWin = true;
        } else {
            isWin = false;
        }
        return isWin;
    }

    public ArrayList<Card> getWin() {
        ArrayList<Card> winner = null;
        if(this.player.size() > this.opponent.size()){
            winner = this.player;
        }else {
            winner =this.opponent;
        }
        return winner;
    }

    public boolean getWinner() {
        return false;
    }

    public ArrayList<Card> getPlayer(){
        return this.player;
    }

    public ArrayList<Card> getOpponent(){
        return this.opponent;
    }



}