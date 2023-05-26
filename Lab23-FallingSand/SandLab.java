import java.awt.*;
import java.util.*;

public class SandLab
{
	//add constants for particle types here
	public static final int EMPTY = 0;
	public static final int METAL = 1;
	public static final int SAND = 2;
	public static final int WATER = 3;



	//do not add any more fields!
	private int[][] grid;
	private SandDisplay display; //SandDisplay is the GUI class

	public SandLab(int numRows, int numCols)
	{
		String[] names = new String[4];

		names[EMPTY] = "Empty";
		names[METAL] = "Metal";
		names[SAND] = "Sand";
		names[WATER] = "Water";

		grid = new int[numRows][numCols];
		display = new SandDisplay("Falling Sand", numRows, numCols, names);
	}

	/** called when the user clicks on a location using the given tool */
	private void locationClicked(int row, int col, int tool)
	{
		grid[row][col] = tool;
	}

	/** copies each element of grid into the display */
	public void updateDisplay()
	{
		for( int r = 0; r < grid.length; r++)
		{
			for( int c = 0; c < grid[0].length; c++)
			{
				Color color = Color.BLACK;

				if( grid[r][c] == METAL)
					color = Color.DARK_GRAY;
				if( grid[r][c] == SAND)
					color = new Color(194, 178, 128);
				if( grid[r][c] == WATER)
					color = Color.BLUE;

				display.setColor( r, c, color);
			}
		}
	}

	/** called repeatedly, causes one random particle to maybe do something */
	public void step()
	{
		Random rng = new Random();
		int row = rng.nextInt(grid.length);
		int col = rng.nextInt(grid[0].length);


		if( (grid[row][col] == SAND) && ( row+1 < grid.length) && ( (grid[row+1][col] == EMPTY) || (grid[row+1][col] == WATER)) )
		{
			int temp = grid[row][col];
			grid[row][col] = grid[row+1][col];
			grid[row+1][col] = temp;
		}

		if( (grid[row][col] == WATER) )
		{
			int temp = grid[row][col];
			int r = row; int c = col;

			if(( row+1 < grid.length) && (grid[row+1][col] == EMPTY) )
			{
				r = row+1;

			}

			if( (( col+1 < grid[0].length) && (grid[r][col+1] == EMPTY)) && ( col-1 > 0) && (grid[r][col-1] == EMPTY) )
			{
				int direction = rng.nextInt(3);
				if( direction == 0)
				{
					c = col;
				}
				if( direction == 1)
				{
					c = col-1;
				}
				if( direction == 2)
				{
					c = col+1;
				}
			}
			else if( ( col+1 < grid[0].length) && (grid[r][col+1] == EMPTY) )
			{
				int direction = rng.nextInt(2);
				if( direction == 0)
				{
					c = col;
				}
				if( direction == 1)
				{
					c = col+1;
				}
			}
			else if( ( col-1 > 0) && (grid[r][col-1] == EMPTY) )
			{
				int direction = rng.nextInt(2);
				if( direction == 0)
				{
					c = col;
				}
				if( direction == 1)
				{
					c = col-1;
				}
			}

			grid[row][col] = EMPTY;
			grid[r][c] = temp;
		}
	}

	//do not modify!
	public void run()
	{
		while (true)
		{
			for (int i = 0; i < display.getSpeed(); i++)
				step();

			updateDisplay();

			display.repaint();

			display.pause(1);  //wait for redrawing and for mouse

			int[] mouseLoc = display.getMouseLocation();

			if (mouseLoc != null)  //test if mouse clicked
				locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
		}
	}
}
