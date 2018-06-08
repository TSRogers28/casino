package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class War extends CardGame implements Game {

    ArrayList<Card> player = new ArrayList<Card>();
    ArrayList<Card> opponent = new ArrayList<Card>();

    ArrayList<Card> pile = new ArrayList<Card>();


    public War(){

    }

    public static void main(String[] args){
        War war = new War();
        war.playGame();
    }

    public void playGame() {
        deal();

        while(!isOver()){

             Card playerNC   = getNextCard(this.player);
             Card opponentNC = getNextCard(this.opponent);

             if(!isOver()){
                 System.out.println("-----------------------------------");
                 System.out.println(opponentNC.toString());
                 //getInput("Press Enter to Draw a Card: ");
                 System.out.println(playerNC.toString());
                 System.out.println("-----------------------------------");

                 if(playerNC.compareTo(opponentNC) == 0){
                     this.pile.add(playerNC);
                     this.pile.add(opponentNC);
                     if(this.canGoToWar()){
                         this.goToWar();
                     } else {
                         break;
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
                 System.out.println("P=" +this.player.size() + " - O=" + this.opponent.size());

             } else{
                 break;
             }
        }

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

        if(!isOver()){

            System.out.println(this.pile.size());

            System.out.println("-----------------------------------");
            System.out.println(opponentNC.toString());
            //getInput("Press Enter to Draw a Card: ");
            System.out.println(playerNC.toString());
            System.out.println("-----------------------------------");

            if(playerNC.compareTo(opponentNC) == 0){
                this.pile.add(playerNC);
                this.pile.add(opponentNC);
                if(this.canGoToWar()){
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

    }

    public boolean canGoToWar(){
        return this.player.size() >=  4 && this.opponent.size() >= 4 ? true : false;
    }

    public void deal() {
        CardDeck deck = new CardDeck();
        deck.shuffle();
        for(int i = 0; i < deck.getDeck().length; i+=2){
            this.player.add(deck.getDeck()[i]);
            this.opponent.add(deck.getDeck()[i+1]);
        }
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

    public Player getWinner(){
        return new Player();
    }

    public ArrayList<Card> getPlayer(){
        return this.player;
    }

    public ArrayList<Card> getOpponent(){
        return this.opponent;
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }



}