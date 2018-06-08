package io.zipcoder.casino;
import java.util.Random;


public class DummyGame implements Game{
    protected Player player1;
    protected Player player2;
    private int p1Score;
    private int p2score;
    private Player winner;



    public DummyGame(){
    this.player1 = new Player();
    this.player2 = new Player();


    }


    public void runGame(){


        //put all methods here


    }



    public int rand(){
        Random r = new Random();
        return r.nextInt(10)+1;
    }


    public void playGame() {

        p1Score = rand();
        p2score = rand();


    }

    public Player determineWinner(){
        if(p1Score > p2score){
            System.out.println("player one had: " + p1Score);
            System.out.println("player 2 score is: "+p2score);
            return player1;

        }

        else{
            System.out.println(p1Score);
            System.out.println(p2score);
            return player2;
        }






    }
    public void setWinner(Player winner){
        this.winner = winner;


    }
    public Player getWinner(){
        System.out.println(winner.toString());
        return winner;



    }








}
