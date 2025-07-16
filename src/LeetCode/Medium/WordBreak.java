package LeetCode.Medium;

import java.util.*;

/*
139. Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak wb=new WordBreak();
//        String s = "leetcodegood";
//          String s = "aaaaaaa";
//          List<String> dict = List.of("aaaa","aaa");
        String s = "catsandog";
//        String s ="ab";
//        List<String> dict = List.of("leet","code","good");
        List<String> dict = List.of("cats","dog","sand","and","cat","san");
//        List<String> dict = List.of("a","b","bbb","bbbb");   //String is "bb"  expected true.
        System.out.println(wb.wordBreak(s,dict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.isEmpty()) return false;
        Set<String> set = new HashSet<>(wordDict);
        int slen = s.length();
        Boolean[] dpTable = new Boolean[slen+1];
        Arrays.fill(dpTable,false);
        dpTable[0]=true;
        for(int i=1;i<=slen;++i){
            for(int j=0;j<i;++j){
              if(dpTable[j] && set.contains(s.substring(j,i))){
                  dpTable[i]=true;
                  break;
              }
            }
        }
        return dpTable[slen];
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        Boolean[] memo = new Boolean[s.length()];
//        return dp(s.length() - 1, s, wordDict, memo);
//    }
//
//    private boolean dp(int i, String s, List<String> wordDict, Boolean[] memo) {
//        if (i == -1) {
//            // before the beginning index
//            return true;
//        }
//        if (memo[i] != null) {
//            return memo[i];
//        }
//
//        for (String w: wordDict) {
//            int beforeIdx = i - w.length() + 1;
//            if (beforeIdx < 0) {
//                continue;
//            }
//            if (s.substring(beforeIdx, i + 1).equals(w) && dp(beforeIdx - 1, s, wordDict, memo)) {
//                memo[i] = true;
//                return true;
//            }
//        }
//        memo[i] = false;
//        return false;
//    }


}
