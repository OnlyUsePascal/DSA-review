package algo.looping.Subset;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Submask {
    void getSubmask(String s){
        int[] arrMain = new int[s.length()];
        ArrayList<Integer> arrSub = new ArrayList<Integer>();

        //get ON idx
        for (int i = 0 ; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                arrSub.add(i);
            }
        }

        //subset of ON idx
        for (int i = 0 ; i < (int) Math.pow(2,arrSub.size()); i++){
            for (int j = 0 ; j < arrSub.size(); j++){
                arrMain[arrSub.get(j)] = (((int) Math.pow(2,j) & i) != 0) ? 1 : 0;
            }
            System.out.println(Arrays.toString(arrMain));
        }

    }


    public static void main(String[] args) {
        Submask ex = new Submask();
        ex.getSubmask("1101");
    }

}
