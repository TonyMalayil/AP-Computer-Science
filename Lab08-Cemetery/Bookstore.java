import java.util.*;

public class Bookstore
{
    ArrayList<Book> inventory;

    public Bookstore()
    {
        inventory = new ArrayList<Book>();
    }

    public void addBook( Book b)
    {
        inventory.add(b);
    }

    public int numBooks()
    {
        return inventory.size();
    }

    public Book getBook( int index )
    {
        Book book = inventory.get(index);
        if( (index >= inventory.size()) || (index < 0) )
            book = null;
        return book;
    }
}
