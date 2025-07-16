package LeetCode.Easy;

/* 290
Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
The bijection can be established as:
'a' maps to "dog".
'b' maps to "cat".

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 */


import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        String p = "aaaa";
        String s =  "dog cat cat dog";
        System.out.println(wp.wordPattern(p,s));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length!=pattern.length()) return false;
        Map<Character,String> chkWordMap = new HashMap<>();
        Map<String,Character> chkReverse = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String word = words[i];
            if(!chkWordMap.getOrDefault(c,word).equals(word) || !chkReverse.getOrDefault(word,c).equals(c)){
                return false;
            }
            chkWordMap.put(c,word);
            chkReverse.put(word,c);
        }
        return true;
    }

}
