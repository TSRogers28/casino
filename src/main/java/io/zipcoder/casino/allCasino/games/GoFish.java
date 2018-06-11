package io.zipcoder.casino.allCasino.games;

import io.zipcoder.casino.allCasino.ioMessages.*;
import io.zipcoder.casino.allCasino.card.Card;
import io.zipcoder.casino.allCasino.card.CardGame;
import io.zipcoder.casino.allCasino.interfaces.*;
import io.zipcoder.casino.allCasino.player.*;

public class GoFish extends CardGame implements Game{

    public static void main(String[] args) {
      GoFish gofish = new GoFish();
      gofish.playGame();
    }



    private boolean playerIsWinner;
    private boolean isOver;

    private GameConsole gameConsole;

    private GoFishHand playerHand;
    private GoFishHand computerHand;

    int playerPoints;
    int computerPoints;

    public GoFish() {
        super();
        isOver = false;
        playerHand = new GoFishHand();
        computerHand = new GoFishHand();
        playerPoints = 0;
        computerPoints = 0;
        gameConsole = new GameConsole();

    }

    @Override
    public void playGame() {
        deal();
        while (!isOver) {
            playerTurn();
            computerTurn();
        }
        endOfGame();
    }

    public void playerTurn() {
        playerHand.displayHand("This is your current hand!");
        Face face = whichCard();
        int cardCount = computerHand.checkHandForCard(face);
        if (cardCount > 0) {
            getCardsFromComputer(cardCount, face);
        }
        else {
            playerHand = goFish(playerHand);
        }
        if (!isOver) {
            int matches = playerHand.playFourOfAKinds();
            if (matches > 0) {
                playerPoints += matches;
                gameConsole.println("Your total score is: " + playerPoints);
            }
        }
        if (playerHand.getHandSize() == 0) { isOver = true; };
    }

    public void computerTurn() {
        gameConsole.println("It's the computer's turn.");
        Face fishFace = computerHand.whichCardShouldDealerFish();
        gameConsole.println("Computer asks, do you have any " + fishFace + "?");
        int cardCount = playerHand.checkHandForCard(fishFace);
        if (cardCount > 0) {
            gameConsole.println("Dude, you totally have those. Computer takes them. Oh no!");
            getCardsFromPlayer(cardCount, fishFace);
        }
        else {
            computerHand = goFish(computerHand);
        }
        if (!isOver) {
            int matches = computerHand.playFourOfAKinds();
            if (matches > 0) {
                playerPoints += matches;
                //gameConsole.println("Computer got a full set!");
                gameConsole.println("Computer total score is: " + matches);

            }
            computerPoints += matches;
        }
    }



    private void endOfGame() {
        gameConsole.println("No more cards to fish!");
        gameConsole.println("Go fish is over.");
        gameConsole.println("Your score was: " + playerPoints);
        gameConsole.println("Computer's score was: " + computerPoints);
        if (playerPoints >= computerPoints) {
            gameConsole.println("You win!");
            playerIsWinner = true;
        }
        else {
            gameConsole.println("You lose!");
            playerIsWinner = false;
        }
    }


    private void getCardsFromComputer(int cardCount, Face face) {
        gameConsole.println("Computer had the cards you wanted!");
        for (int i = 0; i < cardCount; i++) {
            Card newCard = computerHand.removeCard(face);
            playerHand.add(newCard);
            gameConsole.println(newCard.toString());
        }
    }

    private void getCardsFromPlayer(int cardCount,Face face) {
        gameConsole.println("Computer asked for a card you have!");
        for (int i = 0; i < cardCount; i++) {
            Card newCard = playerHand.removeCard(face);
            computerHand.add(newCard);
            gameConsole.println(newCard.toString());
        }
    }


    private GoFishHand goFish(GoFishHand hand) {
        if (deck.getNumberOfCardsRemaining() > 0) {
            gameConsole.println("Go Fish!");
            hand.add(deck.drawCard());
        }
        else {
            isOver = true;
        }
        return hand;
    }


    private Face whichCard () {
        String cardFace = gameConsole.stringScan("What card do you want?");
        Face face;

        switch (cardFace.toLowerCase()) {
            case "2" : case "two" : case "twos" : case "2s" :
                face = Face.TWO;
                break;
            case "3" : case "three" : case "threes" : case "3s" :
                face = Face.THREE;
                break;
            case "4" : case "four" : case "fours" : case "4s" :
                face = Face.FOUR;
                break;
            case "5" : case "five" : case "fives" : case "5s" :
                face = Face.FIVE;
                break;
            case "6" : case "six" : case "sixes" : case "6s" :
                face = Face.SIX;
                break;
            case "7" : case "seven" : case "sevens" : case "7s" :
                face = Face.SEVEN;
                break;
            case "8" : case "eight" : case "eights" : case "8s" :
                face = Face.EIGHT;
                break;
            case "9" : case "nine" : case "nines" : case "9s" :
                face = Face.NINE;
                break;
            case "10" : case "ten" : case "tens" : case "10s" :
                face = Face.TEN;
                break;
            case "jack" : case "jacks" :
                face = Face.JACK;
                break;
            case "queen" : case "queens" :
                face = Face.QUEEN;
                break;
            case "king" : case "kings" :
                face = Face.KING;
                break;
            case "ace" : case "aces" :
                face = Face.ACE;
                break;
            default :
                gameConsole.println("Sorry! Hello Kitty didn't understand what you said.");
                face = whichCard();
        }
        return face;

    }

    @Override
    protected void deal(){
        for (int i = 0; i < 5; i++) {
            playerHand.add(deck.drawCard());
            computerHand.add(deck.drawCard());
        }
    }

    @Override
    public boolean getWinner() {
        return false;
    }
}
