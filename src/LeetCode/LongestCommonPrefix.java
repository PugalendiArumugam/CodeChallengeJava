package LeetCode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[] {"flower","flow","flight"};
//        String[] strs = new String[] {"dog","racecar","car"};
        String result = solution(strs);
        System.out.println(result);
    }

    public static String solution(String[] strs) {

//        StringBuilder resultStr = new StringBuilder();
//
//        resultStr.append(strs[0]);
//
//        for (int i = 1;i<strs.length;i++){
//            StringBuilder nextString = new StringBuilder();
//            nextString.append(strs[i]);
//            StringBuilder matchedString = new StringBuilder();
//            for (int j =0; (j<resultStr.length() && j<nextString.length());j++){
//                // compare with second and third
////                char s1 = resultStr.charAt(j);
////                char s2 = nextString.charAt(j);
//                if (resultStr.charAt(j) == nextString.charAt(j)){
//                    matchedString.append(resultStr.charAt(j));
//                } else break;
//            }
//            resultStr = matchedString;
//        }
//        return resultStr.toString();
//    }


        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

}
