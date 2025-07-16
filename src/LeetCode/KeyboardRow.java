package LeetCode;

import java.util.Arrays;

/*
Example 1:
Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
Explanation:
Both "a" and "A" are in the 2nd row of the American keyboard due to case insensitivity.

Example 2:
Input: words = ["omk"]
Output: []

Example 3:
Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]
 */
public class KeyboardRow {
    public static void main(String[] args) {
//        String[] sa = new String[]{"Hello","Alaska","Dad","Peace"};    //["Alaska","Dad"]
        String[] sa = new String[]{"omk"};  // []
//        String[] sa = new String[]{"adsdf","sfd"}; // both words are valid
        System.out.println(Arrays.toString(findWords(sa)));

    }

    public static String[] findWords(String[] words) {
        String base = "qwertyuiop^asdfghjkl^zxcvbnm"; //0-9,11-19,21-27
        if(words.length==0) return new String[0];
        StringBuilder result = new StringBuilder();
        outer: for(int i=0;i<words.length;i++){
            StringBuilder kbRow = new StringBuilder();
            int len = words[i].length();
            if (len==0) continue;
            String word = words[i];
            int range = base.indexOf(word.substring(0,1).toLowerCase());
            if(range<10) kbRow.append("qwertyuiop");
            else if(range <20) kbRow.append("asdfghjkl");
            else kbRow.append("zxcvbnm");
            for(int j=1;j<word.length();j++){
                int curr = kbRow.indexOf(word.substring(j,j+1).toLowerCase());
                if(curr==-1) {
                    continue outer;
                }
            }
            result.append(word);
            if(i!= words.length-1) result.append("^");
        }
            if(!result.isEmpty()) {
                return result.toString().split("\\^");
            }
            else {
                return new String[0];
            }
    }
}
