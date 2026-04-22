package DSA.TwoPointers;

public class CheckPalindrome {
    public static void main(String[] args) {
        String s1 = "level";
        String s2 = "malayalam";
        String s3 = "java";
        System.out.println(s1+" tp "+isPalindrome(s1));
        System.out.println(s2+" tp "+isPalindrome(s2));
        System.out.println(s3+" tp "+isPalindrome(s3));

        System.out.println(s1+" sb Rev "+isPalindromeSbRevers(s1));
        System.out.println(s2+" sb Rev "+isPalindromeSbRevers(s2));
        System.out.println(s3+" sb Rev "+isPalindromeSbRevers(s3));


    }

    static boolean isPalindrome(String s){
        int left = 0, right=s.length()-1;

        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeSbRevers(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

}
