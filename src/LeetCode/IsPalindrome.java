package LeetCode;

import java.util.Locale;
/*
Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
        Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
*/

public class IsPalindrome {
    public static void main(String[] args) {
        String s = "Race  Car";             //true
//        String s = "Race a Car";             //false
//        String s ="A man, a plan, a canal: Panama";    // true
//        String s ="0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if(s.isBlank()) return true;
//        s=s.replaceAll("[^a-zA-Z0-9]","");     // remove all white spaces
//        StringBuilder sb = new StringBuilder(s.toLowerCase());  // make continuous string without spaces
//        int midpoint = sb.length()/2;
//        boolean result = true;
//        for(int i =0,j=sb.length()-1;i<=midpoint-1;i++,j--) {
//            if(sb.charAt(i)!=sb.charAt(j)){
//                result=false;
//                break;
//            }
//        }
//        return result;

        // Simple Solution

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString().equals(sb.reverse().toString());


    }
}
