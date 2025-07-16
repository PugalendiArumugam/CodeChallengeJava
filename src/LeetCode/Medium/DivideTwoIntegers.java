package LeetCode.Medium;
/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.

Example 2:
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.

 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
//        System.out.println(divide(1000,1));
//        System.out.println(divide(7,3));
//        System.out.println(divide(7,-3));
//        System.out.println(divide(-7,3));
//        System.out.println(divide(-7,-3));
//        System.out.println(divide(7,1));
        System.out.println(divide(-2147483648,-1));    // expected 2147483647
//        System.out.println(divide(-2147483648,1));    // expected -2147483648
    }

    public static int divide(int dividend, int divisor) {
        if (divisor==0) return 0;
        int sign =1;
        if((dividend<0) != (divisor<0)) sign =-1;    // decide on sign like XOR
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        long quotient=0;
//        long val=longDividend;
        // to optimize if the difference is huge dividend use fi
//        while(val>0){
//            if(val>=longDivisor){
//                val=val-longDivisor;
//                q++;
//            } else break;
//        }
        while (longDividend >= longDivisor) {
            int count = 0;
            long temp = 0;
            while (longDividend >= (longDivisor << (count + 1))) {
                temp=longDivisor << (count + 1);
                count++;
            }
            quotient += 1L << count;
            longDividend -= longDivisor << count;
        }
        if(sign==1 && quotient-1 ==Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else if (sign==-1) {
            quotient*=-1;
        }
        return (int)quotient;
    }

    public int divideii(int dividend, int divisor) {       // using multiplication and division
        if(dividend == -2147483648 && divisor == -1){
            return 2147483647;
        }
        return dividend/divisor;
    }
}

//            if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && s.charAt(i)> '7') ) {
//        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

