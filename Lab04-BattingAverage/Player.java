//#1
public class Player
{
    private String name;
    private int number;
    private int atBats = 0;
    private int hits = 0;

    public Player( String pName, int pNum)
    {
        name = pName;
        number = pNum;
    }

    public Player ( String pName, int pNum, int atB, int pHit)
    {
        name = pName;
        number = pNum;
        atBats = atB;
        hits = pHit;
    }

    public String getName()
    {
        return name;
    }

    public int getNum()
    {
        return number;
    }

    public double getBattingAverage()
    {
        double avg = (double) hits / atBats;
        return avg;
    }

    public String getBattingAverageString()
    {
        String avgString = "" + Math.round( getBattingAverage() * 1000);
        return avgString;
    }
}
