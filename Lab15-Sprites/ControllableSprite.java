import java.awt.event.KeyEvent;

public class ControllableSprite extends MobileSprite
{
    public ControllableSprite(  double x, double y, int width, int height, String image, double velx, double vely )
    {
        super( x,  y,  width,  height,  image, velx, vely);
    }

    public void step(World world)
    {
        if( StdDraw.isKeyPressed(KeyEvent.VK_UP) )
        {
            setY( getY() + 1);
        }
        if( StdDraw.isKeyPressed(KeyEvent.VK_DOWN) )
        {
            setY( getY() - 1);
        }
        if( StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) )
        {
            setX( getX() + 1);
        }
        if( StdDraw.isKeyPressed(KeyEvent.VK_LEFT) )
        {
            setX( getX() - 1);
        }

    }
}
