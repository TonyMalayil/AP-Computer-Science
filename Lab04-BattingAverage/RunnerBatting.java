//#4
import java.util.*;
import java.io.*;

public class RunnerBatting
{
    public static void main(String[]args)
    {
        File file = new File("C:\\Users\\georg\\OneDrive\\Desktop\\AP CompSci\\Lab04-BattingAverage\\players.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        }
        catch (FileNotFoundException e){}

        int p = input.nextInt();

        Team liberty = new Team(p);
        for( int i = 0; i < p; i++)
        {
            liberty.Stats( i,input.next(), input.nextInt(), input.nextInt(), input.nextInt());
        }
        liberty.printTeamStats();

        liberty.specificPlayer(3);
        System.out.println(liberty.getTeamSize());
        liberty.addPlayer( new Player("Tom", 8 ,344 ,120), 0 );

        input.close();
    }
}
