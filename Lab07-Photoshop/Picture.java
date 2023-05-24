import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture {

    /** The 2D array of pixels that comprise this picture */
	private Pixel[][] pixels;

    /**
     * Creates a Picture from an image file in the "images" directory
     * @param picture The name of the file to load
     */
    public Picture(String picture) {
        File file = new File(".\\images\\"+picture);
        BufferedImage image;
        if (!file.exists()) throw new RuntimeException("No picture at the location "+file.getPath()+"!");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        pixels = new Pixel[image.getHeight()][image.getWidth()];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                int rgb = image.getRGB(x, y);
                /*
                 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal integer
                 * The below extracts the individual values using bit-shifting and bit-wise ANDing with all 1's
                 */
                pixels[y][x] = new Pixel((rgb>>16)&0xff, (rgb>>8)&0xff, rgb&0xff);
            }
        }
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param red The red value of the color
     * @param green The green value of the color
     * @param blue The blue value of the color
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int red, int green, int blue, int height, int width) {
        pixels = new Pixel[height][width];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }
    }

    /**
     * Creates a solid white Picture of a given width and height
     //* @param color The {@link Color} of the Picture
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int height, int width) {
        this(Color.WHITE, height, width);
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param color The {@link Color} of the Picture
     * @param width The width of the Picture
     * @param height The height of the Picture
     */
    public Picture(Color color, int height, int width) {
        this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
    }

    /**
     * Creates a Picture based off of an existing {@link Pixel} 2D array
     * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
     */
    public Picture(Pixel[][] pixels) {
        if (pixels.length==0 || pixels[0].length==0) throw new RuntimeException("Can't have an empty image!");
        int width = pixels[0].length;
        for (int i = 0; i<pixels.length; i++) if (pixels[i].length!=width)
            throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels["+i+"].length!");
        this.pixels = new Pixel[pixels.length][width];
        for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
            }
        }
    }

    /**
     * Creates a Picture based off of an existing Picture
     * @param picture The Picture to copy
     */
    public Picture(Picture picture) {
        this(picture.pixels);
    }

    /**
     * Gets the width of the Picture
     * @return The width of the Picture
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the Picture
     * @return The height of the Picture
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @return The {@link Pixel} at the given location
     */
    public Pixel getPixel(int x, int y) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        return pixels[y][x];
    }

    /**
     * Sets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @param pixel The new {@link Pixel}
     */
    public void setPixel(int x, int y, Pixel pixel) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        if (pixel==null) throw new NullPointerException("Pixel is null"); //guard is required because pixel's value isn't used in this method
        pixels[y][x] = pixel;
    }

    /**
     * Opens a {@link PictureViewer} to view this Picture
     * @return the {@link PictureViewer} viewing the Picture
     */
    public PictureViewer view() {
        return new PictureViewer(this);
    }

	/**
	 * Save the image on disk as a JPEG
	 * Call programmatically on a Picture object, it will prompt you to choose a save location
	 * In the save dialogue window, specify the file AND extension (e.g. "lilies.jpg")
	 * Extension must be .jpg as ImageIO is expecting to write a jpeg
	 */
	public void save()
	{
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
		catch(Exception e) {
	        e.printStackTrace();
	    }
		
		BufferedImage image = new BufferedImage(this.pixels[0].length, this.pixels.length, BufferedImage.TYPE_INT_RGB);

		for (int r = 0; r < this.pixels.length; r++)
			for (int c = 0; c < this.pixels[0].length; c++)
				image.setRGB(c, r, this.pixels[r][c].getColor().getRGB());

		//user's Desktop will be default directory location
		JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");

		chooser.setDialogTitle("Select picture save location / file name");

		File file = null;

		int choice = chooser.showSaveDialog(null);

		if (choice == JFileChooser.APPROVE_OPTION)
			file = chooser.getSelectedFile();

		//append extension if user didn't read save instructions
		if (!file.getName().endsWith(".jpg") && !file.getName().endsWith(".JPG") && !file.getName().endsWith(".jpeg") && !file.getName().endsWith(".JPEG"))
			file = new File(file.getAbsolutePath() + ".jpg");
		
		try {
			ImageIO.write(image, "jpg", file);
			System.out.println("File created at " + file.getAbsolutePath());
		}
		catch (IOException e) {
			System.out.println("Can't write to location: " + file.toString());
		}
		catch (NullPointerException|IllegalArgumentException e) {
			System.out.println("Invalid directory choice");
		}
	}
	
	/** return a copy of the reference to the 2D array of pixels that comprise this picture */
	public Pixel[][] getPixels() {
		return pixels;
	}


    /********************************************************
     *************** STUDENT METHODS BELOW ******************
     ********************************************************/

    /** remove all blue tint from a picture */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels();
        for( Pixel[] row : pixels)
        {
            for( Pixel pixel : row)
            {
                pixel.setBlue(0);
            }
        }

    }

    /** remove everything BUT blue tint from a picture */
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels();
        for( Pixel[] row : pixels)
        {
            for( Pixel pixel : row)
            {
                pixel.setRed(0);
                pixel.setGreen(0);
            }
        }
    }

    /** invert a picture's colors */
    public void negate()
    {
        Pixel[][] pixels = this.getPixels();
        for( Pixel[] row : pixels)
        {
            for( Pixel pixel : row)
            {
                pixel.setRed(  255 - pixel.getRed() );
                pixel.setGreen( 255 - pixel.getGreen() );
                pixel.setBlue( 255 - pixel.getBlue() );
            }
        }
    }

    /** simulate the over-exposure of a picture in film processing */
    public void solarize(int threshold)
    {
        Pixel[][] pixels = this.getPixels();
        for( Pixel[] row : pixels)
        {
            for( Pixel pixel : row)
            {
                if( pixel.getRed() < threshold)
                    pixel.setRed(  255 - pixel.getRed() );
                if( pixel.getGreen() < threshold)
                    pixel.setGreen( 255 - pixel.getGreen() );
                if( pixel.getBlue() < threshold)
                    pixel.setBlue( 255 - pixel.getBlue() );
            }
        }
    }

    /** convert an image to grayscale */
    public void grayscale()
    {
        Pixel[][] pixels = this.getPixels();
        for( Pixel[] row : pixels)
        {
            for( Pixel pixel : row)
            {
                int average = ( pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
                pixel.setRed(  average );
                pixel.setGreen( average );
                pixel.setBlue( average );
            }
        }
    }

	/** change the tint of the picture by the supplied coefficients */
	public void tint(double red, double blue, double green)
	{
        Pixel[][] pixels = this.getPixels();
        for( Pixel[] row : pixels)
        {
            for( Pixel pixel : row)
            {
                int colorRed = (int)(pixel.getRed() * red );
                if ( colorRed > 255)
                    colorRed = 255;
                int colorGreen = (int)(pixel.getGreen() * green );
                if ( colorGreen > 255)
                    colorGreen = 255;
                int colorBlue = (int)(pixel.getBlue() * blue );
                if ( colorBlue > 255)
                    colorBlue = 255;

                pixel.setRed( colorRed );
                pixel.setGreen( colorGreen );
                pixel.setBlue( colorBlue );
            }
        }
	}
	
	/** reduces the number of colors in an image to create a "graphic poster" effect */
	public void posterize(int span)
	{
        Pixel[][] pixels = this.getPixels();
        for( Pixel[] row : pixels)
        {
            for( Pixel pixel : row)
            {
                pixel.setRed(  pixel.getRed() /span * span  );
                pixel.setGreen( pixel.getGreen() /span * span );
                pixel.setBlue( pixel.getBlue() /span * span );
            }
        }
	}

    /** mirror an image about a vertical midline, left to right */
    public void mirrorVertical()
    {
		Pixel leftPixel  = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int r = 0; r < pixels.length; r++)
		{
			for (int c = 0; c < width / 2; c++)
			{
				leftPixel  = pixels[r][c];
				rightPixel = pixels[r][(width - 1) - c];

				rightPixel.setColor(leftPixel.getColor());
			}
		}
    }

    /** mirror about a vertical midline, right to left */
    public void mirrorRightToLeft()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = width/2; c < width; c++)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** mirror about a horizontal midline, top to bottom */
    public void mirrorHorizontal()
    {
        Pixel topPixel  = null;
        Pixel bottomPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length/2 ; r++)
        {
            for (int c = 0; c < width; c++)
            {
                topPixel  = pixels[r][c];
                bottomPixel = pixels[ (pixels.length -1 ) - r][c];

                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /** flip an image upside down about its bottom edge */
    public void verticalFlip()
    {
        Pixel topPixel  = null;
        Pixel bottomPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length/2 ; r++)
        {
            for (int c = 0; c < width; c++)
            {
                topPixel  = pixels[r][c];
                bottomPixel = pixels[ (pixels.length -1 ) - r][c];

                Color temp = bottomPixel.getColor();
                bottomPixel.setColor(topPixel.getColor());
                topPixel.setColor(temp);
            }
        }
    }

    /** fix roof on greek temple */
    public void fixRoof()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < 100; r++)
        {
            for (int c = 0; c < width/2; c++)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** detect and mark edges in an image */
    public void edgeDetection(int dist)
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;
        Pixel bottomPixel = null;
        Color temp = null;
        Color verticalTemp = null;

        Pixel[][] pixels = this.getPixels();
        int width = pixels[0].length;
        for (int r = 0; r < pixels.length-1; r++)
        {
            for (int c = 0; c < width-1; c++)
            {
                leftPixel = pixels[r][c];
                rightPixel = pixels[r][c+1];
                bottomPixel = pixels[r+1][c];
                temp = rightPixel.getColor();
                verticalTemp = bottomPixel.getColor();

                if( (leftPixel.colorDistance(temp) > dist) || (leftPixel.colorDistance(verticalTemp) > dist) )
                    leftPixel.setColor(0,0,0);
                else
                    leftPixel.setColor(255,255,255);
            }
        }
    }


	/** copy another picture's pixels into this picture, if a color is within dist of param Color */
	public void chromakey(Picture other, Color color, int dist)
	{
        Pixel[][] otherPixels = other.getPixels();

		for( int r = 0; r < pixels.length; r++)
        {
            for( int c = 0; c < pixels[0].length; c++)
            {
                if( pixels[r][c].colorDistance(color) < dist)
                {
                    pixels[r][c].setColor(otherPixels[r][c].getColor());
                }
            }
        }
	}

	/** steganography encode (hide the message in msg in this picture) */
	public void encode(Picture msg)
	{
	    Pixel[][] msgPixels = msg.getPixels();

        for( int r = 0; r < pixels.length; r++)
        {
            for( int c = 0; c < pixels[0].length; c++)
            {
                if( pixels[r][c].getRed() % 2 == 1)
                {
                    pixels[r][c].setRed( pixels[r][c].getRed() -1 );
                }
            }
        }

        for( int r = 0; r < pixels.length; r++)
        {
            for( int c = 0; c < pixels[0].length; c++)
            {
                if( msgPixels[r][c].colorDistance( Color.BLACK ) < 50)
                {
                    pixels[r][c].setRed( pixels[r][c].getRed() + 1 );
                }
            }
        }
	}

	/** steganography decode (return a new Picture containing the message hidden in this picture) */
	public Picture decode()
	{
	    Picture decodedMessage = new Picture(pixels.length, pixels[0].length);
	    Pixel[][] message = new Pixel[pixels.length][pixels[0].length];

        for( int r = 0; r < pixels.length; r++)
        {
            for( int c = 0; c < pixels[0].length; c++)
            {
                message[r][c] = new Pixel( Color.WHITE );
            }
        }

        for( int r = 0; r < pixels.length; r++)
        {
            for( int c = 0; c < pixels[0].length; c++)
            {
                if( pixels[r][c].getRed() % 2 == 1)
                {
                    message[r][c].setColor( Color.BLACK );
                }
            }
        }
        decodedMessage = new Picture(message);

		return decodedMessage;
	}

	/** perform a simple blur using the colors of neighboring pixels */
	public Picture simpleBlur()
	{
        Pixel[][] pixels = this.getPixels();
        Pixel leftPixel  = null;
        Pixel rightPixel = null;
        Pixel bottomPixel = null;
        Pixel topPixel = null;

        for (int r = 1; r < pixels.length-1; r++)
        {
            for (int c = 1; c < pixels[0].length-1; c++)
            {
                leftPixel = pixels[r][c-1];
                rightPixel = pixels[r][c+1];
                bottomPixel = pixels[r+1][c];
                topPixel = pixels[r+1][c];

                int avgRed = (leftPixel.getRed() + rightPixel.getRed() + bottomPixel.getRed() + topPixel.getRed() + pixels[r][c].getRed() ) / 5;
                int avgGreen = (leftPixel.getGreen() + rightPixel.getGreen() + bottomPixel.getGreen() + topPixel.getGreen() + pixels[r][c].getGreen() ) / 5;
                int avgBlue = (leftPixel.getBlue() + rightPixel.getBlue() + bottomPixel.getBlue() + topPixel.getBlue() + pixels[r][c].getBlue() ) / 5;

                pixels[r][c].setColor( avgRed, avgGreen, avgBlue);
            }
        }
        Picture blurred = new Picture( pixels );
		return blurred;
	}

	/** perform a blur using the colors of pixels within radius of current pixel */
	public Picture blur(int radius)
	{
        Pixel[][] newPixels = this.getPixels();

        for (int r = radius; r < pixels.length- radius; r++)
        {
            for (int c = radius; c < pixels[0].length - radius; c++)
            {
                int cells = 0;
                int avgRed = 0, avgGreen = 0, avgBlue = 0;
                for (int row = r - radius; row <= r + radius; row++)
                {
                    for (int column = c - radius; column <= c + radius; column++)
                    {
                        avgRed = avgRed + pixels[row][column].getRed();
                        avgGreen += pixels[row][column].getGreen();
                        avgBlue += pixels[row][column].getBlue();
                        cells++;
                    }
                }
                avgGreen /= cells;
                avgRed /= cells;
                avgBlue /= cells;
                pixels[r][c].setColor(avgRed, avgGreen, avgBlue);
            }
        }

        Picture blurredPic = new Picture(newPixels);
		return blurredPic;
	}

	/**
	 * Simulate looking at an image through a pane of glass
	 * @param dist the "radius" of the neighboring pixels to use
	 * @return a new Picture with the glass filter applied
	 */
	public Picture glassFilter(int dist) 
	{
        Pixel[][] pixels = this.getPixels();
        Random random = new Random();

        for (int r = 0; r < pixels.length- dist; r += dist)
        {
            for (int c = 0; c < pixels[0].length - dist; c += dist)
            {
                for( int row = r; row < r + dist; row++)
                {
                    for( int column = c; column < c + dist; column++)
                    {
                        int xNum = random.nextInt( dist);
                        int yNum = random.nextInt( dist);
                        if( (r + xNum < pixels.length) && ( c + yNum < pixels[0].length))
                            pixels[row][column].setColor( this.pixels[row + xNum][column + yNum].getColor() );
                    }
                }

            }
        }

        Picture glass = new Picture(pixels);
		return glass;
	}
}
