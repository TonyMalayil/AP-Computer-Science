public class Car extends Vehicle
{
    private double mpg;

    public Car( String theType, int theYear, double cost, double milePgal)
    {
        super( theType, theYear, cost);
        mpg = milePgal;
    }

    public boolean greatMPG()
    {
        if( mpg >= 36)
            return true;
        else
            return false;
    }

    public String getInfo()
    {
        return super.getInfo() + ", " + mpg + " mpg, $" + super.getPrice();
    }
}
