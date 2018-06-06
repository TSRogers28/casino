package io.zipcoder.casino;

public class Player {
    String name;
    int helloKittyFunBucks;
    //Card hand;
    //Dice roll;

    public Player(){

    }
    public Player(int credits){

     this.helloKittyFunBucks = credits;
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

    /*
    public Card getHand() {
        return hand;
    }

    public void setHand(Card hand) {
        this.hand = hand;
    }
    */


//    public Dice getRoll(){return roll;}
//    public void setRoll(Dice roll){ this.roll = roll;}
}


