package LeetCode.Medium;

/*
Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".



Example 1:
Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.

Example 2:
Input: a = "a", b = "aa"
Output: 2

 */
public class RepeatedStringMatch {

    public static void main(String[] args) {
        RepeatedStringMatch rsm = new RepeatedStringMatch();
        System.out.println(rsm.repeatedStringMatch("abcd","cdabcdab"));  //3
        System.out.println(rsm.repeatedStringMatch("a","aa")); //2
        System.out.println(rsm.repeatedStringMatch("aa","a"));  //1
        System.out.println(rsm.repeatedStringMatch("abc", "cabcabca"));  //4
        System.out.println(rsm.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));  //2
        System.out.println(rsm.repeatedStringMatch("aa","aa"));  //1
    }


    public int repeatedStringMatch(String a, String b) {
        if (b.isEmpty()) return 0;
        int alen = a.length();
        int blen = b.length();
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        int counter=1;
        if(blen>alen){
            int repeat = (blen/alen)+2;
            for(int i=0;i<repeat;i++){
                if(sb.indexOf(b)!=-1) return counter;
                sb.append(a);
                counter++;
            }
        } else {
            if(sb.indexOf(b)!=-1) return counter;
            sb.append(a);
            counter++;
            if(sb.indexOf(b)!=-1) return counter;
        }
        return -1;
    }

    public int repeatedStringMatch1(String a, String b) {
        if (b.isEmpty()) return 0;
        int alen = a.length();
        int blen = b.length();
        StringBuilder sb = new StringBuilder();
        int repeat = (blen + alen-1) / alen;
        sb.append(a.repeat(repeat));
        for(int i=0;i<2;i++){
            if(sb.indexOf(b)!=-1) return repeat;
            repeat++;
            sb.append(a);
        }
        return -1;
    }
}
