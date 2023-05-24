import java.util.*;

public class Inventory
{
    private ArrayList<Vehicle> inventory;


    public Inventory()
    {
        inventory = new ArrayList<Vehicle>();
    }

    void addVehicle(Vehicle v)
    {
        inventory.add(v);
    }

    void listInventory()
    {
        for( int i = 0; i < inventory.size(); i++)
        {
            System.out.println(inventory.get(i).getInfo());
        }

    }
}
