import java.util.*;

public class TwoDArrayProbs
{
    //#3
    private int [] [] nums;

    public TwoDArrayProbs( int[] [] array)
    {
        nums = array;
    }

    //#4
    public int sum()
    {
        int sum = 0;
        for(int r = 0; r < nums.length; r++)
        {
            for( int c = 0; c < nums[r].length; c++)
            {
                sum += nums[r][c];
            }
        }
        return sum;
    }

    //#5
    public boolean isSquare()
    {
        int rows = nums.length;
        int cols= nums[0].length;
        for( int r =0; r < nums.length; r++)
        {
            if( cols != nums[r].length)
                return false;
        }
        if( rows == cols)
            return true;
        return false;
    }

    //#6
    public void addMatrix( int [] [] other )
    {

        for(int r = 0; r < nums.length; r++)
        {
            for( int c = 0; c < nums[r].length; c++)
            {
                nums[r][c] += other[r][c];
            }
        }

         print();

    }

    private void print()
    {
        for( int r = 0; r < nums.length; r++)
        {
            if( r==0)
                System.out.print( "{" + Arrays.toString(nums[r]) + ", ");
            else if( r + 1 != nums.length)
                System.out.print( Arrays.toString(nums[r]) + ", ");
            else if( r+1 == nums.length)
                System.out.print( Arrays.toString(nums[r]) + "}");
        }
    }

    //#8
    public int columnSum(int col)
    {
        int sum = 0;
        for( int r = 0; r < nums[r].length; r++)
        {
            sum += nums[r][col];
        }

        return sum;
    }

    ///#9
    public boolean isColumnMagic()
    {
        boolean isMagic = true;
        int[] sum = new int[ nums[0].length];
        for( int c = 0; c < nums[0].length; c++)
        {
            for( int r = 0; r < nums.length; r++)
            {
                if( c < nums[r].length )
                    sum[c] += nums[r][c];
            }
        }

        for( int g = 1; g < sum.length; g++)
        {
            if( sum[g] != sum[g-1])
                isMagic = false;
        }
        return isMagic;
    }

    //#10
    public int diagDifference()
    {
        int difference;
        int sumOf1 = 0;
        int sumOf2 = 0;
        for( int square = 0; square < nums.length; square++)
        {
            sumOf1 += nums[square][square];
            sumOf2 += nums[square][ (nums.length-1 )-square];
        }
        difference = Math.abs( sumOf1- sumOf2);
        return difference;
    }
}
