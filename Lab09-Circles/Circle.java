import java.awt.*;
import java.util.Random;

public class Circle
{
    private int x;
    private int y;
    private int radius;
    private Color color;
    private int dx;
    private int dy;

    public static void main( String[] args)
    {
        //#4
        new Circle(0, 0, 1, new Color(255, 0, 0)).draw();
    }

    //#3
    public Circle( int xpos, int ypos, int rad, Color color1)
    {
        x = xpos;
        y = ypos;
        radius = rad;
        color = color1;
    }

    //#4
    void draw()
    {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, radius);
    }

    //#9
    public boolean overlaps( Circle other)
    {
        boolean overlapping = false;

        double distance = Math.sqrt( Math.pow( other.x - this.x, 2) + Math.pow( other.y - this.y, 2) );
        if( distance < (other.radius + this.radius) )
        {
            overlapping = true;
        }

        return overlapping;
    }

    //#12
    public Circle(int xpos, int ypos, int rad, Color color1, int xVel, int yVel )
    {
        x = xpos;
        y = ypos;
        radius = rad;
        color = color1;
        dx = xVel;
        dy = yVel;
    }

    //#13
    void update()
    {
        x += dx;
        y += dy;
        bounce();
    }

    //#15
    void bounce()
    {
        Random rng = new Random();
        if( (this.getX() > getRadius()))
        {
            int newDx = rng.nextInt(6) - 6;
            this.setDx(newDx);
        }
        if( (this.getX() < getRadius()) )
        {
            int newDx = rng.nextInt(5) + 1;
            this.setDx(newDx);
        }

        if( (this.getY() > getRadius()t))
        {
            int newDy = rng.nextInt(6) - 6;
            this.setDy(newDy);
        }
        if( (this.getY() < getRadius()) )
        {
            int newDy = rng.nextInt(5) + 1;
            this.setDy(newDy);
        }
    }

    void setDx( int xVel)
    {
        dx = xVel;
    }
    void setDy( int yVel)
    {
        dy = yVel;
    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getRadius(){return radius;}
}
