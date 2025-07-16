package LeetCode;

/*
Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
 */

public class DefangingIpAddress {
    public static void main(String[] args) {
        String s = "1.1.1.1";
//        String s = "255.100.50.0";
        System.out.println(defangIPaddr(s));
    }

    public static String defangIPaddr(String address) {
        String[] sarray = address.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        int len = sarray.length;
        for(int i=0;i<sarray.length;i++){
            stringBuilder.append(sarray[i]+((i!=len-1) ? "[.]":""));
        }

        return stringBuilder.toString();
    }
}
