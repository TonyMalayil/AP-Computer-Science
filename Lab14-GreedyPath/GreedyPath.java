import java.util.*;
public class GreedyPath extends Path
{
    private Point[] Points;
    private Point[] newPath;
    private double newDistance;
    public GreedyPath( String name )
    {
        super( name );
        Points = getPath();
        newPath = new Point[Points.length];
        findPath();
    }

    public double getDistance()
    {
        newDistance = 0;
        for( int y = 0; y < newPath.length-1; y++)
        {
            newDistance += newPath[y].getDistance(newPath[y+1]);
        }
        return newDistance;
    }

    public void findPath()
    {
        newPath[0] = Points[0];
        newPath[0].visited(true);

        for( int i = 0; i < newPath.length-1; i++)
        {
            double space = Double.MAX_VALUE;

            int position = 0;
            for( int w = newPath.length-1; w > 0; w--)
            {
                if( !Points[w].getVisited() )
                {
                    if( space >= newPath[i].getDistance(Points[w]) )
                    {
                        space = newPath[i].getDistance(Points[w]);
                        position = w;
                    }
                }
            }
            Points[position].visited(true);
            newPath[i+1] = Points[position];
        }


    }

    public Point getPoint(int i)
    {
        return newPath[i];
    }

    public String toString()
    {
        String s = "The path has " + newPath.length + " points.";
        s += "\nThe path has a max X at " + getMaxX() + ", a max Y at " + getMaxY() + ", a min X at " + getMinX() + ", and a min Y at " + getMinY() +".";
        s += "\nIts distance is " + getDistance();

        return s;
    }
}
