import java.util.*;
import java.io.*;
public class Cemetery
{
    private ArrayList<Tombstone> cemetery;

    public Cemetery( String fileName)
    {


        Scanner scan = null;
        File file = new File(( "C:\\Users\\georg\\OneDrive\\Desktop\\AP CompSci\\Lab08-Cemetery\\TXT\\"+ fileName) );

        try {
            scan = new Scanner( file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        cemetery = new ArrayList<Tombstone>(Arrays.asList());


        while( scan.hasNextLine())
        {
            String name = "", address = "", burialDate = "", theAge = null;
            int age = 0;
            String line = scan.nextLine();
            Scanner parse = new Scanner( line );
            char c = 'n';
            while( !Character.isUpperCase(c) )
            {
                name += parse.next() + " ";
                c = name.charAt( name.length()-2 );
            }
            burialDate = parse.next() + " ";
            burialDate += parse.next() + " ";
            burialDate += parse.next();
            theAge = parse.next();
            age = parseAge(theAge);
            address = parse.nextLine();

            Tombstone n = new Tombstone( name, burialDate, age, address);
            cemetery.add(n);
        }



    }

    /**
     * convert the ageString to a number of days; age can
     * take a variety of forms in the data file
     */
    public static int parseAge(String ageString)
    {
        if (ageString.contains("d")) { //age supplied in days
            ageString = ageString.replaceAll("d", "");
            return Integer.parseInt(ageString);
        }

        int result = 0;

        boolean done = true;

        try { result = Integer.parseInt(ageString); } //is the String a whole number of years?

        catch (NumberFormatException n) { done = false; }

        if (done) //successfully parsed as an int, return value
            return 365 * result; //ignoring leap years

        double ageDouble = 0;

        done = true;

        try { ageDouble = Double.parseDouble(ageString); } //is the String a floating point number of years?

        catch (NumberFormatException n) { done = false; }

        if (done) { //successfully parse as a double, String doesn't contain any text
            return (int)(ageDouble * 365); //ignoring leap years, using 30 for days in a month
        }

        if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
            ageString = ageString.replaceAll("w", "");
            return Integer.parseInt(ageString) * 7;
        }

        return 0;
    }

    public int getAge( int index)
    {
        return cemetery.get(index).getAge();
    }
    public String getName( int index)
    {
        return cemetery.get(index).getName();
    }
    public String getAddress( int index)
    {
        return cemetery.get(index).getAddress();
    }
    public String getDate( int index)
    {
        return cemetery.get(index).getBurialDate();
    }
    public int getSize()
    {
        return cemetery.size();
    }
}
