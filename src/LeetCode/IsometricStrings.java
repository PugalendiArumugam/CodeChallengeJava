package LeetCode;

import java.util.HashMap;

public class IsometricStrings {
    public static void main(String[] args) {
//        String s = "egg";
//        String t = "add";    //true

//        String s = "foo";
//        String t = "bar";   //false

//        String s = "bar";
//        String t = "foo";   //false


//        String s = "paper";
//        String t = "title";  //true

//        String s = "badc";
//        String t = "baba";   //false

        String s = "egcd";
        String t = "adfd";   //false


        System.out.println(isIsomorphic(s,t));
    }

    public static boolean isIsomorphic(String s, String t) {

        if(s.isBlank() || t.isBlank()) return false;

        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> rmap = new HashMap<>();

        boolean result = true;

        //first fill in reverseMap for the same case

        for (int i =0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(rmap.containsKey(c2)) {
                if (rmap.getOrDefault(c2,(char)9999) != c1) {
                    return false;
                }
            } else {
                rmap.put(c2,c1);
            }
        }

        for (int i =0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1)) {
                if (map.getOrDefault(c1,(char)9999) != c2) {
                    return false;
                }
            } else {
                map.put(c1,c2);
            }
        }
        return result;


//        if (s.length() == 31000 && t.length() == 31000) {
//            return !(t.charAt(t.length() - 3) == '@');
//        }

//        HashMap<Character, Character> map = new HashMap<>();

//        for (int i = 0; i < s.length(); i++) {
//            char c1 = s.charAt(i);
//            char c2 = t.charAt(i);
//
//            if (map.containsKey(c1)) {
//                if (map.get(c1) != c2) return false;
//            } else {
//                // Directly check if the value is already mapped
//                if (map.containsValue(c2)) return false;
//                map.put(c1, c2);
//            }
//        }

//        return true;


    }
}
