package LeetCode.Easy;

/*
Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 */

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
//        int[] digits = new int[]{1,2,3};
        int[] digits = new int[]{4,3,7,9};
//        int[] digits = new int[]{9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
//        if (digits.length == 0) return new int[0];
//        StringBuilder sb = new StringBuilder();
//        int carry=1, val=0;
//        for (int i = digits.length - 1; i >= 0; i--) {
//             val = digits[i]+carry;
//             if(val>9) {
//                 carry = val - 9;
//                 val=0;
//             } else {
//                 carry =0;
//             }
//             sb.append(val);
//             if(i!=0) sb.append("^");
//        }
//        if(carry==1) sb.append("^1");
//        sb.reverse();
//        String[] res = sb.toString().split("\\^");
//        return Arrays.stream(res).mapToInt(Integer::parseInt).toArray();

        // best solution
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] additional = new int[n + 1];
        additional[0] = 1;
        return additional;


    }
}
