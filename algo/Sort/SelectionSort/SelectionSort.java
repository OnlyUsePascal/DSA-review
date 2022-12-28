package algo.Sort.SelectionSort;
import algo.Sort.*;

public class SelectionSort extends ArrayGen{
    SelectionSort(int _sz){
        super(_sz);
    }


    void sorting(){
        System.out.println("=== selection sort ===");
        for (int i = 0 ; i < this.arr.length - 1 ; i++){
            for (int j = i+1; j < this.arr.length; j++){
                if (arr[j] < arr[i]){
                    int mid = arr[j];
                    arr[j] = arr[i];
                    arr[i] = mid;
                }
            }
        }

        System.out.println("Done");
    }


    public static void main(String[] args) {
        SelectionSort s = new SelectionSort(5);
        s.printAll();
        s.sorting();
        s.printAll();
    }
}
