public class Dog extends Animal
{
    private boolean goodBoy;

    public Dog( String n, int birth, boolean good)
    {
        super( n, birth);
        goodBoy = good;
    }

    public String toString()
    {
        String good;
        if( goodBoy)
            good= "a good boy";
        else
            good = "not a good boy";
        return super.toString() + " I am " + good + ".";
    }
}
