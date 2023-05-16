//#3
public class Team
{
    private Player[] players;

    public Team()
    {
        players = new Player[12];
    }

    public Team (int numPlayers)
    {
        players = new Player[numPlayers];
    }

    public void printTeamStats()
    {
        for( int g = 0; g < players.length; g++)
        {
            System.out.println( players[g].getName() + " \t#" + players[g].getNum() + "\t average: " + players[g].getBattingAverageString());
        }
    }

    public void Stats( int index, String pName, int pNum, int atB, int pHit)
    {
        players[index] = new Player( pName, pNum, atB, pHit);
    }

    public void specificPlayer( int index)
    {
        System.out.println( players[index].getName() + " \t#" + players[index].getNum() + "\t average: " + players[index].getBattingAverageString());
    }

    public int getTeamSize()
    {
        return players.length;
    }

    public void addPlayer( Player p, int index)
    {
        players[index] = p;
    }
}
