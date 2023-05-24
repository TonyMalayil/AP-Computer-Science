import java.util.*;

public class ArrayListProbs
{

    public void makeListandPrint( int num, int limit)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Random rng = new Random();
        for( int a = 0; a < num; a++)
        {
            int thing = rng.nextInt(limit) + 1;
            list.add(thing);
        }
        System.out.println(list);
    }

    public ArrayList<Integer> addOne(ArrayList<Integer> list)
    {
        ArrayList<Integer> newList = list;
        for( int i = 0; i < list.size(); i++)
        {
            newList.set( i, list.get(i)+1 );
        }

        return newList;
    }

    public ArrayList<Integer> minToFront(ArrayList<Integer> list)
    {
        int smallest = Integer.MAX_VALUE;
        ArrayList<Integer> newList = new ArrayList <Integer>(Arrays.asList(0));

        for( int i = 0; i < list.size(); i++)
        {
            if( smallest > list.get(i) )
                smallest = list.get(i);

            newList.add( list.get(i));
        }
        newList.set( 0, smallest);

        return newList;
    }


    public ArrayList<String> removeDupes(ArrayList<String> list)
    {
        ArrayList<String> newList = list;

        for( int i = 0; i < list.size()-1; i++)
        {
            if ( list.get(i).equals( list.get(i+1) ) )
            {
                newList.remove(i);
                i--;
            }
        }

        return newList;
    }

    public ArrayList<Integer> swapPairs(ArrayList<Integer> list)
    {
        ArrayList<Integer> newList = new ArrayList <Integer>(Arrays.asList());

        for( int i = 1; i < list.size(); i = i + 2)
        {
            newList.add( list.get(i) );
            newList.add( list.get(i-1) );
        }

        return newList;
    }

    public ArrayList<String> removeLenN( ArrayList<String> list, int n)
    {
        ArrayList<String> newList = new ArrayList <String>(Arrays.asList());

        for( int i = 1; i < list.size(); i++)
        {
            if ((list.get(i)).length() != n)
                newList.add(list.get(i));
        }
        return newList;
    }

    public int dumbestPerson(ArrayList<Person> list)
    {
        int index = 0;
        int smallestIQ = 999;
        for( int i = 0; i < list.size(); i++)
        {
            if( (list.get(i)).getIQ() < smallestIQ)
            {
                index = i;
                smallestIQ = list.get(i).getIQ();
            }
        }
        return index;
    }

    public Book highestPricedBook(ArrayList<Book> list)
    {
        int index = 0;
        double largest = Integer.MIN_VALUE;
        for( int i = 0; i < list.size(); i++)
        {
            if( list.get(i).getPrice() > largest)
            {
                index = i;
                largest = list.get(i).getPrice();
            }
        }

        return list.get(index);
    }

    public ArrayList<Book> banBook(ArrayList<Book> list, Book book)
    {
        ArrayList<Book> newList = new ArrayList <Book>(Arrays.asList());

        for( int i = 0; i < list.size(); i++)
        {
            if( !(list.get(i).getTitle().equals(book.getTitle() )) )
                newList.add(list.get(i));
        }

        return newList;
    }

    public double bookstoreValue( Bookstore store)
    {
        double sum = 0;
        for( int i = 0; i < store.numBooks(); i++)
        {
            sum += store.getBook(i).getPrice();
        }

        return sum;
    }
}
