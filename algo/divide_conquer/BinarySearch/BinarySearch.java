package algo.divide_conquer.BinarySearch;
import algo.sort.ArrayGen;

import java.util.Arrays;

public class BinarySearch extends ArrayGen{
    BinarySearch(int sz){
        super(sz);
    }


    int lowerBound(int input){
        System.out.println("=== Lower ===");
        int left, right;
        left = 0;
        right = arr.length -1;

        while (left <= right){
            int mid = (left + right) / 2;
            System.out.println(left + " " + right + " " + mid);
            if (arr[mid] < input){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return left;
    }


    int upperBound(int input){
        System.out.println("=== Upper ===");
        int left, right;
        left = 0;
        right = arr.length -1;

        while (left <= right){
            int mid = (left + right) / 2;
            System.out.println(left + " " + right + " " + mid);
            if (arr[mid] <= input){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        BinarySearch s = new BinarySearch(6);
//        Arrays.sort(s.arr);
        s.arr = new int[]{1, 1, 2, 2, 3, 4};
        System.out.println(Arrays.toString(s.arr));

        System.out.println(s.lowerBound(4));
        System.out.println(s.upperBound(2));

    }
}
