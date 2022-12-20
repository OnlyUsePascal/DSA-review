package algo.looping.Permutation;

import java.util.Arrays;

public class Permutation {
    int[] arr;

    Permutation(int n){
        arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = i;
        }
    }


    void swap(int i1, int i2){
        int mid = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = mid;
    }


    void reverse(int l, int r){
        while (l <= r){
            swap(l,r);
            l++;
            r--;
        }
    }


    void permutate(){
        System.out.println("=== Permutation ===");
        //59876 -> 625789
        boolean capable = true;
        while (capable){
            printAll();
            capable = false;

            //find change point
            int idx;
            for (idx = arr.length - 1; idx > 0; idx--){
                if (arr[idx] > arr[idx-1]){
                    capable = true;
                    break;
                }
            }

            //can permutate
            if (capable){
                int idx2 = arr.length - 1;
                while (arr[idx2] < arr[idx-1]) idx2--;

                //swap
                swap(idx-1, idx2);

                //reverse
                reverse(idx, arr.length -1);
            }
        }
    }


    void printAll(){
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        Permutation ex = new Permutation(3);
        ex.permutate();
    }
}
