public class Toy
{
    private String name;

    public Toy( String n)
    {
        name = n;
    }

    public String toString()
    {
        return "A " + name + ".";
    }

    public String getName()
    {
        return name;
    }
    public boolean equals(Toy t)
    {
        if( this.name.equals(t.getName()))
            return true;
        else
            return false;
    }
}
