package io.zipcoder.casino.allCasino.ioMessages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GameConsole {


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
        println(prompt);
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


