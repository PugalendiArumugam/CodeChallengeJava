package LeetCode.Medium;

import java.util.*;

/*
Example 1:
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"

Example 2:
Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.

 */
public class BullsAndCows {
    public static void main(String[] args) {
        BullsAndCows bc = new BullsAndCows();
//        System.out.println(bc.getHint("1807","7810"));
//        System.out.println(bc.getHint("1123","0111"));
        System.out.println(bc.getHint("1122","2211"));   //expected "0A4B"   //failed with "0A1B"
    }

    public String getHint(String secret, String guess) {
        if(secret.length()!=guess.length()) return "";
        Map<Integer,Integer> secretMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
//        Map<Integer,Integer> guessMap = new HashMap<>();
//        int[] guessArray = new int[guess.length()];
//        Arrays.fill(guessArray,-1);
        int cows=0,bulls=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
              bulls++;
            } else {
                secretMap.put((int)secret.charAt(i),i-bulls);
//                guessMap.put((int)guess.charAt(i),i-bulls);
                int j=(int)guess.charAt(i);
                if(!list.contains(j))  list.add(j);
//                guessArray[i-bulls]=(int)guess.charAt(i);
            }
        }

        int k=0;
        for(int i: list){
            int val = secretMap.getOrDefault(i,-1);
            if(val!=-1){
                if(val!=k) cows++;
            }
            k++;
        }

        //count cows
//        for(int i=0;i<guessArray.length;i++){
//            if(guessArray[i]!=-1){
//                Integer val = secretMap.getOrDefault(guessArray[i],-1);
//                if(val!=-1) {
//                    if(val!=i) cows++;
//                }
//            }
//        }


//        int i =0;
//        for(int c: guessMap.keySet()){
//            i= guessMap.getOrDefault()
//            Integer val = secretMap.getOrDefault((int)c,-1);
//            if(val!=-1) {
//              if(val!=i) cows++;
//            }
//            i++;
//        }
        return bulls+"A"+cows+"B";
    }
}
