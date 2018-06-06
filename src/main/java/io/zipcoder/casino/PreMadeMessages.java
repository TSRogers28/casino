package io.zipcoder.casino;

public class PreMadeMessages {

    public void welcomeMessage() {
        System.out.println("Welcome To The Hello Kitty™ Adventure Island Casino!!");
    }

    public void displayTheCat() {

        System.out.println(
                " _   _         _  _          _   __ _\n" +
                        "| | | |  ___  | || |  ___   | | / /(_)  _     _\n" +
                        "| |_| | / _ \\ | || | / _ \\  | |/ /  _ _| |_ _| |_  _  _\n" +
                        "|  _  |/ /_\\ \\| || |/ / \\ \\ |   /  | |_   _|_   _|| |/ /\n" +
                        "| | | |\\ ,___/| || |\\ \\_/ / | |\\ \\ | | | |_  | |_ | / /\n" +
                        "|_| |_| \\___/ |_||_| \\___/  |_| \\_\\|_| \\___| \\___||  /\n" +
                        "                     _           _                / /\n" +
                        "                    / \\_______ /|_\\™              \\/\n" +
                        "                   /          /_/ \\__\n" +
                        "                  /             \\_/ /\n" +
                        "                _|_              |/|_\n" +
                        "                _|_  O    _    O  _|_\n" +
                        "                _|_      (_)      _|_\n" +
                        "                 \\                 /\n" +
                        "                  _\\_____________/_\n" +
                        "                 /  \\/  (___)  \\/  \\\n" +
                        "                 \\__(  o     o  )__/");
    }

    public void rollTheDice() {
        System.out.println(
                "                           (( _______\n" +
                        "                 _______     /\\O    O\\\n" +
                        "                /O     /\\   /  \\      \\\n" +
                        "               /   O  /O \\ / O  \\O____O\\ ))\n" +
                        "            ((/_____O/    \\\\    /O     /\n" +
                        "              \\O    O\\    / \\  /   O  /\n" +
                        "               \\O    O\\ O/   \\/_____O/\n" +
                        "                \\O____O\\/ ))          ))\n" +
                        "              ((");

    }

    public void makeItRain() {
        System.out.println(
                "                   $$$$                                                            \n" +
                        "           $$$$$$$$$$$$$$$$$                                                       \n" +
                        "       $$$$$$$$$$$$$$$$$$$$$$                                                      \n" +
                        "    $$$$$$         $$$$    $$$$$$$$                                                \n" +
                        "   $$$$$$          $$$$        $$$$$$$                                             \n" +
                        "  $$$$$$           $$$$          $$$$$$                                            \n" +
                        "  $$$$$$           $$$$                                                            \n" +
                        "  $$$$$$           $$$$                             _           _                  \n" +
                        "   $$$$$$          $$$$                            / \\_______ /|_\\™              \n" +
                        "     $$$$$$$$      $$$$                           /          /_/ \\__\\            \n" +
                        "        $$$$$$$$$$$$$$$                          /             \\_/ /\\            \n" +
                        "          $$$$$$$$$$$$$$$$$$                   _|_              |/|_\\             \n" +
                        "             $$$$$$$$$$$$$$$$                  _|_  O    _    O  _|_               \n" +
                        "                   $$$$ $$$$$$$$$$             _|_      (_)      _|_               \n" +
                        "                   $$$$       $$$$$$$           \\                 /               \n" +
                        "                   $$$$          $$$$$$          _\\_____________/_                \n" +
                        "                   $$$$           $$$$$$        /  \\/  (___)  \\/  \\             \n" +
                        "$$$$$$$            $$$$          $$$$$$$        \\__(  o     o  )__/               \n" +
                        " $$$$$$            $$$$          $$$$$$                                            \n" +
                        "  $$$$$$$          $$$$        $$$$$$$                                             \n" +
                        "   $$$$$$$$        $$$$      $$$$$$$                                               \n" +
                        "      $$$$$$$$$$$$$$$$$$$$$$$$$$$$                                                 \n" +
                        "          $$$$$$$$$$$$$$$$$$$$$                                                    \n" +
                        "                   $$$$                                                            \n"
        );

    }


    public void mainMenu(){
        System.out.println(
                "Welcome To The Main Menu:\n" +
                "See Credits: Shows You How Many Hello Kitty™ Fun Bucks You Currently Have.\n" +
                "Add Credits: Add More Hello Kitty™ Fun Bucks So You Can Continue The Fun!\n" +
                "Play Games: Get A List To Choose From Of All Our Amazing Games! \n" +
                "Exit: Leave The Casino And Make Hello Kitty™ Cry  Ó╭╮Ò...\n");
    }

    public void warMenu(){
        System.out.println(
                "Welcome To The War Menu:\n" +
                "Exit: Leave The War Room And Head Back To The Casino!");
    }

    public void blackJackMenu(){
        System.out.println(
                "Welcome To The Black Jack Menu:\n" +
                "Bet: Place A Wager.\n" +
                "Hit: Add Another Card To Your Hand.\n" +
                "Stay: Keep Your Current Hand Until The End Of The Game. \n" +
                "Exit: Leave The Black Jack Table And Head Back To The Casino!");
    }

    public void threesMenu(){}


    String[] cardPics = new String[]
               {"|---|\n" + "| 2 |\n" + "|---|\n" ,
                "|---|\n" + "| 3 |\n" + "|---|\n" ,
                "|---|\n" + "| 4 |\n" + "|---|\n" ,
                "|---|\n" + "| 5 |\n" + "|---|\n" ,
                "|---|\n" + "| 6 |\n" + "|---|\n" ,
                "|---|\n" + "| 7 |\n" + "|---|\n" ,
                "|---|\n" + "| 8 |\n" + "|---|\n" ,
                "|---|\n" + "| 9 |\n" + "|---|\n" ,
                "|---|\n" + "| 10|\n" + "|---|\n" ,
                "|---|\n" + "| J |\n" + "|---|\n" ,
                "|---|\n" + "| Q |\n" + "|---|\n" ,
                "|---|\n" + "| K |\n" + "|---|\n" ,
                "|---|\n" + "| A |\n" + "|---|\n"};

     String[] suits = new String[]{"♠","♥","♣","♦"};

    public String callCard(String suit, String value) {
        System.out.println();

    }

}


