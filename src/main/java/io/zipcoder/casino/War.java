package io.zipcoder.casino;
import java.util.ArrayList;

public class War extends CardGame implements Game {

    ArrayList<Card> player = new ArrayList<Card>();
    ArrayList<Card> opponent = new ArrayList<Card>();

    ArrayList<Card> pile = new ArrayList<Card>();


    public War(){

    }

    public void playGame() {
        deal();

        while(!isOver()){

             Card playerNC   = getNextCard(this.player);
             Card opponentNC = getNextCard(this.opponent);

             if(!isOver()){

                 if(playerNC.compareTo(opponentNC) == 0){
                     this.pile.add(playerNC);
                     this.pile.add(opponentNC);
                     if(this.canGoToWar()){
                         this.goToWar();
                     } else {
                         break;
                     }
                 } else if(playerNC.compareTo(opponentNC) > 0){
                     this.player.add(playerNC);
                     this.player.add(opponentNC);
                 } else {
                     this.opponent.add(playerNC);
                     this.opponent.add(opponentNC);
                 }

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

        for(int i = 1; i <= 3; i++){
            this.pile.add(getNextCard(this.player));
        }

        for(int i = 1; i <= 3; i++){
            this.pile.add(getNextCard(this.opponent));
        }

        Card player1NextCard  = getNextCard(this.player);
        Card opponentNextCard = getNextCard(this.opponent);

        if(!isOver()){
            if(player1NextCard.compareTo(opponentNextCard) == 0){
                this.pile.add(player1NextCard);
                this.pile.add(opponentNextCard);
                this.goToWar();
            } else if (player1NextCard.compareTo(opponentNextCard) > 0){
                this.player.add(player1NextCard);
                this.player.add(opponentNextCard);
                this.pileTo(this.player);
            } else {
                this.opponent.add(player1NextCard);
                this.opponent.add(opponentNextCard);
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
        return this.player.size() == 0 || this.opponent.size() == 0 ? true : true;
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

//    package io.zipcoder.casino;
//
//    public class warTest {
//
//        public static void main(String[] args){
//            Player[] players = new Player[0];
//            War war = new War(players);
//            war.startGame();
//        }
//    }


}