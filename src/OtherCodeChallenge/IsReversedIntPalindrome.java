public class IsReversedIntPalindrome {
    public static void main(String[] args) {
        int i = 2345432;
        boolean result = checkPalindrome(i);
        if (result) {
            System.out.println("Number is a Palindrome");
        } else System.out.println("The number is not a Palindrome");
    }

    public static boolean checkPalindrome(int val) {
        long reversed = 0;
        int input = val;

        if (val <0 ) return false;

        while (val>0){
             reversed = (reversed * 10)+ val % 10;
             val /= 10;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return false;
        }
        if( reversed == input) {
            return true;
        }

        return false;
    }
}
