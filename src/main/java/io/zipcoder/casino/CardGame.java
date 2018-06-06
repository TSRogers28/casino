

public abstract class CardGame{

    private Card[] deck;
    Player[] players;

    public abstract Card[] deal(Player p);
    public abstract getCardValue(Card c);

    public CardGame() {
        
    }

    public Card getTopCard() {
        return null;
    }
    private void shuffle(){

    }

    private void resetDeck() {

    }



}