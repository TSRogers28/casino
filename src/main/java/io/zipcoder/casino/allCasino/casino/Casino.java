
package io.zipcoder.casino.allCasino.casino;
import  io.zipcoder.casino.allCasino.ioMessages.*;
import  io.zipcoder.casino.allCasino.player.*;
import io.zipcoder.casino.allCasino.ioMessages.PreMadeMessages;
import io.zipcoder.casino.allCasino.games.DummyGame;






public class Casino {

    private boolean inTheCasino = true;
    private boolean playingGames = false;

    GameConsole console = new GameConsole();
    PreMadeMessages messages = new PreMadeMessages();
    DummyGame dummy = new DummyGame();
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
                case "play games" : chooseGame(console.stringScan("What Game Would You Like To Play?"));

                    break;
                case "exit" : console.println(messages.byeBye); inTheCasino = false;
                    break;
                default: console.println("You Can't Do That, We Have Rules Here!! Please Choose An Available Option");
                    break;
            }
        }

    }

    public void chooseGame(String choice){
        playingGames = true;
        while(playingGames = true){
            switch(console.stringScan("What Game Do You Want To Play? War, BlackJack, Threes, or Hi Lo?")){
                case "war" : ;
                    break;
                case "blackjack" : ;
                    break;
                case "threes" : ;
                    break;
                case "hi lo" : dummy.runGame(); playingGames = false;
                    break;
                case "exit" : console.println("Back To The Casino!"); playingGames = false;
                    break;
                default:console.println("Please Choose A Game We Have!");
                    break;
            }
        }

    }

}


