package LeetCode.Easy;

/*
Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 */

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(17));
    }

    public static int climbStairs(int n) {
        int first = 0, second = 1;

        // Loop through number of steps n
        for (int i = 0; i < n; i++) {
            // Calculate next number in the series
            int next = first + second;

            // Update the previous two numbers for next iteration
            first = second;
            second = next;
        }

        // The 'second' variable holds the total ways to reach the top
        return second;
    }

    public static int climbStairs2(int n) {
        int oneStep = 0, twoStep = 1;
        for (int i = 0; i < n; i++) {
            int next = oneStep + twoStep;
            oneStep = twoStep;
            twoStep = next;
        }
        return twoStep;
    }


}
