package LeetCode.Medium;
/*
Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
A query word queries[i] matches pattern if you can insert lowercase English letters into the pattern so that it equals the query. You may insert a character at any
position in pattern or you may choose not to insert any characters at all.



Example 1:
Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".

Example 2:
Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
Output: [true,false,true,false,false]
Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".

Example 3:
Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
Output: [false,true,false,false,false]
Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CamelCaseMatching {
    public static void main(String[] args) {
        CamelCaseMatching ccm = new CamelCaseMatching();
        String[] s1 = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};  //FB
        String[] s2 = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};  //FoBa
        String[] s3 = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};  //FoBaT
        String[] s4 = new String[]{"CompetitiveProgramming","CounterPick","ControlPanel"};  //CooP        // False, false, True.
        System.out.println(ccm.camelMatch(s1, "FB"));
        System.out.println(ccm.camelMatch(s2, "FoBa"));
        System.out.println(ccm.camelMatch(s3, "FoBaT"));
        System.out.println(ccm.camelMatch(s4, "CooP"));
    }

    public List<Boolean> camelMatch1(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        List<String> patternChars = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(pattern.charAt(0));
        for (int i = 1; i < pattern.length(); i++) {
            char currC = pattern.charAt(i);
            if (Character.isLowerCase(currC)) {
                sb.append(currC);
            } else {
                patternChars.add(sb.toString());
                sb = new StringBuilder(currC + "");
            }
        }
        patternChars.add(sb.toString());
        outer:
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            int k = 0;
            String pat = patternChars.get(k);
            for (int j = 0; j < s.length(); j++) {        // start after the first pattern matching
                char chk = s.charAt(j);
                if (Character.isUpperCase(chk)) {
                    if (s.indexOf(pat) == j) {
                        k++;
                        if (k >= patternChars.size()) {
                            for (int l = j + 1; l < s.length(); l++) {
                                char chk1 = s.charAt(l);
                                if (Character.isUpperCase(chk1)) {
                                    res.add(false);
                                    continue outer;
                                }
                            }
                            res.add(true);
                            continue outer;
                        }
                        pat = patternChars.get(k);
                    } else {
                        res.add(false);
                        continue outer;
                    }
                }
            }
            res.add(false);
        }
        return res;
    }


    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String word : queries) {
            res.add(chkMatch(word, pattern));
        }
        return res;
    }

    private boolean chkMatch(String query, String pattern) {
        int ql = query.length();
        int pl = pattern.length();
        int qi = 0, pi = 0;
        while (pi < pl) {
            while (qi < ql && query.charAt(qi) != pattern.charAt(pi)
                    && Character.isLowerCase(query.charAt(qi))) {
                qi++;
            }
            if (qi == ql || query.charAt(qi) != pattern.charAt(pi)) {
                return false;
            }
            qi++;
            pi++;
        }
        while (qi < ql && Character.isLowerCase(query.charAt(qi))) {
            qi++;
        }
        return qi == ql;
    }

}
