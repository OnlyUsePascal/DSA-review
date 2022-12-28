package algo.Sort.CountSort;

import algo.Sort.ArrayGen;

public class CountSort extends ArrayGen {
    CountSort(int _sz){
        super(_sz);
    }


    void sorting(){
        System.out.println("=== Count sort ===");
        //get min, max value of array
        int arrMax, arrMin;
        arrMax = Integer.MIN_VALUE;
        arrMin = Integer.MAX_VALUE;

        for (int k : this.arr){
            arrMax = Math.max(k, arrMax);
            arrMin = Math.min(k, arrMin);
        }

        //generate freqency array & count
        int freqSize = arrMax - arrMin  + 1;
        int[] freq = new int[freqSize];
        for (int k : this.arr){
            freq[k - arrMin] ++;
        }

        int idx = 0;
        for (int i = 0 ; i < freqSize; i++){
            if (freq[i] != 0){
                for (int j = 0; j < freq[i]; j++){
                    arr[idx] = i + arrMin;
                    idx++;
                }
            }
        }

        System.out.println("Done");
    }


    public static void main(String[] args) {
        CountSort s = new CountSort(10);
        s.printAll();
        s.sorting();
        s.printAll();
    }
}
