package io.zipcoder.casino;

import java.util.Scanner;

public class GameConsole {

    public void welcomeMessage() {
        System.out.println("Welcome To The Hello Kitty Adventure Island Casino!!");
        }
        public void displayTheCat(){

            System.out.println(
                    " _   _         _  _          _   __ _\n" +
                    "| | | |  ___  | || |  ___   | | / /(_)  _     _\n" +
                    "| |_| | / _ \\ | || | / _ \\  | |/ /  _ _| |_ _| |_  _  _\n" +
                    "|  _  |/ /_\\ \\| || |/ / \\ \\ |   /  | |_   _|_   _|| |/ /\n" +
                    "| | | |\\ ,___/| || |\\ \\_/ / | |\\ \\ | | | |_  | |_ | / /\n" +
                    "|_| |_| \\___/ |_||_| \\___/  |_| \\_\\|_| \\___| \\___||  /\n" +
                    "                     _           _                / /\n" +
                    "                    / \\_______ /|_\\               \\/\n" +
                    "                   /          /_/ \\__\n" +
                    "                  /             \\_/ /\n" +
                    "                _|_              |/|_\n" +
                    "                _|_  O    _    O  _|_\n" +
                    "                _|_      (_)      _|_\n" +
                    "                 \\                 /\n" +
                    "                  _\\_____________/_\n" +
                    "                 /  \\/  (___)  \\/  \\\n" +
                    "                  \\__(  o     o  )__/");
        }
        public void rollTheDice(){
            System.out.println(
                    "                           (( _______\n" +
                    "                 _______     /\\O    O\\\n" +
                    "                /O     /\\   /  \\      \\\n" +
                    "               /   O  /O \\ / O  \\O____O\\ ))\n" +
                    "            ((/_____O/    \\\\    /O     /\n" +
                    "              \\O    O\\    / \\  /   O  /\n" +
                    "               \\O    O\\ O/   \\/_____O/\n" +
                    "                \\O____O\\/ ))          ))\n" +
                    "              ((");

        }

        public void print(String output, Object... args){
            System.out.printf(output, args);
        }

        public void println(String output, Object... args){
            print(output + "\n", args);
        }

        public String stringScan(String prompt){
            Scanner stringIn = new Scanner(System.in);
            println(prompt);
            String userInput = stringIn.nextLine();
            String userInputFinal = userInput.toLowerCase();
            return userInputFinal;
        }

        public Integer getIntegerInput(String prompt) {

        Integer userInput = 0;
        while(userInput == 0) {
            Scanner integerIn = new Scanner(System.in);
            if (integerIn.hasNextInt()) {
                userInput = integerIn.nextInt();
            } else {
                System.out.println("Must Be Greater Than 0! Please Try again!!");
            }
        }
            return userInput;
        }
}
