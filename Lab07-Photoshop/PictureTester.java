import java.awt.*;

public class PictureTester 
{
    public static void main(String[] args) 
    {
    	//construct a Picture object from a jpg image on disk
        Picture beach = new Picture("beach.jpg");
        
        beach.view(); //calling the view() method displays the picture with the PictureViewer GUI
        
        //PUT YOUR TESTS HERE

		//#4
        beach.zeroBlue();
		beach.view();


		//#5
		beach = new Picture("beach.jpg");
		beach.view();
		beach.keepOnlyBlue();
		beach.view();


		//#6
		Picture koala = new Picture("koala.jpg");
		koala.view();
		koala.negate();
		koala.view();


		//#7
		Picture waterlilies = new Picture("waterlilies.jpg");
		waterlilies.view();
		waterlilies.solarize(127);
		waterlilies.view();


		//#8
		Picture gorge = new Picture("gorge.jpg");
		gorge.view();
		gorge.grayscale();
		gorge.view();


		//#9
		beach = new Picture("beach.jpg");
		beach.view();
		beach.tint( 1.25, 0.75, 1);
		beach.view();


		//#10
		beach = new Picture("beach.jpg");
		beach.view();
		beach.posterize(63);
		beach.view();


		//#12
		Picture redMotorcycle = new Picture("redMotorcycle.jpg");
		redMotorcycle.view();
		redMotorcycle.mirrorRightToLeft();
		redMotorcycle.view();


		//#13
		redMotorcycle = new Picture("redMotorcycle.jpg");
		redMotorcycle.view();
		redMotorcycle.mirrorHorizontal();
		redMotorcycle.view();


		//#14
		waterlilies = new Picture("waterlilies.jpg");
		waterlilies.view();
		waterlilies.verticalFlip();
		waterlilies.view();


		//#15
		Picture temple = new Picture("temple.jpg");
		temple.view();
		temple.fixRoof();
		temple.view();


		//#16
		Picture swan = new Picture("swan.jpg");
		swan.view();
		swan.edgeDetection(25);
		swan.view();

		//#17
		testChromakey();

		//#18
		testSteganography();

		//#19
		koala = new Picture("koala.jpg");
		koala.view();
		(koala.simpleBlur()).view();

		//#20
		waterlilies = new Picture("waterlilies.jpg");
		waterlilies.view();
		(waterlilies.blur(5)).view();


		//#21
		waterlilies = new Picture("waterlilies.jpg");
		(waterlilies.glassFilter(5)).view();
    }
    
    
    
    
    /** this method is static, you don't need to call it on an object (just "testChromekey()") */
	public static void testChromakey()
	{
		Picture one = new Picture("blue-mark.jpg");
		Picture two = new Picture("moon-surface.jpg");
		
		one.view(); //show original mustache guy picture
		two.view(); //show the untouched moon's surface pic
		
		one.chromakey(two, new Color(10, 40, 75), 60); //replace this color if within 60
		
		one.view();
	}
	
    /** this method is static, you don't need to call it on an object (just "testSteganography()") */
	public static void testSteganography()
	{
		Picture msg   = new Picture("msg.jpg");
		Picture beach = new Picture("beach.jpg");
		
		beach.encode(msg); //hide message in beach picture
		beach.view();      //beach w/ hidden message inside, shouldn't look different
		
		beach.decode().view(); //see the hidden message in the beach picture
	}
}
