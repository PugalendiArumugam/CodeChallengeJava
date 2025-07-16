package LeetCode;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aab", "a.*"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        //Dynamic table
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Empty pattern matches empty text
        dp[0][0] = true;

        //  for * patterns
        for (int j = 1; j <= m; ++j) {
            if (p.charAt(j - 1) == '*' && j > 1) {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Main process to complete the table
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {


                if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // * patter processing
                else if (p.charAt(j - 1) == '*' && j > 1) {

                    dp[i][j] = dp[i][j - 2] ||
                            (dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) ||
                                    p.charAt(j - 2) == '.'));
                }
            }
        }

        return dp[n][m];
    }
}
