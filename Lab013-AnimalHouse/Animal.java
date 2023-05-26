import java.util.*;

public class Animal
{
    private String name;
    private int birthyear;
    private ArrayList<Toy> toys;
    private Animal friend = null;
    static int currentYear = 2022;

    public Animal( String n, int year)
    {
        name = n;
        birthyear = year;
        toys = new ArrayList<>();
    }

    public void addToy( Toy theToy)
    {
        toys.add(theToy);
    }

    public int getAge()
    {
        return currentYear - birthyear;
    }

    public String toString()
    {
        String str = "Hello, I am " + name + " . I am " + getAge() + " years old.";
        if( !friend.equals(null))
            str+= " I have a friend named" + friend.name + ".";
        else
            str+= " I have no friends.";

        str+= " I have the following toys: " + toys.toString() + ".";

        return str;
    }

    public void setFriend( Animal b)
    {
        friend = b;
    }
}
