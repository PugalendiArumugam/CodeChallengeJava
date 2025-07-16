package LeetCode.Easy;
/*
Example 1:
Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:
Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:
Input: num1 = "0", num2 = "0"
Output: "0"
 */
public class AddStringNumbers {
    public static void main(String[] args) {
        AddStringNumbers asn = new AddStringNumbers();
        System.out.println(asn.addStrings("11", "123"));
        System.out.println(asn.addStrings("456", "77"));
        System.out.println(asn.addStrings("0", "0"));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int max = Math.max(num1.length(), num2.length());
        int carry = 0;
        int len1=num1.length()-1;
        int len2=num2.length()-1;
        for (int i = max-1; i >= 0; i--) {
            int temp1 = 0, temp2 = 0;
            if (len1 >= 0) {
                temp1 = num1.charAt(len1--) - '0';
            }
            if (len2 >= 0) {
                temp2 = num2.charAt(len2--) - '0';
            }
            int val = temp1+temp2+carry;
            carry=val/10;
            val=val%10;
            sb.append(val);
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
