package io.zipcoder.casino;

public class BlackJack extends CardGame implements Game{

    Player player1;
    Player player2;
    Face f;
    Suit s;

    public void BlackJack(Player[] players){
        super(player1);

        //this.deal();
        //players = new Player[2];
        this.player1 = players[0];
        this.player2 = players[1];




    }

    @Override
    public Card[] deal() {
        return new Card[0];
    }







}
