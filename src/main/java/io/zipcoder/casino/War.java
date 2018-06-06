package io.zipcoder.casino;


public class War extends CardGame {
    Player player1;
    Player player2;
    Face f;
    Suit s;


    public War(Player[] players) {
        //super(players);
        Player player1 = new Player();
        Player player2 = new Player();

        //dealCards(player1, player2);

        //while((player1.getCardsCount() && player2.getCardCount())!=0){

             //Card player1NextCard = this.player1.getNextCard();
             //Card player2NextCard = this.player2.getNextCard();

            //if(player1NextCard == player2NextCard){
                //this.goToWar();
            //} else if(player1NextCard is greater then player2NextCard){
                //this.currentCardsTo(this.player1);
            // } else {
                //this.currentCardTo(this.player2);
            // }



        //}


    }


//    public Card[] deal() {
//        return new Card[0];
//
//    }

    public void mainGame(){
        CardGame.draw();
        /*while( p1 and p2 deck doesn't equal 0){
            continue;
            switch(){
            case1(p1 > p2): give cards to p1;
            break;
            case2(p1 < p2):give cards to p2;
            break;
            case3(p1 == p2): draw 6 each;
            break
            }
        */
        }
    public boolean checkWinner(){

        return player1.getCardsCount() !=0 || player2.getCardCount())!=0 ? false: true;
    }


    public Card getWinner(){
        return null;
    }

    public void setWinner(){

    }

}
