package LeetCode;

import java.util.*;

public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        String s1 ="287";
        List<String> result = new ArrayList<>();
        result = letterCombinations(s1);
        System.out.println(result);
    }

    public static List<String> letterCombinations(String digits) {

        if(digits.isBlank()) return new ArrayList<>();
        if(digits.length()>4) return new ArrayList<>();

        List<String> result = new ArrayList<>();

        String[] phoneLetters = new String[]{"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};

        int i=0;

        // use recursive to make it fast

        recurseProcess(digits,phoneLetters,0, result, new StringBuilder());
//        backtrack(result, phoneLetters, digits, new StringBuilder(), 0);


        return result;

    }

    public static void recurseProcess(String digits,String[] phoneLetters,int index, List<String> result, StringBuilder sb) {

        if (index >= digits.length()){
            result.add(sb.toString());
            return;
        };

        char digit = digits.charAt(index);
//        List<String> tmp = new ArrayList<>();
        String letters = phoneLetters[digit - '0'];

//        for (String firstlvl : result) {
            for (char letter : letters.toCharArray()) {
//                sb.append(firstlvl+letter);
                sb.append(letter);
                recurseProcess(digits,phoneLetters,index+1, result, sb);
                sb.deleteCharAt(sb.length()-1);
//                tmp.add(firstlvl + letter);
            }
//        }
    }

    private static void backtrack(List<String> result, String[] phoneMap,
                                  String digits, StringBuilder path, int index) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = phoneMap[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            path.append(letter);
            backtrack(result, phoneMap, digits, path, index + 1);
            path.deleteCharAt(path.length() - 1); // Backtrack
        }
    }

}
