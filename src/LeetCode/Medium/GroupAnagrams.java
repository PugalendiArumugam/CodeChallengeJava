package LeetCode.Medium;

import java.util.*;

/*
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
 */

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs1 = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = new String[]{""};
        String[] strs3 = new String[]{"a"};
        String[] strs4 = new String[]{"mod","mop","pip","tug","hop","dog","met","zoe","axe","mug","fdr","for","fro","fdr","pap","ray","lop","nth","old","eva","ell","mci","wee","ind","but","all","her","lew","ken","awl","law","rim","zit","did","yam",
                "not","ref","lao","gab","sax","cup","new","job","new","del","gap","win","pot","lam","mgm","yup","hon","khz","sop","has","era","ark"};
//        System.out.println(ga.groupAnagrams(strs1));
//        System.out.println(ga.groupAnagrams(strs2));
//        System.out.println(ga.groupAnagrams(strs3));
        System.out.println(ga.groupAnagrams(strs4));
    }


    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<Long,List<String>> map = new HashMap<>();
//        for(String word: strs){
//            Long key = getUniqueKey(word);
//            map.computeIfAbsent(key, k-> new ArrayList<>()).add(word);
//        }
//        List<List<String>> result = new ArrayList<>(map.values());
//        List<List<String>> dummy = new ArrayList<>();
//        for(List<String> x: result ){
//            Collections.sort(x);
//            dummy.add(x);
//        }
//        return dummy;

        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] charArray = word.toCharArray();

            Arrays.sort(charArray);

            String sortedKey = String.valueOf(charArray);

            map.computeIfAbsent(sortedKey, key -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

//    public Long getUniqueKey(String str){
//        long total=0;
//        for(int i=0;i<str.length();i++){
//            int c = str.charAt(i)*(str.charAt(i)-'a'+1);
//            total+=c;
//        }
//        return total;
//    }
/*
"mod","mop","pip","tug","hop","dog","met","zoe","axe","mug","fdr","for","fro","fdr","pap","ray","lop","nth","old","eva","ell","mci","wee","ind","but","all","her","lew","ken","awl","law","rim","zit","did","yam",
"not","ref","lao","gab","sax","cup","new","job","new","del","gap","win","pot","lam","mgm","yup","hon","khz","sop","has","era","ark"]
 */

/*
[["all"],["sop"],["mop"],["pot"],["lop"],["met"],["not"],["ken"],["del"],["ell"],["mod","axe"],["old"],["awl","law"],["wee"],["zit"],["has"],["sax"],["new","new"],["pip"],["gap"],["ray"],["lew"],["yam"],["khz"],
["her"],["rim"],["hop"],["cup"],["hon"],["ind"],["did"],["nth"],["era"],["zoe"],["ref"],["pap"],["dog"],["mgm"],["mci"],["win"],["job"],["for","fro"],["yup"],["but"],["lao"],["mug"],["gab"],["fdr","fdr"],["lam"],
["tug"],["ark"],["eva"]]
 */

/*
[["era"],["sop"],["khz"],["yup"],["lam"],["pot"],["win"],["del"],["job"],["cup"],["gab"],["has"],["lao"],["yam"],["zit"],["rim"],["hon"],["awl","law"],["mug"],["gap"],["fdr","fdr"],["lop"],["not"],["did"],["hop"],
["ken"],["mci"],["mgm"],["zoe"],["pip"],["all"],["axe"],["eva"],["ark"],["mod"],["mop"],["but"],["ind"],["sax"],["ray"],["nth"],["new","new"],["dog"],["old"],["ref"],["tug"],["ell"],["pap"],["wee"],["her"],["met"],
["for","fro"],["lew"]]
 */

/*
[[sax], [mod], [ind], [ark], [ken], [del], [gap], [mop], [zoe], [yup], [all], [pap], [lam], [ell], [lao], [job], [hon], [pip], [cup], [tug], [has], [awl, law], [zit], [her], [nth], [lew], [fdr, fdr], [pot], [sop],
[mgm], [mci], [for, fro], [hop], [yam], [lop], [met], [dog], [mug], [era], [rim], [not], [eva], [axe], [khz], [wee], [but], [old], [gab], [did], [ray], [new, new], [ref], [win]]

 */

}
