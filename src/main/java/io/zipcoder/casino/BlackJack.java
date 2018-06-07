//package io.zipcoder.casino;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class BlackJack extends CardGame implements Game{
//
//    enum BlackJackPlayer {player, computer};
//    private BlackJackPlayer winner;
//    private boolean isOver;
//    private boolean playerStands;
//    private ArrayList<Card> playerHand;
//    private ArrayList<Card> computerHand;
//
//    public BlackJack(){
//        super();
//        isOver = false;
//        playerStands = false;
//        playerHand = new ArrayList<Card>();
//        computerHand = new ArrayList<Card>();
//    }
//
//    public void playGame() {
//        deal();
//
//        while(!playerStands) {
//            nextTurn();
//        }
//
//        if ()
//
//    }
//
//    public Player getWinner() {
//        return null;
//    }
//
//    protected void deal(){
//        playerHand.add(deck.drawCard());
//        computerHand.add(deck.drawCard());
//        playerHand.add(deck.drawCard());
//        computerHand.add(deck.drawCard());
//    }
//
//    private void nextTurn() {
//        displayHand(playerHand);
//        displayHandOneHidden(computerHand);
//
//        if (hit()) {
//            playerHand.add(deck.drawCard());
//            displayHand(playerHand);
//        }
//        else {
//            playerStands = true;
//        }
//        printEndOfTurn();
//    }
//
//    private void displayHand(ArrayList<Card> hand) {
//        System.out.println("This is your current Hand");
//        for (int i = 0; i < playerHand.size(); i++) {
//            System.out.print(playerHand.get(i));
//        }
//        System.out.println();
//
//    }
//    private void displayHandOneHidden(ArrayList<Card> hand) {
//        System.out.println("This is the dealer's hand (She has one more)");
//        for (int i = 1; i < playerHand.size(); i++) {
//            System.out.println(computerHand.get(i));
//        }
//    }
//    private boolean hit() {
//        Scanner s = new Scanner(System.in);
//        System.out.println("Do you want a card? y/n ");
//        String yesNo = s.nextLine();
//        if (yesNo.equals("y")) {
//            return true;
//
//        }
//        else return false;
//    }
//
//    private int getTotal(ArrayList<Card> hand) {
//        int total = 0;
//        for (Card c : hand) {
//            total += c.getFace().getValue();
//        }
//        return total;
//    }
//    private void printEndOfTurn() {
//        int total = getTotal(playerHand);
//        System.out.println("Your new total is: " + total);
//        if (total == 21) {
//            System.out.println("You win!");
//            playerStands = true;
//            isOver = true;
//            winner = BlackJackPlayer.player;
//        } else if (total > 21) {
//            System.out.println("You Busted!");
//            playerStands = true;
//            isOver = true;
//            winner = BlackJackPlayer.computer;
//        } else {
//            System.out.println("On to the next turn!");
//        }
//    }
//}
