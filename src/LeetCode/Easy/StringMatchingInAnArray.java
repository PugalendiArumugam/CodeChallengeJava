package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

/*
1408. String Matching in an Array
Given an array of string words, return all strings in words that are a substring of another word. You can return the answer in any order.

Example 1:
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

Example 2:
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".

Example 3:
Input: words = ["blue","green","bu"]
Output: []
Explanation: No string of words is substring of another string.

 */
public class StringMatchingInAnArray {
    public static void main(String[] args) {
        StringMatchingInAnArray sm = new StringMatchingInAnArray();
        String[] s1 = new String[]{"mass","as","hero","superhero"};
        String[] s2 = new String[]{"leetcode","et","code"};
        String[] s3 = new String[]{"blue","green","bu"};
//        String[] s1 = new String[]{};
        long start = System.nanoTime();
        System.out.println(sm.stringMatching(s1));
        System.out.println(sm.stringMatching(s2));
        System.out.println(sm.stringMatching(s3));
        long elapsedTime = (System.nanoTime() - start) / 1000000;
        System.out.println(elapsedTime+" ms");
    }

    public List<String> stringMatching1(String[] words) {
        List<String> res = new ArrayList<>();
        ounter: for(int i=0;i<words.length;i++){
            String word = words[i];
            for(int j=0;j< words.length;j++){
                if(i==j) continue;
                if(words[j].contains(word)){
                    res.add(word);
                    continue ounter;
                }
            }
        }
        return res;
    }

    // Simplest form.  by LeetCode.

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>(words.length);
        int i = 0;
        for (String s : words) {
            if (hasStr(s, words, i)) res.add(s);
            i++;
        }
        return res;
    }
    public boolean hasStr(String s, String[] arr, int i) {
        int j = 0;
        for (String str : arr) {
            if (j != i && str.indexOf(s) > -1) return true;
            j++;
        }
        return false;
    }


}
