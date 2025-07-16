package LeetCode.Easy;
/*
459
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
Example 1:
Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

Example 2:
Input: s = "aba"
Output: false

Example 3:
Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.


 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
        System.out.println(rsp.repeatedSubstringPattern("abab"));  //true ab+ab
        System.out.println(rsp.repeatedSubstringPattern("aba"));   //false
        System.out.println(rsp.repeatedSubstringPattern("abcabcabcabc"));  //true abc+abc+abc+abc
        System.out.println(rsp.repeatedSubstringPattern("abaababaab"));  //true   abaab+abaab
        System.out.println(rsp.repeatedSubstringPattern("aabaab"));  //true   aab+aab
        System.out.println(rsp.repeatedSubstringPattern3("ababab"));  //true   ab+ab+ab
    }

    public boolean repeatedSubstringPattern(String s) {
        String checkString = s + s;
        String temp = checkString.substring(1, checkString.length() - 1);
        return checkString.substring(1, checkString.length() - 1).contains(s);
    }

    // best solution
    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0 && s.substring(0, i).repeat(n / i).equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern3(String s){
        int n = s.length();
        for (int i = n/2; i>= 1; i--) {
            if (n % i == 0) {
                String subs = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j=1; j <= n/i; j++) {
                    sb.append(subs);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
