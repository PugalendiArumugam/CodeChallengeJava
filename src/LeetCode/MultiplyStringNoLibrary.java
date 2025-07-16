package LeetCode;

public class MultiplyStringNoLibrary {
    public static void main(String[] args) {
//        String s1 = "123";
//        String s2 = "456";    //"56088"
//        String s1 = "2";
//        String s2 = "3";    //"6"

        String s1 = "0";
        String s2 = "0";    //"0"

        System.out.println(multiply(s1,s2));
    }

    public static String multiply(String num1, String num2){
        if (num1.isBlank() && num2.isBlank()) return "";
        else if (num1.isBlank()) return num2;
        else if(num2.isBlank()) return num1;
        int len1 = num1.length();
        int len2 = num2.length();
        int[] val = new int[len1+len2];
        int iteration = 0;

        for (int i=len1-1;i>=0;i--){
            int num1Digit =  num1.charAt(i) - '0';
            int carry=0;
            int k = val.length-1;
            int product = 0;
            for (int j=len2-1;j>=0;j--){
                int num2Digit =  num2.charAt(j) - '0';
                product = (num1Digit*num2Digit)+carry+val[k+iteration];
                val[k+iteration] = product%10;
                carry = product/10;
                k--;
            }
            if (carry!=0) val[k+iteration] = carry;
            iteration--;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int s: val){
            if(flag && s==0) {
                continue;
            } else flag=false;

            sb.append(s);
        }
        if(flag) sb.append("0");
        return sb.toString();
    }

}
