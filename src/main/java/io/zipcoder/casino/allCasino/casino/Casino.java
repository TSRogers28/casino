
package io.zipcoder.casino.allCasino.casino;
import io.zipcoder.casino.allCasino.games.BlackJack;
import  io.zipcoder.casino.allCasino.ioMessages.*;
import  io.zipcoder.casino.allCasino.player.*;
import io.zipcoder.casino.allCasino.ioMessages.PreMadeMessages;
import io.zipcoder.casino.allCasino.games.*;






public class Casino {

    private boolean inTheCasino = true;
    //private boolean playingGames = false;


    GameConsole console = new GameConsole();
    PreMadeMessages messages = new PreMadeMessages();
    DummyGame dummy = new DummyGame();
    BlackJack twentyOne = new BlackJack();
    Threes threes = new Threes();
    War war = new War();


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
                case "exit" : console.println(messages.byeBye); setInTheCasino();
                    break;
                default: console.println("You Can't Do That, We Have Rules Here!! Please Choose An Available Option");
                    break;
            }
        }

    }

    public void chooseGame(){

            switch(console.stringScan("What Game Do You Want To Play? War, BlackJack, Threes, or Hi Lo?")){
                case "war" : war.playGame();
                    break;
                case "blackjack" : twentyOne.playGame();
                    break;
                case "threes" : threes.playGame();
                    break;
                case "hi lo" : dummy.runGame();
                    break;
                case "exit" : console.println("Back To The Casino!");
                    break;
                default:console.println("Please Choose A Game We Have!");
                    break;
            }
        }


    public void setInTheCasino(){
        if (this.inTheCasino == true){

            this.inTheCasino = false;
        }
    }

    public boolean isInTheCasino() {
        return inTheCasino;
    }
}


