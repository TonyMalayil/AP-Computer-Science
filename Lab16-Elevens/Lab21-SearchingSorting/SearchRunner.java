import java.util.*;

public class SearchRunner
{
    public static void main( String[] args)
    {
        int[] nums = {0 , 45, 1, 3 ,2, 44, 22, 19, 4, 6};
        SearchSort s = new SearchSort(nums);

        /*
        System.out.println( s.linearSearch(40)); //good

        System.out.println(s.linearSearchRecur(3)); //good

        System.out.println(s.binarySearch(5));

        System.out.println(s.binarySearchRecursive(9));
        s.bubbleSort(true); //good

        s.selectionSort(true); //good

        s.insertionSort(true); //good


         */
        SearchSort t = new SearchSort(10);
        s.mergeSort(true);
    }
}
