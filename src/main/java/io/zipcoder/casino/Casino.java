package io.zipcoder.casino;


public class Casino {

    public static void main(String[] args) {
        GameConsole totallyNotTheMob = new GameConsole();
        PreMadeMessages message = new PreMadeMessages();

        message.welcomeMessage();
        message.displayTheCat();
        message.rollTheDice();
    }


}
