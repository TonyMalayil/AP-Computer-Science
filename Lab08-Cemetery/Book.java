public class Book
{
    private String title;
    private String author;
    private double price;

    public Book( String name, String creator, double cost)
    {
        title = name;
        author = creator;
        price = cost;
    }

    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public double getPrice()
    {
        return price;
    }

    public String toString()
    {
        String string = getTitle() + ", by " + getAuthor() + ". Cost: $" + getPrice();
        return string;
    }
}
