package algo.Sort.CountSort;

import algo.ArrayGen;
import algo.Sort.MergeSort.MergeSort;

import java.util.Arrays;

public class CountSort {
    CountSort(){}

    void sorting(int[] arr){
        //get min, max value of array
        int arrMax, arrMin;
        arrMax = Integer.MIN_VALUE;
        arrMin = Integer.MAX_VALUE;

        for (int k : arr){
            arrMax = Math.max(k, arrMax);
            arrMin = Math.min(k, arrMin);
        }

        //generate freqency array & count
        int freqSize = arrMax - arrMin  + 1;
        int[] freq = new int[freqSize];
        for (int k : arr){
            freq[k - arrMin] ++;
        }

        //map back to result
        int idx = 0;
        for (int i = 0 ; i < freqSize; i++){
            if (freq[i] != 0){
                for (int j = 0; j < freq[i]; j++){
                    arr[idx] = i + arrMin;
                    idx++;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = (new ArrayGen()).getArr(10);
        System.out.println(Arrays.toString(arr));
        (new CountSort()).sorting(arr);
        System.out.println(Arrays.toString(arr));
    }
}
