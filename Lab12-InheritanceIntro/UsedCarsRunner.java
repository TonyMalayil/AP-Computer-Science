import java.util.*;

public class UsedCarsRunner
{
    public static void main(String[] args)
    {
        Car car1 = new Car( "Toyota Camry", 2000, 20000, 30);
        Car car2 = new Car( "Toyota Sienna", 2020, 30000, 40);
        Truck truck1 = new Truck( "Toyota Tacoma", 2020, 35000, 4000);
        Truck truck2 = new Truck( "Toyota Tundra", 2020, 35000, 5000);
        Motorcycle motorcycle = new Motorcycle( "BMW R 1250 GS", 2021, 17995, 136);

        Inventory store = new Inventory();

        store.addVehicle(car1);
        store.addVehicle(car2);
        store.addVehicle(truck1);
        store.addVehicle(truck2);
        store.addVehicle(motorcycle);

        store.listInventory();

    }
}
