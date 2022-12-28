package algo.DivideAndConquer.QuickSelect;
import algo.Sort.ArrayGen;

public class QuickSelect extends ArrayGen{
    //find element at index n
    QuickSelect(int sz){
        super(sz);
    }

    int goal;

    int findNth(int start, int end){
        if (start >= end) return arr[start]; //only have 1 element

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

        //return result
        if (left == goal){
            return arr[left];
        }
        else if (left < goal){
            return findNth(left + 1, end);
        }
        else{
            return findNth(start, left - 1);
        }
    }


    void getNth(int _goal){
        System.out.println("=== Get element at index: " + _goal + " ===");
        goal = _goal;
        System.out.println(findNth(0, arr.length - 1));
    }


    public static void main(String[] args) {
        QuickSelect s = new QuickSelect(10);
        s.printAll();
        s.getNth(3);
    }

}
