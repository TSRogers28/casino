package io.zipcoder.casino.allCasino.games;

import java.util.Random;

import io.zipcoder.casino.allCasino.interfaces.Game;
import io.zipcoder.casino.allCasino.player.*;


public class DummyGame implements Game{
    public Player player1;
    public Player player2;
    private int p1Score;
    private int p2score;
    private Player winner;



    public DummyGame(){
    this.player1 = new Player(0, "You");
    this.player2 = new Player(0,"House");


    }

    public void reset(){
        this.runGame();


    }


    public void playGame(){
    runGame();
    determineWinner();
    }



    public int rand(){
        Random r = new Random();
        return r.nextInt(10)+1;
    }


    public void runGame() {

        p1Score = rand();
        p2score = rand();


    }

    public void determineWinner(){
        if(p1Score > p2score){
            System.out.println("player 1 score is: " + p1Score);
            System.out.println("player 2 score is: " + p2score);
            setWinner(player1);
           // return getWinner();

        }

        else{
            System.out.println(p1Score);
            System.out.println(p2score);
            setWinner(player2);
            //return getWinner();
        }






    }
    public void setWinner(Player winner){
        this.winner = winner;


    }
    public boolean getWinner(){
        System.out.println(winner.getName() + " Wins!");
        if (player1 == winner) {
            return true;
        }
        else return false;



    }








}
