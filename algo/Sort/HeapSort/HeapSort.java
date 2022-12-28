package algo.Sort.HeapSort;


import algo.Sort.ArrayGen;
import data_structure.Heap.*;

public class HeapSort extends ArrayGen {
    HeapSort(int _sz){
        super(_sz);
    }


    void sorting(){
        System.out.println("=== Heap Sort ===");

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

        System.out.println("Done");
    }


    public static void main(String[] args) {
        HeapSort s = new HeapSort(10);
        s.printAll();
        s.sorting();
        s.printAll();
    }
}
