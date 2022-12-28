package algo.Sort.BubbleSort;
import algo.Sort.*;

public class BubbleSort extends ArrayGen{

    BubbleSort(int _sz){
        super(_sz);
    }


    void sorting(){
        System.out.println("=== Bubble sort ===");
        boolean needSwap = true;
        while (needSwap){
           needSwap = false;
           for (int i = 0 ; i < this.arr.length - 1 ; i++) {
               if (this.arr[i] > this.arr[i + 1]) {
                   needSwap = false;

                   int mid = this.arr[i];
                   this.arr[i] = this.arr[i + 1];
                   this.arr[i + 1] = mid;
               }
           }
        }

        System.out.println("Done");
    }


    public static void main(String[] args) {
        BubbleSort s = new BubbleSort(4);
        s.printAll();
        s.sorting();
        s.printAll();
    }

}
