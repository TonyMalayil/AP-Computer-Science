import java.util.*;

public class HorsingAround
{
    public static int totalWidth(ArrayList<Animal> animals)
    {
        int sum = 0;

        for( Animal a : animals )
        {
            sum+= a.getWidth();
        }

        return sum;
    }

    public static Animal tallestAnimal(ArrayList<Animal> animals)
    {
        int s = animals.get(0).getHeight();
        int index = 0;

        for( int i = 0; i < animals.size(); i++)
        {
            if( animals.get(i).getHeight() > s)
            {
                index = i;
            }
        }

        return animals.get(index);
    }

    public static int countYourChickens(ArrayList<Animal> animals)
    {
        int num = 0;
        for( Animal a : animals)
        {
            if( a.getName().equals("chicken"))
            {
                num++;
            }
        }

        return num;
    }

    public static ArrayList<String> inventory(ArrayList<Animal> animals)
    {
        ArrayList<String> names = new ArrayList<>();

        for( Animal a : animals)
        {
            names.add(a.getName());
        }

        return names;
    }

    public static void pestControl(ArrayList<Animal> animals)
    {
    	for( int i = 0; i < animals.size(); i++)
        {
            if( animals.get(i).getName().equals("mouse") )
            {
                animals.remove(i);
                i--;
            }
        }
    }

    public static void horsingAround(ArrayList<Animal> animals)
    {
        Animal horse = new Animal("horse");
        animals.add(0, horse);
        for( int i = 2; i < animals.size(); i+=2)
        {
            animals.add(i, horse);
        }
        animals.add( horse);
    }

    public static void feelingSheepish(ArrayList<Animal> animals)
    {
        ArrayList<Animal> temp = new ArrayList<>();

        for( int i = 0; i < animals.size(); i++)
        {
            temp.add(animals.get(i));
        }
        Animal sheep = new Animal("sheep");

    	for( int i = 0; i < animals.size(); i++)
        {
            if( temp.get(i).getName().equals("sheep"))
            {
                if( i+1 < animals.size())
                    animals.set(i+1, sheep);
                if( i-1 >= 0)
                    animals.set( i-1, sheep);
            }
        }
    }

    public static void selectionSort(ArrayList<Animal> animals)
    {
        System.out.println(animals.get(0).getHeight());
        for( int i = 0; i < animals.size(); i++)
        {
            int min = animals.get(i).getHeight();
            int minIndex = i;

            for( int t = i+1; t < animals.size(); t++)
            {

                if( min > animals.get(t).getHeight())
                {
                    min = animals.get(t).getHeight();
                    minIndex = t;
                }

            }

            Animal temp = animals.get(minIndex);
            animals.set(minIndex , animals.get(i));
            animals.set( i, temp);
        }
    }

}