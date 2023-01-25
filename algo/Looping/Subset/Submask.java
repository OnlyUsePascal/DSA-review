package algo.Looping.Subset;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Submask {
    int[] arrMain;
    ArrayList<Integer> arrSub;

    Submask(String s){
        arrMain = new int[s.length()];
        arrSub = new ArrayList<>();

        //get ON idx
        for (int i = 0 ; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                arrSub.add(i);
            }
        }
    }


    void arrayProcess(boolean[] idxArr){
        System.out.print("Submask: ");
        //marking the submask
        int[] subMask = new int[arrMain.length];
        for (int i = 0 ; i < idxArr.length; i++){
            if (idxArr[i]) subMask[arrSub.get(i)] = 1;
        }
        System.out.println(Arrays.toString(subMask));
    }


    void recursive(boolean[] arrIdx, int idx){
        for (int i = 0 ; i <= 1; i++){
            arrIdx[idx] = i == 1;
            if (idx == arrIdx.length - 1){
                arrayProcess(arrIdx);
            }
            else{
                recursive(arrIdx, idx+1);
            }
        }
    }


    void getSubmask(){
        recursive(new boolean[arrSub.size()], 0);
    }


    public static void main(String[] args) {
        (new Submask("1101")).getSubmask();
    }

}
