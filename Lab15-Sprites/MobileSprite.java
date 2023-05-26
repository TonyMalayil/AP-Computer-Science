public class MobileSprite extends Sprite
{
    private double vx;
    private double vy;

    public MobileSprite( double x, double y, int width, int height, String image, double velx, double vely)
    {
        super( x,  y,  width,  height,  image);
        vx = velx;
        vy = vely;
    }

    public double getVx()
    {
        return vx;
    }

    public double getVy()
    {
        return vy;
    }

    public void setVx( double dx )
    {
        vx = dx;
    }

    public void setVy( double dy)
    {
        vy = dy;
    }

    public void step(World world)
    {
        setX(getX() + vx);
        setY(getY() + vy);
    }

}
