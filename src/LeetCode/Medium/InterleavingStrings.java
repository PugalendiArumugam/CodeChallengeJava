package LeetCode.Medium;

public class InterleavingStrings {
    public static void main(String[] args) {
        InterleavingStrings is = new InterleavingStrings();
        System.out.println(is.isInterleave("aabcc", "dbbca", "aadbbcbcac")); //true
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(is.isInterleave(s1, s2, s3)); //false
        System.out.println(is.isInterleave("", "", "")); //true
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) return true;
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                int k = i + j - 1;
                if (i > 0) {
                    dp[j] &= s1.charAt(i - 1) == s3.charAt(k);
                }
                if (j > 0) {
                    dp[j] |= (dp[j - 1] & (s2.charAt(j - 1) == s3.charAt(k)));
                }
            }
        }
        return dp[n];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        final int m = s1.length();
        final int n = s2.length();
        if (m + n != s3.length())
            return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m; ++i)
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);

        for (int j = 1; j <= n; ++j)
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);

        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                        dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
        return dp[m][n];
    }

    // fastest using backtrack
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if((n1 + n2) != n3) {
            return false;
        }

        Boolean[][] dp = new Boolean[n1 + 1][n2 + 1];

        return backtrack(s1, s2, s3, 0, 0, 0, dp);
    }

    private boolean backtrack(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp) {
        if(k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        boolean valid = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            valid = valid || backtrack(s1, s2, s3, i + 1, j, k + 1, dp);
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            valid = valid || backtrack(s1, s2, s3, i, j + 1, k + 1, dp);
        }

        return dp[i][j] = valid;
    }

}
