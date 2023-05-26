public class Point 
{
	private double  x, y;
	private boolean visited = false;

	public Point( double X, double Y)
	{
		x =X;
		y = Y;
	}

	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public boolean getVisited()
	{
		return visited;
	}

	public void visited( boolean t)
	{
		visited = t;
	}

	/** get the Euclidean distance between two points */
	public double getDistance(Point other)
	{
		double distance = Math.sqrt( Math.pow( (other.getX()- x ), 2) + Math.pow( (other.getY()- y ), 2));
		
		return distance;
	}
	
	@Override
	public String toString()
	{
		String rep = " This point is at (" + x + ", " + y + ")";
		if( visited)
			rep += " and has been visited";
		else
			rep += " and has not been visited";
		
		return rep;
	}
}
