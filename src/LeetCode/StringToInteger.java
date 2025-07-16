package LeetCode;

public class StringToInteger {
    public static void main(String[] args) {
        //String str = "words 0-1";
        // String str = "-91283472332";
        //        String str = "-+3";
        // String str = "2147483646";   // expected 2147483646
        String str = " -1010023630o4" ; // expected -1010023630
        int result = solution(str);
        System.out.println(result);
    }

    public static int solution(String s){
        int total = 0;
        int properDigit =0;             // at least one proper digit
        boolean isNegative = false;     // handle negative sign
        int i = 0;
        int length = s.length();

        if (s==null || length==0) return 0;

        while (s.charAt(i) == ' ') {
            i++;
            if (i==length) return 0;
        }
        if (s.charAt(i) == '-') {
            isNegative = true;
            properDigit++;
        }
        if (s.charAt(i)=='+') {
            properDigit++;
        }

        if(properDigit ==1) i++;

        for (; i<length;i++){
            char c = s.charAt(i);

            if (c<'0' || c>'9') break;

            if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && s.charAt(i)> '7') ) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            total = total*10 + (c-'0')%10;
            properDigit++;
        }

        if (isNegative) total*=-1;
        return total;

//        if (s == null) return 0;          // if no string go back
//        int len = s.length();             // take the length of the string
//        if (len == 0) return 0;           // length 0 return.
//        int i = 0;                        //
//        while (s.charAt(i) == ' ') {      // skip all the leading white spaces.
//            if (++i == len) return 0;     // if all of them are white space return 0.
//        }
//        int sign = 1;
//        if (s.charAt(i) == '-') sign = -1;   // first non-white space is valid negative character make it  sign = -1
//        if (s.charAt(i) == '-' || s.charAt(i) == '+') ++i;      // increase the pointer
//        int res = 0, flag = Integer.MAX_VALUE / 10;
//        for (; i < len; ++i) {
//
//            if (s.charAt(i) < '0' || s.charAt(i) > '9') break;    //  any character not in rage 0 -9 break the loop
//
//            if (res > flag || (res == flag && s.charAt(i) > '7'))
//                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            res = res * 10 + (s.charAt(i) - '0');
//        }
//        return sign * res;

    }
}
