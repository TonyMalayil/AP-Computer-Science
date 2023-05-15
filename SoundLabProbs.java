public class SoundLabProbs
{
    //#2
    public SoundLabProbs()
    {

    }

    //#3
    public int lastIndexOf( int[] nums, int value)
    {
        int index = -1;
        for( int y =0; y < nums.length; y++)
        {
            if( nums[y] == value)
                index = y;
        }
        return index;
    }

    //#5
    public int range(int[] nums)
    {
        int min = nums[0];
        int max = nums[0];
        for( int q = 0; q < nums.length; q++)
        {
            if( nums[q] > max)
                max = nums[q];
            if( nums[q] < min)
                min = nums[q];
        }
        return max - min;
    }

    //#6
    public int minDifference(int[] nums)
    {
        int minDiff = Math.abs(nums[1] - nums[0]);
        int diff = -1;
        for( int u = 0; u < nums.length -1; u++)
        {
            diff = Math.abs(nums[u+1] - nums[u]);
            if( diff < minDiff)
                minDiff = diff;
        }
        return minDiff;
    }

    //#7
    public String reverseWords(String str)
    {
        String answer = "";
        String sentence= str;
        String[] words = sentence.split(" ");
        for( String word : words)
        {
            answer = word + " " +answer ;
        }
        return answer;
    }

    //#8
    public int priceIsRight(int[] bids, int price)
    {
        int close = price;
        int right = 0;
        for( int g = 0; g < bids.length; g++)
        {
            if (bids[g] < price )
            {
                if( close > (price - bids[g]) )
                {
                    close = price - bids[g];
                    right = bids[g];
                }
            }
        }

        return right;
    }

    //#9
    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];

        for( int f = 0; f < nums.length; f++)
        {
            result[f] = 1;
        }
        for ( int h = 0; h < nums.length; h++)
        {
            for (int g = 0; g < nums.length; g++)
            {
                if( g!= h )
                {
                    result[h] = result[h] * nums[g];
                }
            }
        }
        return result;
    }

}
