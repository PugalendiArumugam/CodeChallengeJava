package LeetCode;

//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.

public class IndexOfFirstOccurance {
    public static void main(String[] args) {
//        String str = "sadbutsadii";
//        String needle = "adb";
//        String str = "leetcode";
//        String needle = "leeto";
//        String str = "baabbbbababbbabab";
//        String needle = "abbab";
        String str = "ababcaababcaabc";
        String needle = "ababcaabc";
        int result = solution(str,needle);
        System.out.println(result);
    }

    public static int solution(String haystack, String needle){
//        final int lenHaystack = haystack.length();
//        final int lenNeedle = needle.length();
//        if(haystack.isEmpty() || needle.isEmpty()) return -1;
//        if(haystack.isBlank() || needle.isBlank()) return -1;
//        double needleval = 0;
//        double resultval;
//        int result =-1;
//        for(int i=0; i<lenNeedle;i++){
//            needleval+= needle.charAt(i)*(Math.pow(10,i));
//        }
//        for(int i =0;i+lenNeedle-1<lenHaystack;i++){
//            resultval=0;
//            for(int j =0;j<lenNeedle;j++) {
//                resultval+=haystack.charAt(j+i)*(Math.pow(10,j));
//            }
//            if(resultval == needleval) {
//                result=i;
//                break;
//            }
//        }
//        return result;

        // 1) other simple solution
//        return haystack.indexOf(needle);

        // 2)

        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i,needle.length()+i).equals(needle)){
                    return i;
                }
            }

        }
        return -1;

    }
}
