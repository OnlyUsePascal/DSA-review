package algo.DivideAndConquer.BinarySearch;
import algo.Sort.ArrayGen;

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
        s.arr = new int[]{};
        System.out.println(Arrays.toString(s.arr));

        System.out.println(s.lowerBound(2));
        System.out.println(s.upperBound(2));
    }
}
