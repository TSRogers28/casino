package io.zipcoder.casino;


public class Player {
    String name = "A Cat Has No Name";
    int helloKittyFunBucks = 0;



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



}


