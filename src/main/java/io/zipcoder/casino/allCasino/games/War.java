package io.zipcoder.casino.allCasino.games;

import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardDeck;
import io.zipcoder.casino.allCasino.card.CardGame;
import io.zipcoder.casino.allCasino.interfaces.Game;
import io.zipcoder.casino.allCasino.ioMessages.GameConsole;

import java.util.ArrayList;
import java.util.Collections;



public class War extends CardGame implements Game {

    GameConsole gc;
    public ArrayList<Card> player;
    public ArrayList<Card> opponent;
    public ArrayList<Card> pile;

    {
        gc = new GameConsole();
        player = new ArrayList<Card>();
        opponent = new ArrayList<Card>();
        pile = new ArrayList<Card>();
    }

    public static void main(String[] args){
        War war = new War();
        war.playGame();
    }

    public void playGame() {
        deal();

        while(!isOver()){

            this.headerDisplay();

            Card playerNC   = getNextCard(this.player);
            Card opponentNC = getNextCard(this.opponent);

            this.cardsDisplay(opponentNC, playerNC);

            if(playerNC.compareTo(opponentNC) == 0){
                this.cardsTo(this.pile, playerNC, opponentNC);
                if(this.canGoToWar()){
                    this.goToWar();
                } else{
                    this.cantGoToWarResult();
                }
            } else if(playerNC.compareTo(opponentNC) > 0){
                gc.println("You win this round!");
                this.cardsTo(this.player, playerNC, opponentNC);
            } else {
                gc.println("You lose this round!");
                this.cardsTo(this.opponent, playerNC, opponentNC);
            }

            Collections.shuffle(this.opponent);
            Collections.shuffle(this.player);
        }

        this.endResultDisplay();

    }

    //Miscellaneous Methods//////////////////////////////////////
    public void deal() {
        CardDeck deck = new CardDeck();
        deck.shuffle();
        for(int i = 0; i < deck.getDeck().length; i+=2){
            this.player.add(deck.getDeck()[i]);
            this.opponent.add(deck.getDeck()[i+1]);
        }
    }

    public Card getNextCard(ArrayList<Card> cards){
        Card toReturn = cards.get(0);
        cards.remove(0);
        return toReturn;
    }

    public boolean isOver(){
        return this.player.size() == 0 || this.opponent.size() == 0 ? true : false;
    }
    //////////////////////////////////////////////////////////////

    //Game Methods////////////////////////////////////////////
    @Override
    public boolean getWinner() {
        return this.player.size() > this.opponent.size() ? true : false;
    }

    @Override
    public void reset() {
        this.player.clear();
        this.opponent.clear();
        //this.playGame();
    }
    //////////////////////////////////////////////////////////

    //Display/////////////////////////////////////////////////////
    public void headerDisplay(){
        gc.println("Players = " +this.player.size() + " \nOpponent = " + this.opponent.size());

        if(this.pile.size() > 0){
            gc.println("Pile size -  " + this.pile.size());
        }

        gc.println("Press Enter to Draw a Card: ");
    }

    public void cardsDisplay(Card opponentNC, Card playerNC){
        gc.println("-----------------------------------");
        gc.println(opponentNC.toString());

        gc.stringScan("");

        gc.println(playerNC.toString());
        gc.println("-----------------------------------");
    }

    public void endResultDisplay(){
        gc.print("Players = " +this.player.size() + " \nOpponent = " + this.opponent.size());

        if(getWinner()){
            gc.println("You Win");
        } else {
            gc.println("You lose");
        }
    }
    //////////////////////////////////////////////////////////////

    //Methods of War!!!!/////////////////////////
    public void goToWar(){

        gc.println("War!!");

        for(int i = 1; i <= 3; i++){
            this.pile.add(getNextCard(this.player));
        }

        for(int i = 1; i <= 3; i++){
            this.pile.add(getNextCard(this.opponent));
        }

        this.headerDisplay();

        Card playerNC  = getNextCard(this.player);
        Card opponentNC = getNextCard(this.opponent);



        this.cardsDisplay(playerNC, opponentNC);

        if(playerNC.compareTo(opponentNC) == 0){
            this.cardsTo(this.pile, playerNC, opponentNC);
            if(this.canGoToWar()){
                this.goToWar();
            } else {
                this.cantGoToWarResult();
            }
        } else if (playerNC.compareTo(opponentNC) > 0){
            gc.println("You win this War!");
            this.cardsTo(this.player, playerNC, opponentNC);
            this.cardsTo(this.player, this.pile);
        } else {
            gc.println("You lose this War!");
            this.cardsTo(this.opponent, playerNC, opponentNC);
            this.cardsTo(this.opponent, this.pile);
        }

    }

    public boolean canGoToWar(){
        return this.player.size() >=  4 && this.opponent.size() >= 4 ? true : false;
    }

    public void cantGoToWarResult(){
        if(this.player.size() > 4){
            gc.println("The opponent doesn't have enough cards to go to war");
            this.cardsTo(this.player, this.pile);
            this.cardsTo(this.player, this.opponent);
        } else {
            gc.println("The Player doesn't have enough cards to go to war");
            this.cardsTo(this.opponent, this.pile);
            this.cardsTo(this.opponent,this.player);
        }
    }
    /////////////////////////////////////////////

    //Card to Methods//////////////////////////////////////////////////
    public void cardsTo(ArrayList<Card> to, ArrayList<Card> from){
        for(int i = 0; i < from.size(); i++){
            to.add(from.get(i));
        }
        from.clear();
    }

    public void cardsTo(ArrayList<Card> pile, Card c1, Card c2){
        pile.add(c1);
        pile.add(c2);
    }
    ///////////////////////////////////////////////////////////////////

    //Testing Methods//////////////////////////////////////////////
    public ArrayList<Card> getPlayer(){
        return this.player;
    }

    public ArrayList<Card> getOpponent(){
        return this.opponent;
    }
    ///////////////////////////////////////////////////////////////

}