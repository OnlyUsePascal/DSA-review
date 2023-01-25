package algo.Looping.Subset;

public class Subset<T> {
    T[] arr;
    Subset(T[] _arr){
        arr = _arr;
    }

    void arrayProcess(boolean[] idxArr){
        System.out.print("Subset: ");
        for (int i = 0; i < arr.length; i++)
            if (idxArr[i]) System.out.print(arr[i] + " ");
        System.out.println();
    }


    void recursive(boolean[] idxArr, int idx){
        for (int i = 0 ; i <= 1; i++){
           idxArr[idx] = (i==1) ? true : false;
           if (idx == idxArr.length - 1){
               arrayProcess(idxArr);
           }
           else{
               recursive(idxArr, idx+1);
           }
        }
    }


    void doSubset(){
        recursive(new boolean[arr.length], 0);
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3};
        Subset ex = new Subset<Integer>(arr);
        ex.doSubset();
    }

}