package LeetCode.Easy;
/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0
Explanation:
The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
 */
public class FirstUniqueCharacter {
    public static void main(String[] args) {
        FirstUniqueCharacter fuc = new FirstUniqueCharacter();
        System.out.println(fuc.firstUniqChar("leetcode"));     //0
        System.out.println(fuc.firstUniqChar("loveleetcode"));  //2
        System.out.println(fuc.firstUniqChar("aabb"));    //-1
    }

    public int firstUniqChar(String s) {
        int[] charArray = new int[26];
        int slen = s.length();
        for(int i=0;i<slen;i++){
            charArray[s.charAt(i)-'a']++;
        }
        for(int i=0;i<slen;i++){
            if(charArray[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }

    // another solution faster than above
    public int firstUniqChar1(String s) {
        int[] arr = new int[26];
        char[] charArr = s.toCharArray();
        for(char i: charArr) {
            arr[i-'a']++;
        }
        for(int i=0; i< charArr.length;i++) {
            if(arr[charArr[i]-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }



}
