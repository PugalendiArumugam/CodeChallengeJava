package LeetCode;

public class LongestSubstringPalindrome {
    public static void main(String[] args) {
        String str = "ABRBADAADAB";
//        String str = "babad";
//        String str = "cbbd";
        String result = solution(str);
        System.out.println(result);
    }

    public static String solution(String s){
        // Preprocess the string to handle even-length palindromes
        StringBuilder t = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            t.append("#").append(c);
        }
        t.append("#$");

        int n = t.length();
        int[] p = new int[n];
        int c = 0, r = 0;  // current center and right edge of the rightmost palindrome

        for (int i = 1; i < n - 1; i++) {
            int mirr = 2 * c - i;  // mirror of i with respect to center c
            if (i < r) {
                int tt = Math.min(r - i, p[mirr]);
                p[i] = Math.min(r - i, p[mirr]);
            }

            // Attempt to expand the palindrome centered at i
            while (t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                char str1 = t.charAt(i + p[i] + 1);
                char str2 = t.charAt(i - p[i] - 1);

                p[i]++;
            }

            // Update the center and right edge if the expanded palindrome is beyond r
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }

        // Find the maximum element in p
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;  // Adjust start index for the original string
        return s.substring(start, start + maxLen);
    }


}
