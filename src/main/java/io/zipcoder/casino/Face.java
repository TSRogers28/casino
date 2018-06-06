package io.zipcoder.casino;

enum Face{
    TWO (2, "|---|\n" + "| 2 |\n" + "|---|\n"), THREE (3, "|---|\n" + "| 3 |\n" + "|---|\n"),
    FOUR (4, "|---|\n" + "| 4 |\n" + "|---|\n"), FIVE (5, "|---|\n" + "| 5 |\n" + "|---|\n"),
    SIX (6, "|---|\n" + "| 6 |\n" + "|---|\n"), SEVEN (7, "|---|\n" + "| 7 |\n" + "|---|\n"),
    EIGHT (8, "|---|\n" + "| 8 |\n" + "|---|\n"), NINE (9, "|---|\n" + "| 9 |\n" + "|---|\n"),
    TEN (10, "|---|\n" + "| 10|\n" + "|---|\n"), JACK(11, "|---|\n" + "| J |\n" + "|---|\n"),
    QUEEN(12, "|---|\n" + "| Q |\n" + "|---|\n"), KING (13, "|---|\n" + "| K |\n" + "|---|\n"),
    ACE (14, "|---|\n" + "| A |\n" + "|---|\n");

    private final int value;
    private final String cardImage;

    private Face(int value, String cardImage){
        this.value = value;
        this.cardImage = cardImage;
    }

    public int getValue(){
        return value;
    }
    public String getCardImage() { return cardImage; }
}