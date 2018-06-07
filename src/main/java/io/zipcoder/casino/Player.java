package io.zipcoder.casino;

public class Player {
    String name;
    int helloKittyFunBucks;
    Card[] hand = new Card[]{};
    Dice dice;

    public Player(){

    }
    public Player(int credits, String name){

     this.helloKittyFunBucks = credits;
     this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHelloKittyFunBucks() {
        return helloKittyFunBucks;
    }

    public void setHelloKittyFunBucks(int helloKittyFunBucks) {
        this.helloKittyFunBucks = helloKittyFunBucks;
    }

    public void addHelloKittyFunBucks(int credits){
        this.helloKittyFunBucks = getHelloKittyFunBucks()+credits;
    }


    public Card getCard() {
        return hand[0];
    }

    public void setHand(Card[ ] hand) {
        this.hand = hand;
    }

    public Dice getDice(int num){

       return dice = new Dice(num);
    }
}


