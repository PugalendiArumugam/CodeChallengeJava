package LeetCode;

/*
Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 */

public class LongestValidParanthesis {
    public static void main(String[] args) {
        String s = ")(()(()()()()))";
        System.out.println(longestValidParentheses(s));
    }


    public static int longestValidParentheses(String s) {
        int slen = s.length();
        if(slen==0) return 0;

        int[] dp = new int[slen + 1];
        int max = 0;

        for (int i = 2; i <= slen; ++i) {
            if (s.charAt(i - 1) == ')') {
                if (s.charAt(i - 2) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else {
                    int prevIndex = i - dp[i - 1] - 1;
                    // Check for matching '('
                    if (prevIndex > 0 && s.charAt(prevIndex - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + dp[prevIndex - 1];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
