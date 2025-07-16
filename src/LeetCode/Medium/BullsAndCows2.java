package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Example 1:
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"

Example 2:
Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.

 */
public class BullsAndCows2 {
    public static void main(String[] args) {
        BullsAndCows2 bc = new BullsAndCows2();
        System.out.println(bc.getHint("1807","7810"));
        System.out.println(bc.getHint("1123","0111"));
        System.out.println(bc.getHint("1122","2211"));   //expected "0A4B"   //failed with "0A1B"
    }

    public String getHint(String secret, String guess) {
        int bulls=0, cows=0;
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        for(int i=0;i<secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s==g) bulls++;
            else {
                secretCount[s-'0']++;
                guessCount[g-'0']++;
            }
        }
        for(int i=0;i<10;i++){
            cows += Math.min(secretCount[i],guessCount[i]);
        }
        return bulls+"A"+cows+"B";

// THIS IS FASTER LESS SPACE OCCUPIES-BETTER
//        StringBuilder ans = new StringBuilder();
//        ans.append(bulls);
//        ans.append('A');
//        ans.append(cows);
//        ans.append('B');

    }
}
