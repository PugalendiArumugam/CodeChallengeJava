package LeetCode;

public class ReverseDegreeOfString {
    public static void main(String[] args) {
//        String s1 = "abc";
        String s1 ="zaza";
        System.out.println(reverseDegree(s1));
    }

    public static int reverseDegree(String s) {
        int total =0;
        for(int i=0;i<s.length();i++){
            int val = ((s.charAt(i)-('a'))*(-1)+26) * (i+1);
            total+=val;
        }
        return total;
    }
}
