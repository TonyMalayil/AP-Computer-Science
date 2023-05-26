public class Cat extends Animal
{
    private int numLives;

    public Cat( String n, int y, int lives)
    {
        super( n, y);
        numLives = lives;
    }

    public Cat( String n, int y )
    {
        super( n, y);
        numLives = 9;
    }

    public String toString()
    {
        return super.toString() + " I have " + numLives + " lives.";
    }
}
