package algo.Sort.HeapSort;


import algo.ArrayGen;
import data_structure.Heap.Heap;

import java.util.Arrays;

public class HeapSort  {
    HeapSort(){}

    void sorting(int[] arr){
        //initialize heap
        Heap heapArr = new Heap(arr.length);

        for (int element : arr){
            heapArr.insertHeap(element);
        }

        //extract root one by one
        for (int i = arr.length - 1 ; i >= 0; i--){
            arr[i] = heapArr.arr[0];
            heapArr.removeHeap();
        }
    }


    public static void main(String[] args) {
        int[] arr = (new ArrayGen()).getArr(10);
        System.out.println(Arrays.toString(arr));
        (new HeapSort()).sorting(arr);
        System.out.println(Arrays.toString(arr));
    }
}
