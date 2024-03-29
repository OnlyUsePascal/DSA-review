package data_structure.Heap;

import algo.*;

import java.util.Arrays;

public class Heap {
    //default max heap
    public int[] arr;
    public int lastIdx;

    public Heap(int _sz){
        arr = new int[_sz];
        lastIdx = -1;
    }

    void replaceElement(int i1, int i2){
        int mid = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = mid;
    }


    public void insertHeap(int _input){
        System.out.println("==== Insert element ====");
        if (lastIdx + 1 >= arr.length){
            System.out.printf("Heap is full");
            return;
        }

        //put element in last position,
        lastIdx++;
        arr[lastIdx] = _input;

        // then switch from bottom to top
        int idx = lastIdx;
        while (idx > 0 && arr[idx] > arr[idx/2]){
            replaceElement(idx, idx/2);
            idx /= 2;
        }
        System.out.println("Inserted: " + _input);
    }


    public void removeHeap(){
        //remove the top heap
        System.out.println("=== Remove heap ===");
        if (lastIdx == -1){
            System.out.println("Heap is blank");
            return;
        }

        //switch root with last element
        arr[0] = arr[lastIdx];
        lastIdx--;

        //heapify
        int idx = 0;
        while (idx <= lastIdx){
            //look for children
            int mid = idx;
            if (idx*2 + 1 <= lastIdx && arr[idx*2 + 1] > arr[mid]){
                mid = idx * 2 + 1;
            }
            if (idx*2 + 2 <= lastIdx && arr[idx*2 + 2] > arr[mid]){
                mid = idx * 2 + 2;
            }

            //replace
            if (idx != mid){
                replaceElement(idx, mid);
                idx = mid;
            }
            else{
                break;
            }
        }

        System.out.println("Removed");
    }


    public void printAll(){
        System.out.println("=== Print all ===");

        if (lastIdx == -1){
            System.out.println("heap is blank");
        }
        else{
            for (int i = 0; (int) Math.pow(2,i) - 1 <= lastIdx; i ++){
                System.out.print("Level " +  i + ":");
                for (int j = (int) Math.pow(2,i) - 1; j <= lastIdx && j <= Math.pow(2,i+1) - 2; j++){
                    System.out.print(" " + arr[j]);
                }
                System.out.println("");
            }
        }
    }


    public static void main(String[] args) {
        int sz = 10;
        Heap s = new Heap(sz);

        int[] input = (new ArrayGen()).getArr(sz);
        for (int k : input){
            s.insertHeap(k);
        }

        s.printAll();
        s.removeHeap();
        s.printAll();
    }

}
