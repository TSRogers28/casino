package io.zipcoder.casino;

public class Card implements Comparable<Card>{

    private Suit suit;
    private Face face;



    public Card(Face face, Suit suit){
        this.face = face;
        this.suit = suit;

    }

    public Suit getSuit(){

        return suit;
    }

    public Face getFace(){

        return face;
    }

    public int compareTo(Card card){
    return Integer.compare(face.getValue(), card.getFace().getValue());
}

    public String toString() {
        return suit.getSymbol() + face.getCardImage() + suit.getSymbol();
    }

}
