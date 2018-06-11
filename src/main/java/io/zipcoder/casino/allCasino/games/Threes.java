
    package io.zipcoder.casino.allCasino.games;

    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.Scanner;
    import io.zipcoder.casino.allCasino.player.Player;
    import io.zipcoder.casino.allCasino.interfaces.*;
    import io.zipcoder.casino.allCasino.dice.Dice;



    public class Threes implements Game, Gamble{



        private int rollNumber;
        private Player player1;
        private Player player2;
        private int sum;
       private int sumPlayer1;
       private int sumPlayer2;
       private Player winner;
       private int pot;
      private  int numberOfDice; // will set these up for multiple turns and gambling.


        Dice dice = new Dice(5);


        public Threes() {
            rollNumber = 1;
            sum = 0;
            this.player1 = new Player(500, "You");
            this.player2 = new Player(100_000,"House");
        }

        public void placeBet(int helloKittyFunBucks) {
            pot = helloKittyFunBucks*2;
        }
        public int payOut() {
            return pot;
        }
        public int checkKittyBucksBalance(Player p) {
            return p.getHelloKittyFunBucks();
        }

        public void reset(){

        }

        public void playGame(){
            playGame();
            scoreRoll1(this.getPlayer1());
            scoreRoll2(this.getPlayer2());
            compareForWinner(this.getSumPlayer1(), this.getSumPlayer2());

        }

       public boolean getWinner() {
            if (winner == player1)
                return true;
            else
                return false;
        }

        public void setWinner(Player winner) {
            this.winner = winner;
        }

        public void setSum(int sum){
            this.sum = sum;
        }

        public int getSum(){
            return sum;
        }


        public int getSumPlayer1() {
            return sumPlayer1;
        }


        public int getSumPlayer2() {
            return sumPlayer2;
        }

        public Player getPlayer1(){
            return player1;
        }


        public Player getPlayer2(){
            return player2;
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
                sum += die;
            }
            return sum;
        }

        public void scoreRoll1(Player player1) {


            sumPlayer1 = roll();
            System.out.println("\t" + player1.getName() +" roll #" + rollNumber + " was "+ sumPlayer1);
            setSum(0);
        }

        public void scoreRoll2(Player player2) {

            sumPlayer2 = roll();
            System.out.println("\t" + player2.getName() + " roll #" + rollNumber + " was " + sumPlayer2);
            setSum(0);
        }




        public Player compareForWinner(int sumPlayer1, int sumPlayer2){
            Player gameWinner = (sumPlayer1 < sumPlayer2) ? player1 : player2;
            setWinner(gameWinner);
            System.out.println("\n\n"+ winner.getName() + " won!");
            return gameWinner;
        }



    }




