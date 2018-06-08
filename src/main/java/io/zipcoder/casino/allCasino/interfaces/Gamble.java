package io.zipcoder.casino.allCasino.interfaces;
import io.zipcoder.casino.allCasino.player.Player;

public interface Gamble {

    public void placeBet(int helloKittyFunBucks);
    public int payOut();
    public int checkKittyBucksBalance(Player p);

}
