import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Path
{
	private Point[] points;
	private double  minX, minY; //min X and Y values, for setting canvas scale
	private double  maxX, maxY; //maxes
	String si;

	/** construct a path from a given file */
	public Path(String fileName)
	{
		File file = new File("C:\\Users\\georg\\OneDrive\\Desktop\\AP CompSci\\Lab14-GreedyPath\\"+ fileName);
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int size = 0;

		if(scan.hasNext())
		{
			si = scan.next();
			size = Integer.parseInt(si);
			points = new Point[size];
		}

		for( int g = 0; g < points.length; g++)
		{
			String xValue = scan.next();
			String yValue = scan.next();
			Point point = new Point( Double.parseDouble(xValue), Double.parseDouble(yValue));
			points[g] = point;
		}


	}

	public double getMinX()
	{
		minX = Double.MAX_VALUE;

		for( int v = 0; v < points.length; v++)
		{
			if( minX > points[v].getX() )
				minX = points[v].getX();
		}

		return minX;
	}

	public double getMinY()
	{
		minY = Double.MAX_VALUE;

		for( int v = 0; v < points.length; v++)
		{
			if( minY > points[v].getY() )
				minY = points[v].getY();
		}
		return minY;
	}

	public double getMaxX()
	{
		maxX = Double.MIN_VALUE;

		for( int v = 0; v < points.length; v++)
		{
			if( maxX < points[v].getX() )
				maxX = points[v].getX();
		}
		return maxX;
	}

	public double getMaxY()
	{
		maxY = Double.MIN_VALUE;

		for( int v = 0; v < points.length; v++)
		{
			if( maxY < points[v].getY() )
				maxY = points[v].getY();
		}
		return maxY;
	}

    public Point[] getPath()
    {
        return points;
    }
	public Point getPoint( int i)
	{
		return points[i];
	}
	/** returns the distance traveled going point to point, in order given in file */
	public double getDistance()
	{
		double distance = 0;
		for( int y = 0; y < points.length-1; y++)
		{
			distance += points[y].getDistance(points[y+1]);
		}

		return distance;
	}

	public int getNumPoints()
	{
		return points.length;
	}

	@Override
	public String toString()
	{
		String s = "The path has " + points.length + " points.";
		s += "\nThe path has a max X at " + maxX + ", a max Y at " + maxY + ", a min X at " + minX + ", and a min Y at " + minY +".";
		s += "\nIts distance is " + getDistance();

		return s;
	}
}
