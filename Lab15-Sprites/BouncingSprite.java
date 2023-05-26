import java.util.*;

public class BouncingSprite extends MobileSprite
{
    private int ymax;
    private int xmax;

    public BouncingSprite( double x, double y, int width, int height, String image, double velx, double vely)
    {
        super( x,  y,  width,  height,  image, velx, vely);
    }

    public void bounce()
    {
        Random rng = new Random();
        if( (getX() > getXmax() ))
        {
            double newDx = rng.nextInt(6) - 6;
            setVx(newDx);
        }
        if( (getX() < 0 ) )
        {
            double newDx = rng.nextInt(5) + 1;
            setVx(newDx);
        }

        if( (getY() > getYmax() ))
        {
            double newDy = rng.nextInt(6) - 6;
            setVy(newDy);
        }
        if( ( getY() < 0  ) )
        {
            double newDy = rng.nextInt(5) + 1;
            setVy(newDy);
        }
    }

    public void step( World world )
    {
        super.step(world);
        setMax( world );
        bounce();
    }

    public void setMax( World world )
    {
        ymax = world.getHeight();
        xmax = world.getWidth();
    }

    public int getYmax()
    {
        return ymax;
    }

    public int getXmax()
    {
        return xmax;
    }

}
