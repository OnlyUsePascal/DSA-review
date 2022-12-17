package algo.divide_conquer.Exponential;

public class Exponential {
    static int getPow(int base, int exp){
        if (exp == 0) return 1;
        if (exp == 1) return base;

        int halfPow = getPow(base, exp/2);
        if (exp % 2 == 0){
            return halfPow * halfPow;
        }
        else{
            return halfPow * halfPow * base;
        }
    }


    public static void main(String[] args) {
        int base = 2;
        int exp = 3;

        System.out.println(getPow(base, exp));
    }
}
