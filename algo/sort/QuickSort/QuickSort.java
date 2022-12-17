package algo.sort.QuickSort;
import algo.sort.ArrayGen;

public class QuickSort extends ArrayGen{
    QuickSort(int _sz){
        super(_sz);
    }


    void handle(int start, int end){
        if (start >= end) return; //only have 1 element

        int left, right, pivot;
        left = start;
        right = end - 1;
        pivot = end;

        //gather smaller & larger element to left & right of pivot
        while (left <= right){
            while (left <= right && arr[left] <= arr[pivot]){
                left++;
            }


            while (left <= right && arr[right] > arr[pivot]){
                right--;
            }

            if (left < right) {
                int mid = arr[left];
                arr[left] = arr[right];
                arr[right] = mid;

                left++;
                right--;
            }
        }

        //put pivot in middle and handle 2 side
        int mid = arr[left];
        arr[left] = arr[pivot];
        arr[pivot] = mid;

        handle(start, left - 1);
        handle(left + 1, end);
    }


    void sorting(){
        System.out.println("=== Quick sort ===");
        handle(0, arr.length - 1);
        System.out.println("Done    ");
    }


    public static void main(String[] args) {
        QuickSort s = new QuickSort(10);
        s.printAll();
        s.sorting();
        s.printAll();
    }
}
