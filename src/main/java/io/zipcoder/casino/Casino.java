package io.zipcoder.casino;
import java.util.*;


public class Casino {


    public static void main(String[] args) {
        GameConsole totallyNotTheMob = new GameConsole();
        PreMadeMessages message = new PreMadeMessages();

        message.welcomeMessage();
        message.displayTheCat();
        message.rollTheDice();
        message.makeItRain();
        message.mainMenu();
    }



}

