
    package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



    public class Threes implements Game{


        int sumTemp;
        int rollNumber;
        Player firstPlayer;
        Player secondPlayer;
        Player player1;
        Player player2;
        int sumPlayer1;
        int sumPlayer2;
        Player winner;
        int ante;
        int numberOfDice; // will set these up for multiple turns and gambling.


        public static void main(String[] args) {
            Threes game = new Threes();

            game.scoreRoll1(game.choosePlayer());
            game.scoreRoll2(game.getPlayer2());
            game.compareForWinner(game.getSumPlayer1(), game.getSumPlayer2());
        }

        Dice dice = new Dice(5);


        public Threes() {
            rollNumber = 1;
            this.player1 = new Player(500 , "Tommy");
            this.player2 = new Player(500, "Dave");
        }

        public void playGame(){

        }

        public Player getWinner() {
            return winner;
        }

        public void setWinner(Player winner) {
            this.winner = winner;
        }

        public void setSumPlayer1(int sumTemp){
            sumPlayer1 = sumTemp;
        }

        public int getSumPlayer1() {
            return sumPlayer1;
        }

        public void setSumPlayer2(int sumTemp){
            sumPlayer2 =sumTemp;
        }

        public int getSumPlayer2() {
            return sumPlayer2;
        }

        public void setSumTemp(int sumTemp) {
            this.sumTemp = sumTemp;
        }

        public Player getPlayer1(){
            return player1;
        }

        public Player getPlayer2(){
            return player2;
        }

        public Player choosePlayer() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Who wants to start?");
            String pickedPlayer = scan.next();
            firstPlayer = (pickedPlayer.equals(getPlayer1())) ? getPlayer1() : getPlayer2();
            secondPlayer = (pickedPlayer.equals(getPlayer2())) ? getPlayer2() : getPlayer1();
            return null;
        }


        public int roll() {
            ArrayList<Integer> result = dice.toss();
            Iterator<Integer> arrayIterator = result.iterator();

            while (arrayIterator.hasNext()) {
                int die = arrayIterator.next();
                System.out.print("\t" + die);
                if (3 == die) {
                    die = 0;
                }
                sumTemp += die;
            }
            return sumTemp;
        }


        public void scoreRoll1(Player firstPlayer) {
            roll();
            sumPlayer1 = sumTemp;
            System.out.println("\t" + firstPlayer.getName() +" roll #" + rollNumber + " was "+ sumPlayer1);
            setSumTemp(0);
        }

        public void scoreRoll2(Player secondPlayer) {
            roll();
            sumPlayer2 = sumTemp;
            System.out.println("\t" + secondPlayer.getName() + " roll #" + rollNumber + " was " + sumPlayer2);
            setSumTemp(0);
        }

        public void turn() {


            while (rollNumber <= 1) {
                if (firstPlayer == player1) {


                } else {


                }
            }
        }

        public void compareForWinner(int sumPlayer1, int sumPlayer2){
            Player winner = (sumPlayer1 < sumPlayer2) ? player1 : player2;

            System.out.println("\n\n\n"+ winner.getName() + " wins!");
            //game.setWinner(winner);
        }

//        public void getOut(){
//
//        } This will return back into the casino when ready;


    }




