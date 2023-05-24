public class Motorcycle extends Vehicle
{
    private int horsepower;

    public Motorcycle(String theType, int theYear, double cost, int horsePow)
    {
        super( theType, theYear, cost);
        horsepower = horsePow;
    }

    public String getInfo()
    {
        return super.getInfo() + ", " + horsepower + " horsepower, $" + super.getPrice();
    }
}
