package LeetCode.Medium;

public class PowerXandn {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 3));   //1024.0000
        System.out.println(myPow(2.00000, 10));   //1024.0000
        System.out.println(myPow(2.10000, 3));    //9.26100
        System.out.println(myPow(2.00000, -2));       //0.25000
        System.out.println(myPow(2.00000, -200000000));       //not overflow error
//        System.out.println(myPow(0.44528, 0));       // 1.000
    }

    public static double myPow(double x, int n) {
        if (n==0 && x!=0) {
            return 1.0;
        }
        boolean negPow = n < 0.0;
        double total = 1.0;
        total = iteratePow(total,x,Math.abs(n));
        return negPow ? 1/total : total ;
    }

    public static double iteratePow(double total, double x, int n){
        if (total >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (total<= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(n==0) return total;
        total = total * x;
        total = iteratePow(total,x,n-1);
        return total;
    }
}
