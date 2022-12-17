package algo.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class ArrayGen {
    public int[] arr;

    public ArrayGen(int _sz){
        arr = new int[_sz];
        for (int i = 0 ; i < _sz; i++){
            arr[i] = ThreadLocalRandom.current().nextInt(0, 99 + 1);
        }
    }


    public void printAll(){
        System.out.println("=== Array ===");
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {

    }
}
