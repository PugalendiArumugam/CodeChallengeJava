package LeetCode.Medium;

//You are given two string arrays words1 and words2.
//A string b is a subset of string a if every letter in b occurs in a including multiplicity.
//For example, "wrr" is a subset of "warrior" but is not a subset of "world".
//A string a from words1 is universal if for every string b in words2, b is a subset of a.
//Return an array of all the universal strings in words1. You may return the answer in any order.
//
//        Example 1:
//        Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
//        Output: ["facebook","google","leetcode"]
//
//        Example 2:
//        Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["lc","eo"]
//        Output: ["leetcode"]
//
//        Example 3:
//        Input: words1 = ["acaac","cccbb","aacbb","caacc","bcbbb"], words2 = ["c","cc","b"]
//        Output: ["cccbb"]

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String subsetWord : words2) {
            int[] tmp = new int[26];
            for (char ch : subsetWord.toCharArray()) {
                tmp[ch - 'a']++;
                maxFreq[ch - 'a'] = Math.max(maxFreq[ch - 'a'], tmp[ch - 'a']);
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] wordFreq = new int[26];
            for (char ch : word.toCharArray()) {
                wordFreq[ch - 'a']++;
            }
            boolean word1Flag = true;
            for (int i = 0; i < 26; ++i) {
                if (maxFreq[i] > wordFreq[i]) {
                    word1Flag = false;
                    break;
                }
            }
            if (word1Flag) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WordSubsets ws = new WordSubsets();
        System.out.println(ws.wordSubsets( new String[]{"apple","facebook","google","leetcode"}, new String[]{"e","o"}));
        System.out.println(ws.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"lc","eo"}));
        System.out.println(ws.wordSubsets(new String[]{"acaac","cccbb","aacbb","caacc","bcbbb"}, new String[]{"c","cc","b"}));
    }


}
