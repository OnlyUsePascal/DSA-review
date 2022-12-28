package algo.Math.GCD;

public class GCD {
    public int findGCD(int a, int b){
        return (b == 0) ? a : findGCD(b, a % b);
    }


    public static void main(String[] args) {
        System.out.println((new GCD().findGCD(3,5)));
    }
}
