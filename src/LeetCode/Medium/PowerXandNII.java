package LeetCode.Medium;

public class PowerXandNII {
    public static void main(String[] args) {
//        System.out.println(myPow(2.00000, 3));   //8.0
//        System.out.println(myPow(2.00000, 10));   //1024.0000
        System.out.println(myPow(5.00000, 7));   //
//        System.out.println(myPow(2.10000, 3));    //9.26100
//        System.out.println(myPow(2.00000, -2));       //0.25000
//        System.out.println(myPow(2.00000, -200000000));       //not overflow error
//        System.out.println(myPow(0.44528, 0));       // 1.000
//        System.out.println(myPow(0.0, 1));       // 1.000
    }

    public static   double myPow(double x, int n) {
        // If power n is non-negative, calculate power using helper method
        if (n >= 0) {
            return quickPow(x, n);
        } else {
            // If power n is negative, calculate the inverse of the power
            return 1 / quickPow(x, -(long) n);
        }
    }

    private static double quickPow(double base, long exponent) {
        double result = 1; // Initialize result to neutral element for multiplication

        // Loop through all bits of the exponent
        while (exponent > 0) {
            // If the current bit is set, multiply the result by the base
            if ((exponent & 1) == 1) {
                result *= base;
            }
            // Square the base for the next bit in the exponent
            base *= base;
            // Shift exponent to the right to process the next bit
            exponent >>= 1;
        }

        // Return the final result of base raised to the exponent
        return result;
    }


    public static double myPow1(double x, int n) {
        if (n >= 0) {
            return iteratePow(x, n);
        } else {
            return 1 / iteratePow(x, -(long) n);
        }
    }

    private static double iteratePow(double base, long exponent) {
        double result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }


}
