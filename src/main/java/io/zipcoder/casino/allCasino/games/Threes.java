
    package io.zipcoder.casino.allCasino.games;

    import java.util.ArrayList;
    import java.util.Iterator;

    import io.zipcoder.casino.allCasino.ioMessages.GameConsole;
    import io.zipcoder.casino.allCasino.player.Player;
    import io.zipcoder.casino.allCasino.interfaces.*;
    import io.zipcoder.casino.allCasino.dice.Dice;



    public class Threes implements Game, Gamble{

        private int rollNumber;
        private Player player1;
        private Player player2;
        private int sumPlayer1;
        private int sumPlayer2;
        private Player winner;
        private  int sum;
        private int pot;
        private ArrayList<Integer> result;
        Dice dice;
        GameConsole console;


        public Threes() {
            dice = new Dice(5);
            console = new GameConsole();
            rollNumber = 0;
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
            scoreRollPlayer1(this.getPlayer1());
            scoreRollPlayer2(this.getPlayer2());

            compareForWinner(this.getSumPlayer1(), this.getSumPlayer2());
        }

       public boolean getWinner() {
            boolean answer = (winner == player1);
                return answer;
        }

        public void setWinner(Player winner) {
            this.winner = winner;
        }

        public void setSumPlayer1(int sum){
            sumPlayer1 = sum;
        }

        public int getSumPlayer1() {
            return sumPlayer1;
        }
        public void setSumPlayer2(int sum){
            sumPlayer2 = sum;
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

        public void setRollNumber(int rollNumber){
            this.rollNumber = rollNumber;
        }

        public int getRollNumber(){
            return rollNumber;
        }

        public void setResult(ArrayList<Integer> result){
            this.result = result;
        }

        public ArrayList<Integer> getResult(){
            return result;
        }


        public ArrayList<Integer> roll() {
            setResult(dice.toss());
            return result;
        }
        public int displayDiceAndSum(ArrayList<Integer> result){
        Iterator<Integer> arrayIterator = result.iterator();

            while (arrayIterator.hasNext()) {
            int die = arrayIterator.next();
            console.print("\t" + die);
            if (3 == die) {
                die = 0;
            }

            sum += die;
        }
            return sum;
    }




        public void scoreRollPlayer1(Player player1) {
            setSumPlayer1(displayDiceAndSum(roll()));
            setRollNumber(1);
            console.println("\t" + player1.getName() +" roll #" + getRollNumber() + " was "+ getSumPlayer1());
        }

        public void scoreRollPlayer2(Player player2) {
            console.println("");
            setSumPlayer2(displayDiceAndSum(roll()));
            console.println("\t" + player2.getName() + " roll #" + getRollNumber() + " was " + getSumPlayer1());
        }

        public Player compareForWinner(int sumPlayer1, int sumPlayer2){
            Player gameWinner = (sumPlayer1 < sumPlayer2) ? player1 : player2;
            setWinner(gameWinner);
            console.println("\n\n"+ winner.getName() + " won!");
            return gameWinner;
        }



    }




