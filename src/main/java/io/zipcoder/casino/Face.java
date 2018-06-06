package io.zipcoder.casino;

enum Face{
    TWO (2, "|---|\n" + " | 2 |\n" + " |---|"), THREE (3, "|---|\n" + " | 3 |\n" + " |---|"),
    FOUR (4, "|---|\n" + " | 4 |\n" + " |---|"), FIVE (5, "|---|\n" + " | 5 |\n" + " |---|"),
    SIX (6, "|---|\n" + " | 6 |\n" + " |---|"), SEVEN (7, "|---|\n" + " | 7 |\n" + " |---|"),
    EIGHT (8, "|---|\n" + " | 8 |\n" + " |---|"), NINE (9, "|---|\n" + " | 9 |\n" + " |---|"),
    TEN (10, "|---|\n" + " | 10|\n" + "|---|"), JACK(11, "|---|\n" + " | J |\n" + " |---|"),
    QUEEN(12, "|---|\n" + " | Q |\n" + " |---|"), KING (13, "|---|\n" + " | K |\n" + " |---|"),
    ACE (14, "|---|\n" + " | A |\n" + " |---|");

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