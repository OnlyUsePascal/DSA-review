package algo.Sort.SelectionSort;

import algo.ArrayGen;
import algo.Sort.MergeSort.MergeSort;

import java.util.Arrays;

public class SelectionSort{
    SelectionSort(){
    }


    void sorting(int[] arr){
        for (int i = 0 ; i < arr.length - 1 ; i++){
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[i]){
                    int mid = arr[j];
                    arr[j] = arr[i];
                    arr[i] = mid;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = (new ArrayGen()).getArr(10);
        System.out.println(Arrays.toString(arr));
        (new SelectionSort()).sorting(arr);
        System.out.println(Arrays.toString(arr));
    }
}
