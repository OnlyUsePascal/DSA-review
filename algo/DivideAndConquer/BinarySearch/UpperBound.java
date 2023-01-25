package algo.DivideAndConquer.BinarySearch;
import algo.ArrayGen;
import algo.Sort.QuickSort.QuickSort;

import java.util.Arrays;

public class UpperBound{
    UpperBound(){
    }


    static int getUpperBound(int[] arr, int target){
        int left, right;
        left = 0;
        right = arr.length -1;

        while (left <= right){
            int mid = (left + right) / 2;
            System.out.println(left + " " + right + " " + mid);
            if (arr[mid] <= target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(left);
        return left;
    }


    public static void main(String[] args) {
        int[] arr = (new ArrayGen()).getArr(10);
        (new QuickSort()).sorting(arr);
        System.out.println(Arrays.toString(arr));
        UpperBound.getUpperBound(arr, 4);
    }
}
