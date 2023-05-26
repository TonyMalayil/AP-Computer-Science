import java.util.ArrayList;
import java.util.List;

abstract class Board
{
    final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};

    Card[] cards;

    Deck deck;

    public Board( int size)
    {
        cards = new Card[size];
    }

    public int size() {
        return cards.length;
    }

    public int deckSize() {
        return deck.size();
    }


    public Card cardAt(int k) {
        return cards[k];
    }

    abstract boolean isLegal(List<Integer> selectedCards);

    abstract boolean anotherPlayIsPossible();

    public void newGame() {
        deck.shuffle();
        dealMyCards();
    }

    public boolean isEmpty() {
        for (int k = 0; k < cards.length; k++) {
            if (cards[k] != null) {
                return false;
            }
        }
        return true;
    }

    abstract void replaceSelectedCards(List<Integer> selectedCards);

    public List<Integer> cardIndexes() {
        List<Integer> cardIndexes = new ArrayList<>();

        for( int i = 0; i < cards.length; i++)
        {
            if( cards[i] != null )
                cardIndexes.add(i);
        }

        return cardIndexes;
    }

    public void dealMyCards() {
        for (int k = 0; k < cards.length; k++) {
            cards[k] = deck.deal();
        }
    }

    public void deal(int k) {
        cards[k] = deck.deal();
    }


}
