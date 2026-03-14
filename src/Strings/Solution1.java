package Strings;

public class Solution1 {
    public static void main(String[] args) {
        String s1 = "Hello";     // string pool
        String s2 = new String("Hello");    // in heap memory

        System.out.println(s1==s2);   //false. s1 and s2 are two different objects

        s2 = s2.intern();

        System.out.println(s1==s2);   //true.  intern will point Hello to string pool string Hello.

    }
}
