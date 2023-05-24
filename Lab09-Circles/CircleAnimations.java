import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleAnimations
{
	private ArrayList<Circle> circles; //the circles to animate
	private int               size;    //canvas width and height (will be square)
	private Random            rng;     //use to make random numbers

	/** create a drawing pane of a particular size */
	public CircleAnimations(int s) {
		circles = new ArrayList<>();
		size    = s;
		rng     = new Random();

		//don't mess with this
		StdDraw.setCanvasSize(size, size); //set up drawing canvas
		StdDraw.setXscale(0, size);        //<0, 0> is bottom left.  <size-1, size-1> is top right
		StdDraw.setYscale(0, size);
	}

	//#6
	void drawCircles()
	{
		for( int i = 0; i < circles.size(); i++)
		{
			circles.get(i).draw();
		}
	}

	//#7
	void addCircles()
	{
		for( int i = 0; i < 3; i++)
		{
			Color newC = new Color( rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
			Circle circle = new Circle( rng.nextInt(size), rng.nextInt(size), rng.nextInt(50)+10, newC);
			circles.add( circle);
		}
	}

	//#8
	void addCircles( int number)
	{
		for( int i = 0; i < number; i++)
		{
			Color newC = new Color( rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
			Circle circle = new Circle( rng.nextInt(size), rng.nextInt(size), rng.nextInt(75)+10, newC);
			circles.add( circle);
		}
	}

	//#10
	void noOverlapping()
	{
		int number = rng.nextInt(100000) + 1;
		for( int i = 0; i < number; i++)
		{
			boolean overlap = true;
			Color newC = new Color( rng.nextInt(255), rng.nextInt(255), rng.nextInt(255));
			Circle circle = new Circle( rng.nextInt(size), rng.nextInt(size), rng.nextInt(75)+1, newC);

			for( int g = 0; g < circles.size(); g++)
			{
				if( circle.overlaps( circles.get(g) ) )
				{
					overlap = false;
				}

			}
			if( overlap)
				circles.add(circle);

		}
		drawCircles();
	}

	//#14
	void movingCircles()
	{
		int number = rng.nextInt(10) + 1;
		addCircles(number);

		for (int i = 0; i < circles.size(); i++)
		{
			int xVel = rng.nextInt(5) + 1;
			int yVel = rng.nextInt(5) + 1;

			circles.get(i).setDx(xVel);
			circles.get(i).setDy(yVel);
		}

		while(true)
		{
			drawCircles();
			for (int i = 0; i < circles.size(); i++)
			{
				circles.get(i).update();
			}
			StdDraw.show(10);
			StdDraw.clear();

		}
	}

	//#17
	void removedClicked()
	{
		int number = rng.nextInt(10) + 1;
		addCircles(number);
		drawCircles();
		while(true) {
			if (StdDraw.isMousePressed())
			{

				for (int i = 0; i < circles.size(); i++)
				{


					if ((circles.get(i).getX() - circles.get(i).getRadius() < StdDraw.mouseX()) && (circles.get(i).getX() + circles.get(i).getRadius() > StdDraw.mouseX()))
					{
						if ((circles.get(i).getY() - circles.get(i).getRadius() < StdDraw.mouseY()) && (circles.get(i).getY() + circles.get(i).getRadius() > StdDraw.mouseY()))
						{
							circles.remove(i);
							i--;

						}
					}

					drawCircles();
					StdDraw.show(10);
					StdDraw.clear();
				}

			}
		}

	}

}
