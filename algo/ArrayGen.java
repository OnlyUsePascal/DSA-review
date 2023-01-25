package algo;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class ArrayGen {

    public ArrayGen(){
    }


    public void switchElement(int[] arr, int idx1, int idx2){
        int mid = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = mid;
    }


    public int[] getArr(int _sz){
        int[] arr = new int[_sz];
        for (int i = 0 ; i < _sz; i++){
            arr[i] = ThreadLocalRandom.current().nextInt(0, _sz + 5);
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = (new ArrayGen()).getArr(10);
        System.out.println(Arrays.toString(arr));
    }
}
