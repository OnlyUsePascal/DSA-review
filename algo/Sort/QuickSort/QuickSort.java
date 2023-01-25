package algo.Sort.QuickSort;
import algo.ArrayGen;

import java.util.Arrays;

public class QuickSort {

    public QuickSort(){
    }

    int[] arr;
    public void sorting(int[] _arr){
        arr = _arr;
        handle(0, arr.length - 1);
//        _arr = arr;
    }


    void handle(int start, int end){
        if (start >= end) return; //only have 1 element

        int left, right, pivot;
        left = start;
        right = end - 1;
        pivot = end;

        //gather smaller & larger element to left & right of pivot
        while (left <= right){
            while (left <= right && arr[left] <= arr[pivot]){
                left++;
            }
            while (left <= right && arr[right] > arr[pivot]){
                right--;
            }

            if (left < right) {
                int mid = arr[left];
                arr[left] = arr[right];
                arr[right] = mid;

                left++;
                right--;
            }
        }

        //put pivot in middle and handle 2 side
        int mid = arr[left];
        arr[left] = arr[pivot];
        arr[pivot] = mid;

        handle(start, left - 1);
        handle(left + 1, end);
    }


    public static void main(String[] args) {
        int[] arr = (new ArrayGen()).getArr(10);
        System.out.println(Arrays.toString(arr));
        (new QuickSort()).sorting(arr);
        System.out.println(Arrays.toString(arr));
    }
}
