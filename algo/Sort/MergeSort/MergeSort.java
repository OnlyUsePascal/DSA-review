package algo.Sort.MergeSort;
import algo.Sort.*;

public class MergeSort extends ArrayGen{
    MergeSort(int _sz){
        super(_sz);
    }


    void merge(int left, int right, int mid){
        int[] mergeArr = new int[right - left + 1];
        int left1, left2, idx;

        left1 = left;
        left2 = mid + 1;
        idx = 0;

        //merging two arrays
        while (left1 < mid + 1 || left2 < right + 1){
            if (left1 == mid + 1){
                mergeArr[idx] = arr[left2];
                left2++;
            }
            else if (left2 == right+1) {
                mergeArr[idx] = arr[left1];
                left1++;
            }
            else if (arr[left1] >= arr[left2]){
                mergeArr[idx] = arr[left2];
                left2++;
            }
            else{
                mergeArr[idx] = arr[left1];
                left1++;
            }
            idx++;
        }

        //copy element
        for (int i = left; i <= right; i++){
            arr[i] = mergeArr[i - left];
        }
    }


    void sort(int left, int right){
        //no need sort if length = 1
        if (left >= right) return;

        int mid = (left + right) / 2;
        //handle left side & right side
        sort(left, mid);
        sort(mid+1, right);

        //merge
        merge(left, right, mid);
    }


    void sorting(){
        System.out.println("=== Merge Sort ===");
        sort(0, arr.length-1);
        System.out.println("Done");
    }


    public static void main(String[] args) {
        MergeSort s = new MergeSort(10);
        s.printAll();
        s.sorting();
        s.printAll();
    }
}
