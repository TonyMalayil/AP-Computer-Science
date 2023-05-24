import java.util.*;

public class CombinationLock extends Lock
{
    private String combination;

    void open()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the combination");
        String theCombo = scan.next();

        if( combination.equals(theCombo))
        {
            super.open();
        }
    }

    public String toString()
    {
        return super.toString() + "\n" + "Combination = " + combination + "\n";
    }

    void setCombination(String newCombo)
    {
        combination = newCombo;
    }

    public String getCombination()
    {
        return combination;
    }

    public CombinationLock()
    {
        super();
        combination = "";
    }

    public CombinationLock(String combo)
    {
        super();
        combination = combo;
    }
}
