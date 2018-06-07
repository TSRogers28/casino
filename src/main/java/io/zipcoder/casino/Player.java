package io.zipcoder.casino;

public class Player {
    String name = "A Cat Has No Name";
    int helloKittyFunBucks = 0;
    Card[] hand = new Card[]{};


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


    public Card playCard() {

        return hand[0];
    }

    public void removeCard(){
        Card[] tempHand = new Card[hand.length - 1];
        for (int i = 1; i < tempHand.length; i++){
            if(i < tempHand.length -1){
                tempHand[i-1] = hand[i];
            }else{tempHand[i] = hand[hand.length-1];}
        }
        this.hand = tempHand;
    }

    public void setHand(Card[ ] hand) {
        this.hand = hand;
    }


}


