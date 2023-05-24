public class Tombstone
{
    private String name;
    private String burialDate;
    private int age;
    private String address;

    public Tombstone( String Name, String date, int Age, String add)
    {
        name = Name;
        burialDate = date;
        age = Age;
        address = add;
    }

    public String getName()
    {
        return name;
    }

    public String getBurialDate()
    {
        return burialDate;
    }

    public String getAddress()
    {
        return address;
    }

    public int getAge()
    {
        return age;
    }
}
