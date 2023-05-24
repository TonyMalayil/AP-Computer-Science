public class Truck extends Vehicle
{
    private int towing;

    public Truck( String theType, int theYear, double cost, int tow)
    {
        super( theType, theYear, cost);
        towing = tow;
    }

    public boolean canTowBoat()
    {
        if( towing >= 2000)
            return true;
        else
            return false;
    }

    public String getInfo()
    {
        return super.getInfo() + ", " + towing + " lbs. towing, $" + super.getPrice();
    }
}
