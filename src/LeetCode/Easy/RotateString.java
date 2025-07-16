package LeetCode.Easy;

/* 796 Rotate String
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:
Input: s = "abcde", goal = "cdeab"
Output: true

Example 2:
Input: s = "abcde", goal = "abced"
Output: false
 */
public class RotateString {
    public static void main(String[] args) {
        RotateString rs = new RotateString();
        System.out.println(rs.rotateString("abcde", "bcdea"));   //true
        System.out.println(rs.rotateString("abcde", "cdeab"));   //true
        System.out.println(rs.rotateString("abcde", "deabc"));   //true
        System.out.println(rs.rotateString("abcde", "eabcd"));   //true
        System.out.println(rs.rotateString("abcde", "abcde"));   //true
        System.out.println(rs.rotateString("abcde", "abced"));  // false
        System.out.println(rs.rotateString("defdefdefabcabc", "defdefabcabcdef"));   //true
        System.out.println(rs.rotateString("bbbacddceeb", "ceebbbbacdd"));  // true
    }

// not working as rotation causes problem.
// the logic should be always double the given string.
// and search the rotated string is available in the target string
//
// may be you should move the two pointers start from the middle of doubled string.
//
    public boolean rotateString1(String s, String goal) {
        if (s.equals(goal)) return true;
        if(s.length()!=goal.length()) return false;
        int flen=0;
        int prev=goal.lastIndexOf(s.substring(0, 1));
        for (int i = 1; i <s.length(); i++) {
            int curr=goal.lastIndexOf(s.substring(0, i));
            if (prev!= curr || curr==-1) {
                break;
            }
            flen++;
        }
        String s1=s.substring(flen);
        String s2=goal.substring(0, goal.length()-flen);
        return s.substring(flen).equals(goal.substring(0,goal.length()-flen));
    }

// Simple logic would be double the string and check the target available in the doubleed string
//***
public boolean rotateString(String s, String goal) {
    if (s.equals(goal)) return true;
    if(s.length()!=goal.length()) return false;
    String ds = s+s;
    return ds.contains(goal);
}


}
