import java.util.*;

public class SearchSort {
    private int[] nums;

    public SearchSort(int[] nums) {
        this.nums = nums;
    }

    public SearchSort(int size) {
        nums = new int[size];
        intitArray();
    }

    public void intitArray() {
        Random rng = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rng.nextInt(1000) + 1;
        }
    }

    private void swap(int i, int j) {
        int hold = nums[i];
        nums[i] = nums[j];
        nums[j] = hold;
    }

    public int linearSearch(int key) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key)
                index = i;
        }

        return index;
    }

    public int linearSearchRecur(int key) {
        return linearSearchRecur1(key, 0);

    }

    private int linearSearchRecur1(int key, int index) {
        if (nums[index] == key)
            return index;
        if( index+1 >= nums.length)
            return -1;
        return linearSearchRecur1(key, index + 1);

    }

    public int binarySearch(int key)
    {

        Arrays.sort(nums);

        int b = 0;
        int t = nums.length -1;

        while( t >= b )
        {
            int m = b + (t-b)/2;
            if( nums[m] == key)
                return m;
            if( nums[m] < key )
            {
                b = m+1;
            }
            if( nums[m] > key )
            {
                t = m -1;
            }

        }

        return -1;

    }

    public int binarySearchRecursive(int key) {
        Arrays.sort(nums);

        return binarySearchRcur(key, 0, nums.length+1);
    }

    private int binarySearchRcur( int key, int b, int t)
    {
        if( t >= b )
        {
            int midpoint = b + (t-b)/2;

            if( nums[midpoint] == key)
            {
                return midpoint;
            }
            if( nums[midpoint] > key )
            {
                return binarySearchRcur(key, b, midpoint+1);
            }

            return binarySearchRcur(key, midpoint-1, t);
        }

        return -1;
    }

    public void bubbleSort(boolean print) {
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        if( print)
            System.out.println(Arrays.toString(nums));
    }

    public void selectionSort(boolean print)
    {
        int min = Integer.MAX_VALUE;
        int temp;

        for( int i = 0; i < nums.length; i++)
        {
            min = nums[i];
            for( int q = i+1; q < nums.length; q++)
            {
                if( min > nums[q] )
                {
                    temp = nums[q];
                    nums[q] = min;
                    min = temp;
                }
            }
            nums[i] = min;
        }

        if(print)
            System.out.println( Arrays.toString(nums) );
    }

    public void insertionSort( boolean print )
    {
        for( int i = 1; i < nums.length; i++)
        {
            if( nums[i] < nums[i-1] )
            {
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp;
            }
            for( int q = i-1; q > 0; q--)
            {
                if( nums[q] < nums[q-1] )
                {
                    int New = nums[q-1];
                    nums[q-1] = nums[q];
                    nums[q] = New;
                }
            }
        }

        if( print )
            System.out.println(Arrays.toString(nums));
    }

    public void mergeSort( boolean print)
    {
        mergeSortRecur(0, (nums.length-1), new int[nums.length]);

        if( print )
            System.out.println(Arrays.toString(nums));
    }

    private void mergeSortRecur( int b, int t, int[]temp)
    {

        if( b >= t)
            return;

        int mid = (b+t)/2;
        mergeSortRecur(b, mid, temp);
        mergeSortRecur(mid+1, t, temp);
        mergeHalves( b, t, temp);
    }

    private void mergeHalves( int b, int t, int[]temp)
    {
        int bEnd = (t + b) /2;
        int rStart = bEnd +1;
        int size = t - b +1;

        int left = b;
        int right = rStart;
        int index = b;

        while( left <= bEnd && right <= t)
        {
            if( nums[left] <= nums[right])
            {
                temp[index] = nums[left];
                left++;
            }
            else{
                temp[index] = nums[right];
                right++;
            }
            index++;
        }

        System.arraycopy(nums, left, temp, index, bEnd - left+1);
        System.arraycopy(nums, right, temp, index, t -right+1);
        System.arraycopy(temp, b, nums, b, size);
    }
}