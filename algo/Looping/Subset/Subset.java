package algo.Looping.Subset;

import java.util.Arrays;

public class Subset {
    void arrayMethod(int n){
        for (int i = 0 ; i < (int) Math.pow(2,n); i++){
            for (int j = 0 ; j < n; j++){
                System.out.print(((1 << j & i) != 0) ? "1 " : "0 ");
            }
            System.out.println("");
        }
    }


    void recursiveMethod(int[] arr, int idx){
        for (int i = 0 ; i <= 1; i++){
           arr[idx] = i;
           if (idx == arr.length - 1){
               System.out.println(Arrays.toString(arr));
           }
           else{
               recursiveMethod(arr, idx+1);
           }
        }
    }


    public static void main(String[] args) {
        Subset ex = new Subset();
        ex.arrayMethod(3);
//        ex.recursiveMethod(new int[3], 0);
    }

}