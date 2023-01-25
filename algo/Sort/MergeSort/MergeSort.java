package algo.Sort.MergeSort;

import algo.ArrayGen;
import algo.Sort.QuickSort.QuickSort;

import java.util.Arrays;

public class MergeSort{
    MergeSort(){
    }


    void sorting(int[] arr){
        if (arr.length > 1) {
            int n = arr.length;
            int middle = n / 2;

            // create 2 sub-arrays from arr
            int[] sub1 = new int[middle];
            for (int i = 0; i < middle; i++) {
                sub1[i] = arr[i];
            }
            int[] sub2 = new int[n - middle];
            for (int i = middle; i < n; i++) {
                sub2[i - middle] = arr[i];
            }

            // sort first and second halves
            sorting(sub1);
            sorting(sub2);

            // merge sub1 and sub2 into the original array
            merge(sub1, sub2, arr);
        }
    }


    void merge(int[] sub1, int[] sub2, int[] dest) {
        int p1 = 0, p2 = 0, pDest = 0;  // pointers to 3 arrays
        while (p1 < sub1.length && p2 < sub2.length) {
            if (sub1[p1] <= sub2[p2]) {
                dest[pDest] = sub1[p1];
                p1++;
            } else {
                dest[pDest] = sub2[p2];
                p2++;
            }
            pDest++;
        }

        // copy remaining elements, if any
        while (p1 < sub1.length) {
            dest[pDest++] = sub1[p1++];
        }
        while (p2 < sub2.length) {
            dest[pDest++] = sub2[p2++];
        }
    }


    public static void main(String[] args) {
        int[] arr = (new ArrayGen()).getArr(10);
        System.out.println(Arrays.toString(arr));
        (new MergeSort()).sorting(arr);
        System.out.println(Arrays.toString(arr));
    }
}
