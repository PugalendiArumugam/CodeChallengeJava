package LeetCode;


// Given a string s, find the length of the longest substring without duplicate characters.
/*
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: s = "abcbabcd"
Output: 4
Explanation: The answer is "abcd", with the length of 4.

*/

public class LongestSubstring {

    public static void main(String[] args) {
        String str = "abcababcdb";
        int result = solution(str);
        System.out.println(result);
    }

    public static int solution(String s){
        int maxlenth =0;
        for(int right =0, left = 0; right <s.length(); right++){
            int position = s.indexOf(s.charAt(right), left);
            if(position != right){
                left = position + 1;
            }
            maxlenth = Math.max(maxlenth, right-left+1);
        }
        return maxlenth;

//        int indexes[] = new int[128];
//        for(int i=0;i<128;i++) indexes[i]=-1;
//
//        int max = 0;
//        int i=0;
//        for(int j=0;j<s.length();j++) {
//            int leftptr = indexes[s.charAt(j)];
//            char ch = s.charAt(j);
//            if(leftptr>=i) {
//                i=leftptr+1;
//            }
//            max = Math.max(max,j-i+1);
//            indexes[s.charAt(j)]=j;
//        }
//
//        return max;


    }
}
