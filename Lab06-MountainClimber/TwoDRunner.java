public class TwoDRunner
{
    public static void main( String[] args)
    {
        //#4
        System.out.println(new TwoDArrayProbs(new int[][] {{1, 2}, {10, 11}}).sum());

        //#5
        System.out.println(new TwoDArrayProbs(new int[][] {{2, 3, 1}, {5, 4, 6}}).isSquare());

        //#6
        new TwoDArrayProbs(new int[][] {{1,2,3}, {3,2,1}}).addMatrix(new int[][] {{2,3,1}, {3,1,2}});

        //#8
        System.out.println();
        System.out.println(new TwoDArrayProbs(new int[][] {{1, 2, 3}, {4, 5, 6}, {6}}).columnSum(2));

        //#9
        System.out.println(new TwoDArrayProbs(new int[][] {{1, 2, 3}, {1}, {2, 2, 1}}).isColumnMagic());

        //#10
        System.out.println(new TwoDArrayProbs(new int[][] {{1, 2, 3}, {3, 2, 1}, {7, 2, 2}}).diagDifference());
        System.out.println(new TwoDArrayProbs(new int[][] {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}).diagDifference());
    }
}
