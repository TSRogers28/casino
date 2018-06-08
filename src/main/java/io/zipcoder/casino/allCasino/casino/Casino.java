
package io.zipcoder.casino.allCasino.casino;
import io.zipcoder.casino.allCasino.games.BlackJack;
import  io.zipcoder.casino.allCasino.ioMessages.*;
import  io.zipcoder.casino.allCasino.player.*;
import io.zipcoder.casino.allCasino.ioMessages.PreMadeMessages;
import io.zipcoder.casino.allCasino.games.*;
import io.zipcoder.casino.allCasino.interfaces.*;





public class Casino {

    private boolean inTheCasino = true;
    //private boolean playingGames = false;


    GameConsole console = new GameConsole();
    PreMadeMessages messages = new PreMadeMessages();
    Game game;



    Player player1 = new Player(0, "");

    public void enterTheCasino() {
         player1.setName(console.stringScan("Whats Your Name?"));

         player1.setHelloKittyFunBucks(console.getIntegerInput("How Much Money Did You Bring Today?"));

         console.println(messages.displayTheCat);
         console.println(messages.rollTheDice);
         console.println(messages.welcomeMessage);

        playGames();
    }

    public void playGames(){

        while(inTheCasino == true){
            console.println(messages.mainMenu);

            switch(console.stringScan("What Would You Like To Do?")){
                case "see credits" : console.println("You Currently Have: " + player1.getHelloKittyFunBucks() + " Hello Kitty Fun Bucks!");
                    break;
                case "add credits" : console.println(messages.atm);
                    player1.addHelloKittyFunBucks(console.getIntegerInput("How Many Credits Would You Like To Add?"));
                    break;
                case "play games" : chooseGame();

                    break;
                case "exit" : console.println(messages.byeBye);
                    inTheCasino = false;
                    break;
                default: console.println("You Can't Do That, We Have Rules Here!! Please Choose An Available Option");
                    break;
            }
        }

    }


    public void chooseGame() {
        switch (console.stringScan("What Game Do You Want To Play? War, BlackJack, Threes, or Hi Lo?")) {
            case "war":
                ;
                break;
            case "blackjack":
                game = new BlackJack();
                game.playGame();
                break;
            case "threes":
                game = new Threes();
                game.playGame();
                break;
            case "hi lo":
                game = new DummyGame();
                game.playGame();
                break;
            default:
                console.println("Please Choose A Game We Have!");
                break;

        }

    }

}


