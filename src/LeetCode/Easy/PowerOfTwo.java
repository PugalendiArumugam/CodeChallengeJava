package LeetCode.Easy;
/*
Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x.
Example 1:
Input: n = 1
Output: true
Explanation: 20 = 1

Example 2:
Input: n = 16
Output: true
Explanation: 24 = 16

Example 3:
Input: n = 3
Output: false
 */

public class PowerOfTwo {
    public static void main(String[] args) {
        PowerOfTwo pot = new PowerOfTwo();
//        System.out.println(pot.isPowerOfTwo(1));
//        System.out.println(pot.isPowerOfTwo(16));
//        System.out.println(pot.isPowerOfTwo(25));
//        System.out.println(pot.isPowerOfTwo(32));
//        System.out.println(pot.isPowerOfTwo(0));   //false
        System.out.println(pot.isPowerOfTwo(-2147483648));  // false
        System.out.println(pot.isPowerOfTwo(2147483647));  // false
    }

    public boolean isPowerOfTwo(int n) {
//        if (n==0) return false;
        return n > 0 && (n & (n - 1)) == 0;
//
//        if((n & (n-1)) == 0) return true;
//        return false;
    }
}
