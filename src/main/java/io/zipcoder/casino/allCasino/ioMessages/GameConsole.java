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






    }


