package algo.Math.LCM;
import algo.Math.GCD.*;

public class LCM {
    int findLCM(int a, int b){
        return a * b / (new GCD().findGCD(a,b));
    }


    public static void main(String[] args) {
        System.out.println(new LCM().findLCM(3,6));
    }
}
