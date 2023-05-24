import java.awt.*;

public class CircleRunner {
	public static void main(String[] args) {
		CircleAnimations app = new CircleAnimations(600); //supply window size, will be 600x600

		//test your methods below (with the app object)

		//#7
		app.addCircles();
		app.drawCircles();


		//#8
		app = new CircleAnimations(600);
		app.addCircles(7);
		app.drawCircles();

		//#9
		testCircleOverlap(); //uncomment to test your overlap method, when required

		//#10
		app = new CircleAnimations(600);
		app.noOverlapping();

		//#14
		app = new CircleAnimations(600);
		//app.movingCircles();

		//#17
		app = new CircleAnimations( 600 );
		app.removedClicked();


	}

	public static void testCircleOverlap() { //uncomment contents to use
		/*
		 * The distance between a and b is ~2.83, which is greater than the combined radius of 2 (a and b do NOT overlap)
		 *
		 * The distance between a and c is ~2.83, which is less    than the combined radius of 6 (a and c overlap)
		 */
		Circle a = new Circle(1, 1, 1, null); //color is irrelevant for this
		Circle b = new Circle(3, 3, 1, null);
		Circle c = new Circle(3, 3, 5, null);

		System.out.println(a.overlaps(b)); //should print false
		System.out.println(a.overlaps(c)); //should print true
	}
}
