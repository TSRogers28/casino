package io.zipcoder.casino;

import org.junit.Test;

import static org.junit.Assert.*;
import io.zipcoder.casino.allCasino.player.*;


public class PlayerTest {

    @Test
    public void getName() {
        Player chairManMeow = new Player(100000, "Chairman Meow");
        String actual = chairManMeow.getName();
        String expected = "Chairman Meow";
        assertEquals(expected,actual);
    }

    @Test
    public void setName() {
        Player generalMeow = new Player(100000, "General Meow");
        generalMeow.setName("Kitty Bang Bang");

        String actual = generalMeow.getName();
        String expected = "Kitty Bang Bang";
        assertEquals(expected,actual);
    }

    @Test
    public void getHelloKittyFunBucks() {
        Player chairmanMeow = new Player(1000, "Chairman Meow");

        int actual = chairmanMeow.getHelloKittyFunBucks();
        int expected = 1000;
        assertEquals(expected,actual);
    }

    @Test
    public void setHelloKittyFunBucks() {
        Player chairmanMeow = new Player(1000, "Chairman Meow");
        chairmanMeow.setHelloKittyFunBucks(2000);

        int actual = chairmanMeow.getHelloKittyFunBucks();
        int expected = 2000;
        assertEquals(expected,actual);
    }

    @Test
    public void addHelloKittyFunBucks() {
        Player chairmanMeow = new Player(1000, "Chairman Meow");
        chairmanMeow.addHelloKittyFunBucks(1000);

        int actual = chairmanMeow.getHelloKittyFunBucks();
        int expected = 2000;
        assertEquals(expected,actual);
    }
    

}