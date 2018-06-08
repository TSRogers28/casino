
    package io.zipcoder.casino.allCasino.games;

    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.Scanner;
    import io.zipcoder.casino.allCasino.player.Player;
    import io.zipcoder.casino.allCasino.interfaces.Game;
    import io.zipcoder.casino.allCasino.dice.Dice;



    public class Threes implements Game{



        int rollNumber;
        Player player1;
        Player player2;
        int sum;
        int sumPlayer1;
        int sumPlayer2;
        Player winner;
        int ante;
        int numberOfDice; // will set these up for multiple turns and gambling.


        public static void main(String[] args) {
            Threes game = new Threes();
            game.playGame();
            game.scoreRoll1(game.getPlayer1());
            game.scoreRoll2(game.getPlayer2());
            game.compareForWinner(game.getSumPlayer1(), game.getSumPlayer2());
        }

        Dice dice = new Dice(5);


        public Threes() {
            rollNumber = 1;
            sum = 0;
            ante = 0;
            this.player1 = new Player(500, "You");
            this.player2 = new Player(100_000,"House");
        }

        public void playGame(){
            Scanner scan = new Scanner(System.in);
            System.out.println("How much would you like to bet?");
            ante = scan.nextInt();
        }

        public Player getWinner() {
            return winner;
        }

        public void setWinner(Player winner) {
            this.winner = winner;
        }

        public void setSum(int sum){
            this.sum = sum;
        }


        public int getSumPlayer1() {
            return sumPlayer1;
        }


        public int getSumPlayer2() {
            return sumPlayer2;
        }

        //public void setPlayer1(int credits, int ante){
        //    player1(credits - ante);
        //}

        public Player getPlayer1(){
            return player1;
        }

        public void setPlayer2(){

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

        public void compareForWinner(int sumPlayer1, int sumPlayer2){
            Player winner = (sumPlayer1 < sumPlayer2) ? player1 : player2;

            System.out.println("\n\n\n"+ winner.getName() + " wins!");
            //game.setWinner(winner);
        }

//        public void getOut(){
//
//        } This will return back into the casino when ready;


    }




