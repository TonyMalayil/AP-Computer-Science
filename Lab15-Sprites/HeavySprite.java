public class HeavySprite extends BouncingSprite
{
    public HeavySprite(double x, double y, int width, int height, String image, double velx, double vely)
    {
        super( x,  y,  width,  height,  image, velx, vely);
    }

    public void step( World world )
    {
        super.step(world);
        setY( getY() - 0.1 );
    }

}
