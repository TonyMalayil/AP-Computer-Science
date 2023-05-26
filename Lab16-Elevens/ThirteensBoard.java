import java.util.ArrayList;
import java.util.List;

public class ThirteensBoard extends Board{

    private static final int BOARD_SIZE = 10;

    private static final boolean I_AM_DEBUGGING = false;

    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 12, 0};

    public ThirteensBoard()
    {
        super(BOARD_SIZE);

        deck = new Deck(RANKS, SUITS, POINT_VALUES);
        if (I_AM_DEBUGGING) {
            System.out.println(deck);
            System.out.println("----------");
        }
        dealMyCards();
    }

    private boolean containsPairSum13( List<Integer> selectedCards )
    {
        Boolean contains = false;

        for( int i = 0; i < selectedCards.size(); i++)
        {
            for( int q = i+1; q < selectedCards.size(); q++)
            {

                if( ( cardAt(selectedCards.get(i) ).pointValue() + cardAt( selectedCards.get(q)).pointValue() ) == 13)
                    contains = true;
            }
        }

        return contains;
    }

    private boolean containsK( List<Integer> selectedCards )
    {
        Boolean containKing = false;

        for( int i = 0; i < selectedCards.size(); i++)
        {
            if( cardAt( selectedCards.get(i) ).pointValue() == 0 )
                containKing = true;
        }

        return containKing;
    }

    public boolean isLegal(List<Integer> selectedCards)
    {
        Boolean legal = false;

        if( containsPairSum13(selectedCards))
            legal = true;
        if (containsK(selectedCards))
            legal = true;

        return legal;
    }

    public boolean anotherPlayIsPossible() {
        Boolean anothaOne = false;

        if( isLegal(cardIndexes()))
        {
            anothaOne = true;
        }

        return anothaOne;
    }

    public void replaceSelectedCards(List<Integer> selectedCards)
    {
        for (Integer k : selectedCards) {
            deal(k.intValue()); //intValue() returns the int value for an Integer object
        }
    }

    public String toString() {
        String s = "";
        for (int k = 0; k < cards.length; k++) {
            s = s + k + ": " + cards[k] + "\n";
        }
        return s;
    }

}
