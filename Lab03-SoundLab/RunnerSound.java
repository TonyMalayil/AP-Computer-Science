import java.util.*;

public class RunnerSound
{

    public static void main(String[] args)
    {
        SoundLabProbs test = new SoundLabProbs();

        //#3
        System.out.println( test.lastIndexOf(new int[] {8, 2, 4, 6, 8}, 8));
        System.out.println( test.lastIndexOf(new int[] {2, 4, 6, 12},   8) );

        //#5
        System.out.println( test.range(new int[] {8, 3, 5, 7, 2, 4}));
        System.out.println( test.range(new int[] {15, 22, 8, 19, 31}));

        //#6
        System.out.println( test.minDifference(new int[] {4, 8, 6, 1, 5, 9, 4}) );

        //#7
        System.out.println(test.reverseWords("hello world"));
        System.out.println(test.reverseWords("the sky is blue") );

        //#8
        System.out.println(test.priceIsRight(new int[] {900, 885, 990, 1}, 800) );
        System.out.println(test.priceIsRight(new int[] {1500, 1600, 2000, 2500}, 1900));

        //#9
        System.out.println( Arrays.toString(test.productExceptSelf(new int[] {1, 2, 3, 4})) );

        //#Sound Lab
        //double[] clip = {0.5, 1, 0, -1};
        //Sound.show(clip);
        //Sound.play(clip);
        double[] clip = Sound.pureTone(3.0, 1.0);
        Sound.show(clip);

    }
}
