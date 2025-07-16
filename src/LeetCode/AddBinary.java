package LeetCode;

public class AddBinary {
    public static void main(String[] args) {

//        String s1 ="1101";
//        String s2 ="111";
//        String s1 ="11";
//        String s2 ="1";
//        String s1 ="1010";
//        String s2 ="1011";
        String s1 ="1";
        String s2 ="111";

        System.out.println(addBinary(s1,s2));
    }

    public static String addBinary(String a, String b){

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum =0;
        int i=a.length();
        int j=b.length();
        while (i-1>=0 || j-1>=0) {
            if (i-1>=0 && j-1>=0) {
                sum = a.charAt(i-1) - '0' +b.charAt(j-1) - '0' +carry;
            } else if (i-1>=0) {
                sum = a.charAt(i-1) - '0' +carry;
            } else if (j-1>=0) {
                sum = b.charAt(j-1) - '0' +carry;
            }
            if(sum==0) {
                carry=0;
                sb.append('0');
            } else if(sum==1){
                carry=0;
                sb.append('1');
            } else if(sum==2){
                carry=1;
                sb.append('0');
            } else if(sum==3){
                carry=1;
                sb.append('1');
            }
            j--;i--;
        }
        if (carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }
}
