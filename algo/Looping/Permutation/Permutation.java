package algo.Looping.Permutation;

import java.util.Arrays;

public class Permutation {
    int[] arr;
    Permutation(int[] input){
        arr = input;
    }


    static void processArr(int[] permutation) {
        System.out.println("Permutation: " + Arrays.toString(permutation));
    }


    static void permute(int[] input, boolean[] taken, int[] current, int idx) {
        if (idx == input.length) {
            processArr(current);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (taken[i]) {
                continue;
            }
            current[idx] = input[i];
            taken[i] = true;
            permute(input, taken, current, idx + 1);
            taken[i] = false;
        }
    }


    void getPermutation(){
        int n = arr.length;
        permute(arr, new boolean[n], new int[n], 0);
    }


    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        (new Permutation(input)).getPermutation();
    }
}